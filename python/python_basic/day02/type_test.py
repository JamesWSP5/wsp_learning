# -*- coding:utf-8 -*-
# @Time : 2019/12/13 17:34
# @Author: wsp

"""
list:数组
dict:map数据结构 key,value
set:key不重复在链表
"""

names = ['Michael', 'Bob', 'Tracy']
print(names[0:3])
scores = [95, 75, 85]

d = {'Michael': 95, 'Bob': 75, 'Tracy': 85}
print(d['Michael'])

s1 = set([1, 2, 3])
s2 = set([2, 3, 4])
print(s1.union(s2))


def fact(n):
    """
    递归求n的阶乘
    :param n: 阶乘对象
    :return:返回结果
    """
    if n == 1:
        return 1
    return n * fact(n - 1)


if __name__ == '__main__':
    result = fact(5)
    print(result)