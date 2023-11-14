N, M = map(int, input().split())
num_list = list(map(int, input().split()))
num_list.sort()
visited = [False for _ in range(N)]
result = []


def func(k):
    if k == M:
        print(*result)
        return
    start = 0
    if k != 0:
        start = num_list.index(result[k - 1])
    temp = 0
    for i in range(start, N):
        if not visited[i] and temp != num_list[i]:
            visited[i] = True
            temp = num_list[i]
            result.append(num_list[i])
            func(k + 1)
            visited[i] = False
            result.pop()


func(0)
