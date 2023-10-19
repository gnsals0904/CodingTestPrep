T = int(input())
testcase_num = 1
for test_case in range(1, T + 1):
    N = input()
    n_month = int(N[4:6])
    n_day = int(N[6:])
    if 1 <= n_month <= 12:
        if n_month == 2:
            if 1 <= n_day <= 28:
                N = N[:4] + "/" + N[4:6] + "/" + N[6:]
                print("#" + str(testcase_num), N)
            else:
                print("#" + str(testcase_num), -1)
        elif n_month == 4 or n_month == 6 or n_month == 9 or n_month == 11:
            if 1 <= n_day <= 30:
                N = N[:4] + "/" + N[4:6] + "/" + N[6:]
                print("#" + str(testcase_num), N)
            else:
                print("#" + str(testcase_num), -1)
        else:
            if 1 <= n_day <= 31:
                N = N[:4] + "/" + N[4:6] + "/" + N[6:]
                print("#" + str(testcase_num), N)
            else:
                print("#" + str(testcase_num), -1)
    else:
        print("#" + str(testcase_num), -1)
    testcase_num += 1
