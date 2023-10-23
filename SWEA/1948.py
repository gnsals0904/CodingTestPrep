t = int(input())
for test_case in range(t):
    m1, d1, m2, d2 = map(int, input().split())
    days_list = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    result = 0
    if m1 == m2:
        result += d2 - d1 + 1
    else:
        result += days_list[m1] - d1 + 1
        result += d2
        for i in range(m1 + 1, m2):
            result += days_list[i]
    print("#" + str(test_case + 1), result)
