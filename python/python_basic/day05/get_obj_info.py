# -*- coding:utf-8 -*-
# @Time : 2020/3/14 14:40
# @Author: wsp
# 获取对象类型
from types import MethodType

print(type('a'))
# 获取对象所有可用的方法
print(dir('abc'))


# 当我们创建一个类的时候可以给该类绑定任意的方法和属性，这就是动态语言的灵活性
class Student(object):
    __slots__ = ('name', 'age')
    pass


# 给实例绑定一个属性
s = Student()
s.name = 'Michael'
print(s.name)


# 给实例绑定一个方法
def set_age(self, age):
    self.age = age


s.age = MethodType(set_age, s)  # 在加入__slots__时会报错，Student' object has no attribute 'set_age',这里发现一个有意思的现象，
# 为了防止用户绑定属性，因为无法识别.后面的是想要绑定方法还是属性，所以绑定的方法必须时个属性重名的，否则无法绑定。
s.age(25)
print(s.age)
# print s.age
# # UnboundMethodType(set_age, s)
# s.set_age(35)
# print s.age

# 通常情况下，set_score方法可以直接定义在class中，但动态绑定允许我们在程序运行的过程中动态给class加上功能，这在静态语言中很难实现。
# 但是在一些情況下也需要限制用户对实例的随意绑定，需要对实例进行限制，
# s.grade = 90
# print s.grade
# 使用__slots__要注意，__slots__定义的属性仅对当前类实例起作用，对继承的子类是不起作用的
