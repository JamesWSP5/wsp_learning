# -*- coding:utf-8 -*-
# @Time : 2020/3/9 18:58
# @Author: wsp

# 首先python有很多内置函数，ex:
# 求绝对值函数
print(abs(100))
# 求最大值函数
print(max(1, 3))
# 数据类型转换
print(int('123'))


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
print(x, y)

result = move(100, 100, 60, math.pi / 6)
print(result)

# 匿名函数
print(list(map(lambda x: x * x, [1, 2, 3, 4, 5, 6, 7, 8, 9])))


def is_odd(n):
    return n % 2 == 1


L = list(filter(is_odd, range(1, 20)))
print(L)

L = list(filter(lambda x: x % 2 == 1, range(1, 20)))
print(L)

# 偏函数 Python的functools模块提供了很多有用的功能，其中一个就是偏函数（Partial function）。
# 要注意，这里的偏函数和数学意义上的偏函数不一样。00000
# 在介绍函数参数的时候，我们讲到，通过设定参数的默认值，可以降低函数调用的难度。而偏函数也可以做到这一点。举例如下：
# int()函数可以把字符串转换为整数，当仅传入字符串时，int()函数默认按十进制转换：

i = int('1235', base=16)
print(i)
