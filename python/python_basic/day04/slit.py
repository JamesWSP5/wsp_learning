# -*- coding:utf-8 -*-
# @Time : 2020/3/10 17:54
# @Author: wsp

# 切片：顾名思义把数据从中间切开,类似list,tuple的数据结构进行切片
L = [1, 2, 3, 4, 5, 6, 7]
print(L[0:3])
T = (1, 2, 3, 4, 5, 6, 7)
print(T[0:3])

Dic = {'bob': 50, 'jack': 60}

# 迭代
# 遍历LIST
for i in L:
    print(i)

# 遍历dic 默认遍历的是字典的key
for i in Dic:
    print(i)
# 遍历值
for i in Dic.values():
    print(i)
# 遍历K,V
for i, j in Dic.items():
    print(i, j)
# 此方法可以遍历数组的下标和原素
for i, j in enumerate(L):
    print(i, j)
