N, M = map(int, input().split())
num_list = list(map(int, input().split()))
num_list.sort()
result = []
visited = [False for _ in range(N)]


def func(k):
    if k == M:
        print(*result)
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            result.append(num_list[i])
            func(k + 1)
            visited[i] = False
            result.pop()


func(0)
