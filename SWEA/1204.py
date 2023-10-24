t = int(input())
for test_case in range(t):
    testcase = int(input())
    score_list = list(map(int, input().split()))
    len_score_list = len(score_list)
    score_list.sort()
    max_cnt = 0
    result = 0
    i = 0
    while i != len_score_list:
        cnt = score_list.count(score_list[i])
        now_value = score_list[i]
        if max_cnt <= cnt:
            max_cnt = cnt
            result = now_value
        i = i + cnt

    print('#' + str(test_case + 1), result)
