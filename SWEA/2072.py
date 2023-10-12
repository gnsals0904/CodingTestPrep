T = int(input())
testcase_num = 1
for test_case in range(1, T + 1):
    num_list = list(map(int, input().split()))
    sum = 0
    for x in num_list:
        if x % 2 == 1:
            sum += x
    print("#" + str(testcase_num) + " " + str(sum))
    testcase_num += 1
