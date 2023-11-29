import sys

N = int(sys.stdin.readline().rstrip())
num = []
for _ in range(N):
    num.append(int(sys.stdin.readline().rstrip()))
num.sort()
result = 0
cnt = 0
r_idx = 0
v = num[0]
for i in range(N):
    if v == num[i]:
        cnt += 1
    else:
        if result < cnt:
            r_idx = i - 1
            result = cnt
        cnt = 1
        v = num[i]
if result < cnt:
    r_idx = i - 1
print(num[r_idx])
