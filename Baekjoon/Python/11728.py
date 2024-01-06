import sys

N, M = map(int, input().split())
a_list = list(map(int, sys.stdin.readline().split()))
b_list = list(map(int, sys.stdin.readline().split()))
a_ptr = 0
a_blank = False
b_ptr = 0
b_blank = False
result = []
for _ in range(N + M):
    if a_ptr == N:
        a_blank = True
        break
    if b_ptr == M:
        b_blank = True
        break
    if a_list[a_ptr] < b_list[b_ptr]:
        result.append(a_list[a_ptr])
        a_ptr += 1
    else:
        result.append(b_list[b_ptr])
        b_ptr += 1
if a_blank:
    for i in range(b_ptr, M):
        result.append(b_list[i])
if b_blank:
    for j in range(a_ptr, N):
        result.append(a_list[j])
print(*result)
