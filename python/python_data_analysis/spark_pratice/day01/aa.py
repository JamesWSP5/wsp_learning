def test():
    for i in range(3):
        print "aa"
        i = i + 1
        if i==2:
            continue
        print i


if __name__ == '__main__':
    test()
