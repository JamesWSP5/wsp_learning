# -*- coding:utf-8 -*-
# @Time : 2020/3/9 18:58
# @Author: wsp

# 首先python有很多内置函数，ex:
# 求绝对值函数
print abs(100)
# 求最大值函数
print max(1, 3)
# 数据类型转换
print int('123')


# define functions
def my_abs(x):
    if not isinstance(x, (int, float)):
        raise TypeError('bad operand type')
    if x >= 0:
        return x
    else:
        return -x


# print my_abs('A')
# 返回多值,返回多值实际上返回的是一个tuple元组。
import math


def move(x, y, step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y - step * math.sin(angle)
    return nx, ny


x, y = move(100, 100, 60, math.pi / 6)
print x, y

result = move(100, 100, 60, math.pi / 6)
print result
