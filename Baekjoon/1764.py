import sys

N, M = map(int, input().split())
hear_dic = {}
result = []
count = 0
for _ in range(N):
    one_line = sys.stdin.readline().rstrip()
    hear_dic[one_line] = 0
for _ in range(M):
    one_line = sys.stdin.readline().rstrip()
    if hear_dic.get(one_line) == 0:
        count += 1
        result.append(one_line)
print(count)
result.sort()
for i in range(count):
    print(result[i])
