import sys
sys.setrecursionlimit(1000000)


A, B, C = map(int, input().split())


def recur(a, b, c):
    if b == 1:
        return a % c
    temp = recur(a, b // 2, c)
    temp = temp * temp % c
    if b % 2 == 0:
        return temp
    else:
        return temp * a % c


result = recur(A, B, C)
print(result)
