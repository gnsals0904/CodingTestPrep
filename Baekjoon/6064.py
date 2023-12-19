import sys


def gcd(a, b):
    if a % b == 0:
        return b
    return gcd(b, a % b)


def lcm(a, b):
    return a // gcd(a, b) * b


t = int(input())
for _ in range(t):
    M, N, x, y = map(int, sys.stdin.readline().split())
    result = -1
    if x == M:
        x = 0
    if y == N:
        y = 0
    k = lcm(M, N)
    for i in range(x, k + 1, M):
        if i == 0:
            continue
        if i % N == y:
            result = i
            break
    print(result)
