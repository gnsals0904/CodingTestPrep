t = int(input())
for test_case in range(t):
    a, b = map(int, input().split())
    a_list = []
    change_a_list = []
    a = str(a)
    for i in range(len(a)):
        a_list.append(a[i])
        change_a_list.append(a[i])
    len_a_list = len(a_list)
    max_value = 0
    result_list = []
    while b != 0:
        b -= 1
        for i in range(len_a_list):
            for j in range(len_a_list):
                if i == j:
                    continue
                else:
                    temp = change_a_list[i]
                    change_a_list[i] = change_a_list[j]
                    change_a_list[j] = temp
                    result = ''
                    for k in range(len_a_list):
                        result += change_a_list[k]
                    result = int(result)
                    result_list.append(result)
                    change_a_list = a_list.copy()
        max_value = max(result_list)
        max_value = str(max_value)
        for i in range(len_a_list):
            a_list[i] = max_value[i]
            change_a_list[i] = max_value[i]
    print("#" + str(test_case + 1), max_value)
