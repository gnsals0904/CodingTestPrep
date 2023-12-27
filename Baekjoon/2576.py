num_list = []
min_result = 100
for _ in range(7):
    temp = int(input())
    if temp % 2 == 0:
        continue
    if min_result > temp:
        min_result = temp
    num_list.append(temp)
if sum(num_list) != 0:
    print(sum(num_list))
    print(min_result)
else:
    print(-1)

