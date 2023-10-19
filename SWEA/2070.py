T = int(input())
testcase_num = 1
for test_case in range(1, T + 1):
    a, b = map(int, input().split())
    if a > b :
        print("#" + str(testcase_num), '>')
    elif a == b:
        print("#" + str(testcase_num), '=')
    else:
        print("#" + str(testcase_num), '<')
    testcase_num += 1
