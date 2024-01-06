N, M = map(int, input().split())
result = []


def back_tracking(k):
    if k == M:
        print(*result)
        return
    start = 1
    if k != 0:
        start = result[k - 1]
    for i in range(start, N + 1):
        result.append(i)
        back_tracking(k + 1)
        result.pop()


back_tracking(0)