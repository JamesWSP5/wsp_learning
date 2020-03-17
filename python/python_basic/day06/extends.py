# -*- coding:utf-8 -*-
# @Time : 2020/3/16 14:17
# @Author: wsp

# 多继承，python有java没有，但是并不推荐，虽然这样提高了编码的灵活性。
# 但是也会出现一些问题，如果一个类多个父类方法重名，当子类去调用该方法时会去调用继承的顺序靠前的类的方法，但是这个方法也许并不是你想要的，所以需要自己考虑。
# python2.7虽然支持print(),但是如果括号内是中文字符，就会打印出中文的字符编码，3.7不会，所以2.7版本的中文字符输出需要去掉括号

class Item:
    def info(self):
        print("Item中的方法", '这是一个商品')


class Product:
    def info(self):
        print('Product中的方法', '这是一个能赚钱的商品')


class Computer_one(Item, Product):
    pass


class Computer_two(Product, Item):
    pass


c1 = Computer_one()
c1.info()

c2 = Computer_two()
c2.info()
