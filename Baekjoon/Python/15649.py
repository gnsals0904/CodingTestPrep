N, M = map(int, input().split())
result = []
is_used = [False for _ in range(N)]


def back_tracking(k):
    if k == M:
        print(*result)
        return
    for i in range(N):
        if not is_used[i]:
            result.append(i + 1)
            is_used[i] = True
            back_tracking(k + 1)
            is_used[i] = False
            result.pop()


back_tracking(0)
