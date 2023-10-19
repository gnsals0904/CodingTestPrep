n = int(input())
n_list = list()
for i in range(n + 1):
    n_list.append(i)
n_list.reverse()
print(*n_list)
