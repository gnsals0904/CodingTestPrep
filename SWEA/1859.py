T = int(input())
testcase_num = 1
for test_case in range(1, T + 1):
    N = int(input())
    predict_list = list(map(int, input().split()))
    result_sum = 0
    for x in predict_list:
        if not predict_list:
            break
        max_value = max(predict_list)
        max_value_index = predict_list.index(max_value)
        if max_value_index == 0:
            break
        now_value_index = predict_list.index(x)
        if now_value_index < max_value_index:
            result_sum += (max_value - predict_list[now_value_index])
        else:
            predict_list = predict_list[max_value_index + 1:N]

    print("#" + str(testcase_num), result_sum)
    testcase_num += 1
