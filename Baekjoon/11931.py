import sys

N = int(input())
num = []
for _ in range(N):
    temp = int(sys.stdin.readline().rstrip())
    num.append(temp)
num.sort(reverse=True)
for i in range(N):
    print(num[i])
