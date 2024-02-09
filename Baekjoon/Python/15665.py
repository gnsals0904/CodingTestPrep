N, M = map(int, input().split())
num_list = list(map(int, input().split()))
visited = [False for _ in range(N)]
result = []
num_list.sort()


def func(k):
    if k == M:
        print(*result)
        return
    temp = 0
    for i in range(N):
        if temp != num_list[i]:
            temp = num_list[i]
            result.append(num_list[i])
            func(k + 1)
            result.pop()


func(0)
