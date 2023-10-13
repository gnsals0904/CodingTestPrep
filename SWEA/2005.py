T = int(input())
testcase_num = 1
for test_case in range(1, T + 1):
    pascal_tri = list()
    temp_list = list()
    input_num = int(input())
    print("#" + str(testcase_num))
    for i in range(input_num):
        if i >= 2:
            temp_list = pascal_tri.copy()
            for j in range(1, i):
                pascal_tri[j] = temp_list[j - 1] + temp_list[j]
        pascal_tri.append(1)
        print(*pascal_tri)
    testcase_num += 1
