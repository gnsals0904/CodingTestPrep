num_list = []
for _ in range(10):
    n = int(input())
    num_list.append(n)
check = 0
for i in range(1, 10):
    num_list[i] = num_list[i - 1] + num_list[i]
for i in range(10):
    if num_list[i] >= 100:
        check = i
        break
if abs(num_list[check - 1] - 100) > abs(num_list[check] - 100):
    print(num_list[check])
elif abs(num_list[check - 1] - 100) == abs(num_list[check] - 100):
    print(num_list[check])
else:
    print(num_list[check - 1])
