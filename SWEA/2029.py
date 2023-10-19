T = int(input())
testcase_num = 1
for test_case in range(1, T + 1):
    a, b = map(int, input().split())
    result1 = a // b
    result2 = a % b
    print("#" + str(testcase_num), result1, result2)
    testcase_num += 1
    