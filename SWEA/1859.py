T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    predict_list = list(map(int, input().split()))
    result_sum = 0
    # [0] => index // [1] => value
    new_list = [[i, predict_list[i]] for i in range(N)]
    new_list.sort(key=lambda x: x[1], reverse=True)
    temp_j = -1
    for j in range(N):
        n_inx = new_list[j][0]
        n_val = new_list[j][1]
        if temp_j > n_inx:
            continue
        for k in range(temp_j + 1, n_inx):
            result_sum += n_val - predict_list[k]
        temp_j = n_inx
        if n_inx == N - 1:
            break
    print("#" + str(test_case), result_sum)




# 오답 : 10개의 테스트케이스 중 9개가 맞았습니다.)
#
# 런타임 에러가 발생하였습니다. 런타임 에러로 전체 혹은 일부 테스트 케이스는 채점이 되지 않을 수 있습니다.
# Error Message :
# Runtime Error!