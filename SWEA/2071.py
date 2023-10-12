T = int(input())
testcase_num = 1
for test_case in range(1, T + 1):
    num_list = list(map(int, input().split()))
    sum = 0
    for x in num_list:
        sum += x
    avg = round(sum/10)
    print("#" + str(testcase_num) + " " + str(avg))
    testcase_num += 1
