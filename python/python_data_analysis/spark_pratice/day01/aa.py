def test():
    for i in range(3):
        print "aa"
        i = i + 1
        if i == 2:
            # break
            continue
        print i


def test1():
    import string
    l = string.ascii_letters
    s = [l[34], l[11], l[14], l[21], l[4], l[24], l[14], l[20]]
    s.insert(1, " ")
    s.insert(6, " ")
    string = "".join(s)
    print(string)


if __name__ == '__main__':
    test()
    test1()
    print ("")
