T = int(input())
testcase_num = 1
for test_case in range(1, T + 1):
    input_str = input()
    str_len = 0
    for i in range(1, 11):
        temp_str = input_str[0:i]
        if temp_str == input_str[i:2*i]:
            str_len = i
            break
    print("#" + str(testcase_num) + " " + str(str_len))
    testcase_num += 1
