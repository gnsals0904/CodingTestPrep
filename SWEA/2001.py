t = int(input())
for i in range(t):
    result_list = list()
    n, m = map(int, input().split())
    all_fly_list = [[] for _ in range(n)]
    for j in range(n):
        one_line = list(map(int, input().split()))
        all_fly_list[j].extend(one_line)
    sum_result = 0
    for big_1 in range(n - m + 1):
        for big_2 in range(n - m + 1):
            for small_1 in range(m):
                for small_2 in range(m):
                    sum_result += all_fly_list[small_1 + big_1][small_2 + big_2]
            result_list.append(sum_result)
            sum_result = 0
    print("#" + str(i + 1), max(result_list))
    