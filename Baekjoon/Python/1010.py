import sys


t = int(sys.stdin.readline().rstrip())
for i in range(t):
    N, M = map(int, sys.stdin.readline().split())
    if N == M:
        print(1)
    elif N == 1:
        print(M)
    else:
        result = 1
        down = 1
        for j in range(N, 0, -1):
            down *= j
        for j in range(M, M - N, -1):
            result *= j
        print(result//down)

