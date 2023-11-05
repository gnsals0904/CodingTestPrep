N, L = map(int, input().split())
zebra = []
for _ in range(N):
    one_line = list(map(int, input()))
    zebra.append(one_line)
max_num = 0
result = 0
for i in range(N):
    count = 0
    check = False
    for j in range(L):
        if zebra[i][j] == 1 and not check:
            count += 1
            check = True
        elif zebra[i][j] == 0:
            check = False
    if max_num < count:
        max_num = count
        result = 1
    elif max_num == count:
        result += 1
print(max_num, result)
