# -*- coding:utf-8 -*-
#@Time : 2020/3/12 16:25
#@Author: wsp
# -*- coding: utf-8 -*-
import pandas as pd
from pyspark.sql import SparkSession
from pyspark.sql import SQLContext
from pyspark import SparkContext

# 初始化数据

# 初始化pandas DataFrame
df = pd.DataFrame([[1, 2, 3], [4, 5, 6]], index=['row1', 'row2'], columns=['c1', 'c2', 'c3'])

# 打印数据
print(df)

# 初始化spark DataFrame
sc = SparkContext()
if __name__ == "__main__":
    spark = SparkSession \
        .builder \
        .appName("testDataFrame") \
        .getOrCreate()

sentenceData = spark.createDataFrame([
    (0.0, "I like Spark"),
    (1.0, "Pandas is useful"),
    (2.0, "They are coded by Python ")
], ["label", "sentence"])

# 显示数据
sentenceData.select("label").show()

# spark.DataFrame 转换成 pandas.DataFrame
sqlContest = SQLContext(sc)
spark_df = sqlContest.createDataFrame(df)

# 显示数据
spark_df.select("c1").show()

# pandas.DataFrame 转换成 spark.DataFrame
pandas_df = sentenceData.toPandas()

# 打印数据
print(pandas_df)
