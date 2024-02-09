N, S = map(int, input().split())
num_list = list(map(int, input().split()))
num_list.sort()
visited = [False for _ in range(N)]
num_sum = []
result = []


def func(k):
    if sum(num_sum) == S and len(num_sum) > 0:
        result.append(1)
    start = 0
    if k != 0:
        start = num_list.index(result[k - 1])
    for i in range(k, N):
        num_sum.append(num_list[i])
        func(k + 1)
        num_sum.pop()


func(0)
print(sum(result))
