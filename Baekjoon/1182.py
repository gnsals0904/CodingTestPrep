from itertools import permutations, combinations

N, S = map(int, input().split())
num_list = list(map(int, input().split()))
num_list.sort()
visited = [False for _ in range(N)]
um_sum = []
result = []


def func(k, total):
    if k == N:
        if total == S:
            result.append(1)
        return
    func(k + 1, total)
    func(k + 1, total + num_list[k])


func(0, 0)
if S == 0:
    print(sum(result) - 1)
else:
    print(sum(result))
