T = int(input())
testcase_num = 1
for test_case in range(1, T + 1):
    num_list = list(map(int, input().split()))
    print("#" + str(testcase_num), max(num_list))
    testcase_num += 1
