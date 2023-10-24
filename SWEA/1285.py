t = int(input())
for test_case in range(t):
    n = int(input())
    one_line = list(map(int, input().split()))
    for i in range(n):
        if one_line[i] < 0:
            one_line[i] = one_line[i] * -1
    min_value = min(one_line)
    result = one_line.count(min_value)
    print("#" + str(test_case + 1), min_value, result)
