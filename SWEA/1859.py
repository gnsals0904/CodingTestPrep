T = int(input())
testcase_num = 1
for test_case in range(1, T + 1):
    N = int(input())
    predict_list = list(map(int, input().split()))
    result_sum = 0
    max_value = max(predict_list)
    max_value_index = predict_list.index(max_value)
    for x in predict_list:
        now_value_index = predict_list.index(x)
        if now_value_index < max_value_index:
            result_sum += (max_value - predict_list[now_value_index])
        else:
            predict_list = predict_list[max_value_index + 1:N]
            if predict_list:
                max_value = max(predict_list)
                max_value_index = predict_list.index(max_value)

    print("#" + str(testcase_num), result_sum)
    testcase_num += 1



# 오답 : 10개의 테스트케이스 중 9개가 맞았습니다.)
#
# 런타임 에러가 발생하였습니다. 런타임 에러로 전체 혹은 일부 테스트 케이스는 채점이 되지 않을 수 있습니다.
# Error Message :
# Runtime Error!