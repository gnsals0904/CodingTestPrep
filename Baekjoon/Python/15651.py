N, M = map(int, input().split())
is_used = [False for _ in range(N)]
result = []


def back_tracking(k):
    if k == M:
        print(*result)
        return
    for i in range(N):
        if not is_used[i]:
            result.append(i + 1)
            back_tracking(k + 1)
            result.pop()


back_tracking(0)
