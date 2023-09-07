N, M = map(int, input().split())
array = list()

for i in range(N):
    x = int(input())
    array.append(x)

# DP Table
D = [10001] * (M + 1)
D[0] = 0

# DP Bottom - Up
for i in range(N):
    for k in range(array[i], M + 1):
        if D[k - array[i]] != 10001:
            D[k] = min(D[k], D[k - array[i]] + 1)

if D[M] == 10001:
    print(-1)
else:
    print(D[M])







