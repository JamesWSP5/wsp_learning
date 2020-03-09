# -*- coding:utf-8 -*-
#@Time : 2020/3/6 17:10
#@Author: wsp

# 对比java中的数据类型
# python 中的数据类型

# 引入sys模块
import sys
from collections import defaultdict

print('命令行参数如下:')
for i in sys.argv:
    print(i)

print('\n\nPython 路径为：', sys.path, '\n')

# list数据类型
classmates = ['a', 'b', 'c']
print classmates
# list 有一些内置方法来操作list对象,下面是一些例子,可变长，可重复
classmates.append('a')
print classmates
print classmates.count('a')
print len(classmates)
classmates.insert(1, 'f')
print classmates
classmates.insert(1, 1)
print classmates
print classmates[1]
# tuple元组数据类型，初始化即定长定数据,tuple不可变，所以代码更安全。如果可能，能用tuple代替list就尽量用tuple。
pig = (1, 2, 3, 2)
print pig
for i in pig:
    print  i
# dit字典数据类型
grade = {'a': 70, 'b': 80, 'c': 90}
print grade
# grade.pop('c')
# print grade
print grade.values()
print grade.items()
grade_one = 0
for i in grade.values():
    if i < 90:
        grade_one = grade_one + 1
print grade_one
# 此处传播的是地址,为浅复制，所以并没有复制一份字典出来
grade_copy = grade
# 此处为深复制
grade_deep_copy = grade.copy()
for i in grade.keys():
    if grade[i] < 90:
        grade_deep_copy.pop(i)
        print type(i)
print grade
print grade_deep_copy
# 实现字典的K,V数据交换 py3.0
grade_exchange = {v: k for k, v in grade.iteritems()}
print grade_exchange
# 实现字典的K,V数据交换 py2.7
grade_exchange_2 = dict((v, k) for k, v in grade.iteritems())
print grade_exchange_2
# 有相同的key
d1 = {'a': 1, 'b': 2, 'c': 1}
d = defaultdict(list)
for k, v in d1.iteritems():
    d[v].append(k)
print d

# set数据类型
''' 
set和dict类似，也是一组key的集合，但不存储value。
由于key不能重复，所以，在set中，没有重复的key。
需要list进行初始化，但是可追加可变对象，因为无法hash存储。
'''
s = set([1, 2, 3])
print s

s1 = set([1, 1, 2, 2, 3, 3])
print s1

s1.add([1,2])