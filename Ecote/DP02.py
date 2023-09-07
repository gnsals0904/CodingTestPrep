N = int(input())
array = list(map(int, input().split()))

# DP Table
D = [0] * 101

D[0] = array[0]
D[1] = max(array[1], array[0])

# DP Bottom - Up
for i in range(2, N):
    D[i] = max(D[i - 1], D[i - 2] + array[i])

print(D[N - 1])
