import sys


def func(x, k):
    if k == 1:
        return
    for i in range(x + k // 3, x + 2 * k // 3):
        cantore[i] = " "
    func(x, k // 3)
    func(x + 2 * k // 3, k // 3)


while True:
    try:
        N = int(sys.stdin.readline().rstrip())
        len_N = 3 ** N
        cantore = ["-" for _ in range(len_N)]
        func(0, len_N)
        for c in cantore:
            print(c, end="")
        print()
    except:
        break
