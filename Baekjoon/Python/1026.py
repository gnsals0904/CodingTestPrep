import sys

N = int(input())
a = list(map(int, sys.stdin.readline().split()))
b = list(map(int, sys.stdin.readline().split()))
a.sort(reverse=True)
b.sort()
result = 0
for i in range(N):
    result += (a[i] * b[i])
print(result)
