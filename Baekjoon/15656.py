N, M = map(int, input().split())
num_list = list(map(int, input().split()))
result = []
num_list.sort()


def func(k):
    if k == M:
        print(*result)
        return
    for i in range(N):
        result.append(num_list[i])
        func(k + 1)
        result.pop()


func(0)
