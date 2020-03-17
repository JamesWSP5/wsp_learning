# -*- coding: utf-8 -*-

import logging

from pyspark.sql import SparkSession

logging.getLogger("py4j").setLevel(logging.WARNING)


class Job(object):

    def __init__(self, log_level="INFO", name='default'):

        self._spark = SparkSession \
            .builder \
            .appName(name) \
            .getOrCreate()
        Logger = self._spark._jvm.org.apache.log4j.Logger
        self._logger = Logger.getLogger(name)
        pass

    def job(self):
        df = self._spark.createDataFrame([(1, 2, 3,), (1, 2, 3,), (1, 2, 3,)], ["a", "b", "c"])
        df.printSchema()
        self._logger.warn(df.collect())
        pass

    def _sql_to_cache(self, sql, temp_name):
        self._logger.info("Job _sql_to_cache sql={}".format(sql))

        df = self._spark.sql(sql)
        df.createOrReplaceTempView(temp_name)
        self._spark.catalog.cacheTable(temp_name)
        return df

    def _df_to_cache(self, df, temp_name):
        self._logger.info("Job _df_to_cache temp_name={}".format(temp_name))

        df.createOrReplaceTempView(temp_name)
        self._spark.catalog.cacheTable(temp_name)
        return df

    def _sql_to_global_cache(self, sql, temp_name):
        self._logger.info("Job _sql_to_global_cache sql={}".format(sql))

        df = self._spark.sql(sql)
        df.createOrReplaceGlobalTempView(temp_name)
        self._spark.catalog.cacheTable(temp_name)
        return df

    def _binding_partition_datas(self, table_name):
        self._spark.sql("MSCK REPAIR TABLE {table_name}".format(table_name=table_name))

    def _common_sql_to_log(self, sql, each_record=lambda record: [RecordResult(None, 0, 0)]):
        exe_sql = sql
        self._logger.info("Job _common_sql_to_log exe_sql={}".format(exe_sql))

        df = self._spark.sql(exe_sql)
        for one_df in df.collect():
            self._logger.info("Job _common_sql_to_log one_df={}".format(one_df))

            results = each_record(one_df)
            if results:
                for result in results:
                    if result.value is not None:
                        self._log_service.add_log(result.log_type.source,
                                                  result.log_type.topic,
                                                  result.log_type.log_type,
                                                  result.log_type.sub_log_type,
                                                  city=result.city,
                                                  flag=result.flag,
                                                  value=result.value,
                                                  time=result.time,
                                                  data=result.data,
                                                  sub_log_type_sign=result.sub_log_type_sign,
                                                  id=result.id,
                                                  )
                    pass
            pass
        self._log_service.upload()
        pass

    def query_log(self, startTime, endTime, query):

        keys, datas = self._aliyun_log_service.query_sql_for_df(startTime, endTime, query)

        return self._spark.createDataFrame(datas, schema=keys)

    def write_to_csv(self, df, paths):
        for path in paths:
            df.repartition(1).write.csv(path=path, header=True, sep=",", mode='overwrite')


class RecordResult(object):
    def __init__(self, log_type, value, time, city=0, flag=1, data={}, sub_log_type_sign=None, id=None):
        self.log_type = log_type
        self.value = value
        self.time = time
        self.city = city
        self.flag = flag
        self.data = data
        self.sub_log_type_sign = sub_log_type_sign
        self.id = id
        pass


if __name__ == '__main__':
    Job().job()
    pass
