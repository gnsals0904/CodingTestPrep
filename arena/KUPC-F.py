import sys


N, M, R = map(int, input().split())
bottom_list = list(map(int, sys.stdin.readline().split()))
length_list2 = []
height_list = list(map(int, sys.stdin.readline().split()))
height_list.sort()
minimum_height = height_list[0]
for i in range(N):
    for j in range(i + 1, N):
        temp = bottom_list[i] - bottom_list[j]
        if temp < 0:
            temp = temp * -1
        if minimum_height * temp / 2 > R:
            continue
        length_list2.append(temp)


length_list2 = list(set(length_list2))
length_list2.sort()

len_ll2 = len(length_list2)
check = True
result = 0
for k in range(len_ll2):
    for x in range(M):
        temp_result = height_list[x] * length_list2[k] / 2
        if temp_result > R:
            check = False
            break
        result = temp_result
    if not check:
        break
if result == 0:
    print(-1)
else:
    print(f'{result:.1f}')
