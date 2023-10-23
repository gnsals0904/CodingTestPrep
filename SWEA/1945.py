t = int(input())
for test_case in range(t):
    result_list = []
    n = int(input())
    n_2, n_3, n_5, n_7, n_11 = 0, 0, 0, 0, 0
    # 11
    while n % 11 == 0:
        n = n // 11
        n_11 += 1
    # 7
    while n % 7 == 0:
        n = n // 7
        n_7 += 1
    # 5
    while n % 5 == 0:
        n = n // 5
        n_5 += 1
    # 3
    while n % 3 == 0:
        n = n // 3
        n_3 += 1
    # 2
    while n % 2 == 0:
        n = n // 2
        n_2 += 1
    result_list.append(n_2)
    result_list.append(n_3)
    result_list.append(n_5)
    result_list.append(n_7)
    result_list.append(n_11)
    print('#' + str(test_case + 1), *result_list)
