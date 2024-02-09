import sys

N, M = map(int, input().split())
num_list = []
for _ in range(N):
    num_list.append(int(sys.stdin.readline().rstrip()))
num_list.sort()
start = 0
end = 0
result = 1000000001 * 2
while end < N and start < N:
    diff = num_list[end] - num_list[start]
    if diff < M:
        end += 1
    else:
        start += 1
        if diff < result:
            result = diff
print(result)
