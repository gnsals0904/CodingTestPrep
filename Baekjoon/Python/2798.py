N, M = map(int, input().split())
all_num = list(map(int, input().split()))
result = 0
for k in range(N):
    for i in range(k + 1, N):
        for j in range(i + 1, N):
            vk = all_num[k]
            vi = all_num[i]
            vj = all_num[j]
            kij = vk + vi + vj
            if kij > M:
                continue
            if kij > result:
                result = kij
print(result)
