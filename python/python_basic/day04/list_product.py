# -*- coding:utf-8 -*-
# @Time : 2020/3/10 19:03
# @Author: wsp

# 生成list
L = list(range(1, 11))
print(L)

L1 = []
for i in range(1, 11):
    L1.append(i * i)
print(L1)

L2 = [x * x for x in range(1, 10)]
print(L2)

L3 = [m + n for m in 'abc' for n in 'xyz']
print(L3)

# IF ELSE使用规则
# if在后面不能跟else
L4 = [x for x in range(10) if x % 2 == 0]
print(L4)
# if在前必须要有else
L5 = [x if x % 2 == 0 else -x for x in range(1, 11)]
print(L5)
