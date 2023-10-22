t = int(input())
for i in range(t):
    n = int(input())
    num_list = list(map(int, input().split()))
    num_list.sort()
    print("#" + str(i + 1), *num_list)
