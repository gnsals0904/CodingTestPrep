import sys

n = int(input())
arr = list(map(int, sys.stdin.readline().split()))
x = int(input())
arr.sort()

result = 0

for i in range(n):
    if arr[i] > x:
        break
    for j in range(i + 1, n):
        if arr[i] + arr[j] > x:
            break
        elif arr[i] + arr[j] == x:
            result += 1

print(result)
