# -*- coding:utf-8 -*-
# @Time : 2020/3/6 16:55
# @Author: wsp


'''
条件判断
if 条件：
    结果1
eles 条件：
    结果2
根据判断条件是否成立的boolean值
'''

a = 20
if a > 20:
    print(a)
else:
    print(-a)

# input输入读取用户输入数据
# https://www.runoob.com/python/python-operators.html  关于python逻辑运算符教程
a = input('grade')
print(a)
if 60 <= a < 80:
    print('及格')
elif 80 <= a < 90:
    print('中等')
else:
    print ('优秀')
