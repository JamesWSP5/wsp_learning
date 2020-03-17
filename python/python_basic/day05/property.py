# -*- coding:utf-8 -*-
# @Time : 2020/3/14 17:07
# @Author: wsp

class Student_one(object):

    def get_score(self):
        return self._score

    def set_score(self, value):
        if not isinstance(value, int):
            raise ValueError('score must be an integer!')
        if value < 0 or value > 100:
            raise ValueError('score must between 0 ~ 100!')
        self._score = value


s = Student_one()
s.set_score(60)
# s.set_score(5222)由于加了score的限制条件这亚子是不行的
print
s.get_score()


# 上述方法既达到了设置分数的目的，也达到了分数规则匹配的目的，
# 唯一的缺点是每次都要通过get,set方法去对score进行操作，有一丢丢的不爽
# so,@property方法就来解决这个问题。
# show me the code,@property装饰器就是负责把一个方法变成属性调用的：
class Student_two(object):

    @property
    def score(self):
        return self._score

    @score.setter
    def score(self, value):
        if not isinstance(value, int):
            raise ValueError('score must be an integer!')
        if value < 0 or value > 100:
            raise ValueError('score must between 0 ~ 100!')
        self._score = value


if __name__ == '__main__':
    s1 = Student_one()
    s1.set_score(60)
    # s.set_score(5222)由于加了score的限制条件这亚子是不行的
    print(s1.get_score())
    s2 = Student_two()
    s2.score = 90
    print(s2.score)
