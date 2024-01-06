import sys

N = int(input())
house = []
for _ in range(N):
    one_line = list(map(int, sys.stdin.readline().split()))
    house.append(one_line)
D = [[house[0][0], house[0][1], house[0][2]]]
for i in range(1, N):
    temp = [min(D[i - 1][1], D[i - 1][2]) + house[i][0], min(D[i - 1][0], D[i - 1][2]) + house[i][1],
            min(D[i - 1][0], D[i - 1][1]) + house[i][2]]
    D.append(temp)
print(min(D[N - 1][0], D[N - 1][1], D[N - 1][2]))
