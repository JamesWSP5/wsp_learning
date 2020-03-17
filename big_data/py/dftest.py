# -*- coding:utf-8 -*-
# @Time : 2020/3/12 14:08
# @Author: wsp
import pyspark.sql.functions as F

from big_data.py.wechat_share import *


class TestDataFrame():
    def __init__(self):
        super(TestDataFrame, self).__init__(env='LOCAL')
        self._spark.sparkContext.setLogLevel('WARN')

    def job(self):
        self.__test_method('user_ab_log_simple')

        pass

    def __test_method(self, table_name):
        sc = self._spark
        pointsdf = sc.read.csv('points.csv', "source int,log_type int,sub_log_type int,topic int")

        # pointsdf.foreach(self.sql_str())
        pointsdf.foreach(print)

        # print(pointsdf.dtypes)

        print(pointsdf.withColumn('key', F.lit('aa')).collect())
        print(pointsdf.union(pointsdf).show())
        points_result = pointsdf.collect()

        print(type(pointsdf))
        print(points_result)
        str0 = "("
        str1 = ''
        for i in points_result:
            t = i.asDict().items()
            count = 0
            for j, k in i.asDict().items():

                if count == 0:
                    str1 = "(%s.%s=%s" % (table_name, j, k)
                elif count == len(t) - 1:
                    str1 += " and %s.%s=%s) or" % (table_name, j, k)
                else:
                    str1 += " and %s.%s=%s" % (table_name, j, k)
                count = count + 1
            str0 += " \n" + str1
            str1 = ''
            # print('\n')
        str0 = str0[:len(str0) - 3] + ")"
        print(str0)

        print(result.format('unit_mls_share_count', str0))

    def sql_str(self, row=None):
        str0 = "("
        str1 = ''
        for i in row:
            t = i.asDict().items()
            count = 0
            for j, k in i.asDict().items():

                if count == 0:
                    str1 = "(%s.%s=%s" % ('table_name', j, k)
                elif count == len(t) - 1:
                    str1 += " and %s.%s=%s) or" % ('table_name', j, k)
                else:
                    str1 += " and %s.%s=%s" % ('table_name', j, k)
                count = count + 1
            str0 += " \n" + str1
            str1 = ''
            # print('\n')
        str0 = str0[:len(str0) - 3] + ")"
        print(str0)

        print(result.format('unit_mls_share_count', str0))

    pass

    # 将表中的结果拼接为字符串
    # pointsdf_pandas = pointsdf.toPandas()
    # str0 = ""
    # str1 = None
    # for i in pointsdf_pandas.iterrows():
    #     t = tuple(i[1].items())
    #     for j in range(len(t)):
    #         k, l = t[j]
    #         if j == 0:
    #             str1 = "(%s=%s" % (k, l)
    #         elif j == len(t)-1:
    #             str1 += " and %s=%s) or" % (k, l)
    #         else:
    #             str1 += " and %s=%s" % (k, l)
    #     str0 += " \n" + str1
    # str0 = str0[:len(str0) - 3]
    # print(str0)

    pass


if __name__ == '__main__':
    TestDataFrame().job()
