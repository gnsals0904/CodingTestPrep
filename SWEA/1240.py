t = int(input())
for tc in range(t):
    graph = []
    N, M = map(int, input().split())
    for _ in range(N):
        one_line = list(map(str, input()))
        graph.append(one_line)
    check = False
    code_line = 0
    start = 0
    for i in range(N):
        if check:
            break
        for j in range(M - 1, -1, -1):
            if graph[i][j] == '1':
                check = True
                code_line = i
                start = j
                break
    # code_line 의 수가 암호코드가 있는 라인 수
    # start 는 1이 뒤에서부터 시작하는 위치
    # 암호코드의 끝자리는 무조건 1이므로 뒤에서부터 찾아서 1일때부터 56개의 문자열만 저장
    graph_s = ''.join(graph[code_line])
    code = graph_s[start - 55:start + 1]
    # 비교할 문자열
    code_result = ['0001101', '0011001', '0010011', '0111101', '0100011', '0110001', '0101111', '0111011', '0110111', '0001011']
    # 해독된 숫자들
    decode_result = []
    wrong_input = False
    # 7개씩 문자열 파싱
    for k in range(0, 50, 7):
        wrong_code = True
        code_check = code[k:k+7]
        for num in range(10):
            if code_check == code_result[num]:
                decode_result.append(num)
                wrong_code = False
                break
        if wrong_code:
            wrong_input = True
            break
    if wrong_input:
        print('#' + str(tc + 1), 0)
    else:
        # 짝수 검사
        check_decode_result_2 = 0
        # 홀수 검사
        check_decode_result_1 = 0
        for z in range(8):
            # 짝수 자리
            if z % 2 == 1:
                check_decode_result_2 += decode_result[z]
            # 홀수 자리
            else:
                check_decode_result_1 += decode_result[z]
        if (check_decode_result_1 * 3 + check_decode_result_2) % 10 != 0:
            # 올바르지 않은 암호코드
            print('#' + str(tc + 1), 0)
        else:
            # 올바른 암호코드
            print('#' + str(tc + 1), sum(decode_result))

