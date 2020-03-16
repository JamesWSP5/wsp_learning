# -*- coding:utf-8 -*-
# @Time : 2020/3/12 19:42
# @Author: wsp

class student(object):
    def __init__(self, name, age, grade):
        self.name = name
        self.age = age
        self.__grade = grade

    def print_info(self):
        print('%s: %s ：%s' % (self.name, self.age, self.__grade))

    # 可以设置set方法让外部人员可以访问私有变量，为了防止无效参数的传入，比如满分100 ，传入一个150
    # def set_grade(self, grade):
    #     self.__grade = grade
    def set_grade(self, grade):
        if grade > 100 or grade < 0:
            print("输入的分数不正确，请重新设置")
        else:
            self.__grade = grade

    pass


if __name__ == '__main__':
    a = student('ws', 12, 99)
    print(a.age)
    # 变为私有变量，外部访问不到
    # print(a.grade)
    a.print_info()
    # ws: 12 ：99
    a.set_grade(1001)
    # 在这里可以看到set没有生效
    a.print_info()
    # ws: 12 ：99
