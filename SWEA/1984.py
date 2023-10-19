t = int(input())
for i in range(t):
    num_list = list(map(int, input().split()))
    num_list.remove(max(num_list))
    num_list.remove(min(num_list))
    num_list_sum = sum(num_list)
    print("#" + str(i + 1), round(num_list_sum / 8))
