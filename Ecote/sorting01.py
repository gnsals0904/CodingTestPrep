N = int(input())
num_arr = list()
for i in range(N):
    n = int(input())
    num_arr.append(n)
num_arr.sort(reverse=True)
print(*num_arr)