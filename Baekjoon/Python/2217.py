import sys

N = int(input())
num_list = []
for _ in range(N):
    num_list.append(int(sys.stdin.readline().rstrip()))
num_list.sort()
i = 0
result = 0
while N > 0:
    temp = N * num_list[i]
    if temp > result:
        result = temp
    i += 1
    N -= 1
print(result)