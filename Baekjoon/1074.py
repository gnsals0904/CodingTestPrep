import sys
sys.setrecursionlimit(1000000)


N, r, c = map(int, input().split())


def recursion(n, R, C):
    if n == 0:
        return 0
    size = 2 ** (n - 1)
    if R < size and C < size:
        return recursion(n - 1, R, C)
    if R < size and C >= size:
        return recursion(n - 1, R, C - size) + size * size
    if R >= size and C < size:
        return recursion(n - 1, R - size, C) + size * size * 2
    if R >= size and C >= size:
        return recursion(n - 1, R - size, C - size) + size * size * 3


result = recursion(N, r, c)
print(result)
