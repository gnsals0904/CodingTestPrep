N, K = map(int, input().split())
num_list = [i for i in range(1, N + 1)]
result_list = []
j = K - 1
# check 1 은 k와 같은지 체크함
check1 = K
# 전부 다 돌았나 체크
check2 = 0
while check2 != N:
    if j == N:
        j = 0
    now_value = num_list[j]
    if now_value == 0:
        j += 1
        continue
    if check1 == K:
        result_list.append(now_value)
        num_list[j] = 0
        check2 += 1
        check1 = 1
        continue
    check1 += 1
    j += 1
result_str = ''.join(str(result_list))
result_str = '<' + result_str[1:len(result_str) - 1] + '>'
print(result_str)
