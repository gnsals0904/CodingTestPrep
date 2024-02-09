import sys


N = int(sys.stdin.readline().rstrip());
matrix = []
for _ in range(N):
    one_line = list(map(int, sys.stdin.readline().split()))
    matrix.append(one_line)
result = []


def recur(arr, k):
    if k == 1:
        result.append(arr[0][0])
        return
    temp = [[] for _ in range(k // 2)]
    count = 0
    for i in range(0, k, 2):
        for j in range(0, k, 2):
            temp2 = [arr[i][j], arr[i + 1][j], arr[i][j + 1], arr[i + 1][j + 1]]
            temp2.sort(reverse=True)
            temp[count].append(temp2[1])
        count += 1
    recur(temp, k // 2)


recur(matrix, N)
print(result[0])
