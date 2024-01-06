r = list()
n = input()
while 1:
    a = n[0]
    b = len(n)
    r.append(a * b)
    if len(r) >= 2:
        if r[len(r) - 1] == r[len(r) - 2]:
            print("FA")
            break
