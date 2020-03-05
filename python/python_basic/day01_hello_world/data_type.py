# _*_ coding:utf-8 _*_
L = ['Michael', 'Sarah', 'Tracy', 'Bob', 'Jack']
print(L)

for i in range(3):
    print(i)

l1 = list(range(100))
print(l1)

a = 100
if a >= 101:
    print a
else:
    print -a

# '',""，引用标识字符串,单行使用，''' '''可多行字符，为了代替\n提高代码可读性

print ("你好\npython")
# 两处效果一样
print ('''你好
python''')

# LIST数据结构
l = [1, 2, 3]
# 实现方法
print len(l)
# 下标取数
print  l[0]

L = [
    ['Apple', 'Google', 'Microsoft'],
    ['Java', 'Python', 'Ruby', 'PHP'],
    ['Adam', 'Bart', 'Lisa']
]
L.append('aaa')
L.insert(0, 'sss')
# print  L[0][0]
print  L

'''
tuple 使用,tuple是不可变的list，即tuple里面指向的对象类型或者数值不能改变，
tuple在初始化时就必须确定下来 ()用来定义一个tuple，当()只有一个元素时会把()当作数学
中的（）来处理，所以要在元素后面加一个, ex: (a,)
'''
A = ('a', 'b', 'c')
# A[0] = 3  错误不允许赋值

print  A
