# -*- coding:utf-8 -*-
from os.path import abspath

from pyspark.sql import SparkSession


def test_01():
    warehouse_location = abspath('spark-warehouse')
    log_level = "WARN"

    spark_config = SparkSession \
        .builder \
        .appName("spark") \
        .config("spark.sql.warehouse.dir", warehouse_location) \
        .enableHiveSupport()
    spark_config.master("local")
    spark = spark_config.getOrCreate()
    spark.sparkContext.setLogLevel(log_level)
    df = spark.read.csv("query-hive-1513.csv",header=True)
    df.replace(10, 0)
    df.rdd
    df_collect = df.collect
    # print df_collect
    # df.filter()
    df.withColumn('a1', df._c1 + 1).show()
    print df.count()
    print df.take(2)
    print df.toJSON().take(1)
    # df.agg()
    # df.alias
    # df.show
    # df.replace
    # df.rdd
    # df.collect
    # df.filter
    # df.withColumn
    # df.toDF
    # df.count
    # df.take
    # df.toJSON
    # df.agg
    # df.alias
    # df.approxQuantile
    # df.cache
    # df.checkpoint
    # df.coalesce
    # df.colRegex
    # df.columns
    # df.corr
    # df.cov
    # df.createGlobalTempView
    # df.createOrReplaceGlobalTempView
    # df.createTempView
    # df.crossJoin
    # print df.show(100, truncate=False, vertical=True)


if __name__ == '__main__':
    test_01()
