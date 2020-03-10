# -*- coding:utf-8 -*-
# @Time : 2020/3/9 19:33
# @Author: wsp

# 函数的参数

# 1.位置参数


def power(x):
    return x * x


print(power(5))


# 递归函数:理论上所有的递归函数都可以写成循环函数，但是循环函数没有递归函数的逻辑清晰。
# point:使用递归时要注意防止栈溢出，在计算机中函数的调用是通过栈这种数据结构实现的，每当进入一个函数调用，
# 栈就会加一层栈帧，每当函数返回，栈就会减一层栈帧。由于栈的大小不是无限的，所以，递归调用的次数过多，会导致栈溢出。可以试试fact(1000)：
def fact(n):
    if n == 1:
        return 1
    return n * fact(n - 1)


# 解决递归内存溢出的方式是尾递归优化，尾递归优化实际上也是一种循环，
# 在函数返回的时候返回函数本身而不是返回一个表达式,这样编译器或者解释器会对尾递归做优化,使递归本身无论运行多少次,都只占用一个栈帧,不会出现栈溢出的情况
def fact_one(n):
    return fact_iter(n, 1)


def fact_iter(num, product):
    if num == 1:
        return product
    else:
        return fact_iter(num - 1, num * product)


if __name__ == '__main__':
    print(fact_one(100))
