import sys


def func(k):
    if k == 6:
        print(*result)
        return
    start = 0
    if k != 0:
        start = s.index(result[k - 1])
    for i in range(start, K):
        if not visited[i]:
            visited[i] = True
            result.append(s[i])
            func(k + 1)
            result.pop()
            visited[i] = False


while True:
    result = []
    one_line = list(map(int, sys.stdin.readline().split()))
    K = one_line[0]
    if K == 0:
        break
    visited = [False for _ in range(K)]
    s = one_line[1:]
    func(0)
    print()
