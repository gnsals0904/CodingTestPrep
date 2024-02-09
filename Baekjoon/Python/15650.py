N, M = map(int, input().split())
is_used = [False for _ in range(N)]
result = []


def func(k):
    if k == M:
        print(*result)
        return
    start = 0
    if k != 0:
        start = result[k - 1]
    for i in range(start, N):
        if not is_used[i]:
            is_used[i] = True
            result.append(i + 1)
            func(k + 1)
            result.pop()
            is_used[i] = False


func(0)
