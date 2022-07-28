n_list = [1, 2, 3]
t = int(input())
for i in range(t):
    X, Y = map(int, input().split())
    temp = n_list[X - 1]
    n_list[X - 1] = n_list[Y - 1]
    n_list[Y - 1] = temp
    t = t - 1
print(n_list[0])
