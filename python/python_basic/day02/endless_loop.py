# -*- coding:utf-8 -*-
# @Time : 2019/12/13 16:50
# @Author: wsp
import time


def endless_loop():
    """
    死循环
    :return:None
    """
    i = 0
    while True:
        i = i + 1
        if i < 50:
            print(i)
        time.sleep(1)


def file_opreate():
    """
    文件操作  Read Write
    :return:None
    """
    f = open("../source/in.txt", mode="r")
    content = f.read()
    print(content)
    f1 = open("../source/out.txt", mode="a+")
    f1.write(content)
    f.close()


if __name__ == '__main__':
    # endless_loop()
    file_opreate()
