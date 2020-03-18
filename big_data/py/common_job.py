# -*- coding: utf-8 -*-

import logging

from pyspark.sql import SparkSession

logging.getLogger("py4j").setLevel(logging.ERROR)


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
        df.select('a').show()
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

    def write_to_csv(self, df, paths):
        for path in paths:
            df.repartition(1).write.csv(path=path, header=True, sep=",", mode='overwrite')




if __name__ == '__main__':
    Job().job()
    pass
