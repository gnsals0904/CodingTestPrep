t = int(input())
for testcase in range(t):
    line_num = int(input())
    arr = []
    # 정답 배열 초기화
    result_90_arr = [[] for _ in range(line_num)]
    result_180_arr = [[] for _ in range(line_num)]
    result_270_arr = [[] for _ in range(line_num)]
    for i in range(line_num):
        for _ in range(line_num):
            result_90_arr[i].append(0)
            result_180_arr[i].append(0)
            result_270_arr[i].append(0)
    for line in range(line_num):
        one_line = list(map(int, input().split()))
        arr.append(one_line)
    # 배열 회전
    for i in range(line_num):
        for j in range(line_num):
            result_90_arr[j][line_num - i - 1] = arr[i][j]
            result_180_arr[line_num - i - 1][line_num - j - 1] = arr[i][j]
            result_270_arr[line_num - j - 1][i] = arr[i][j]
    print("#" + str(testcase + 1))
    # 배열 출력
    for x in range(line_num):
        for y in range(line_num * 3 + 2):
            if y == line_num or y == 2 * line_num + 1:
                print(' ', end='')
            elif 0 <= y < line_num:
                print(result_90_arr[x][y], end='')
            elif line_num + 1 <= y <= 2 * line_num:
                print(result_180_arr[x][y - line_num - 1], end='')
            else:
                print(result_270_arr[x][y - 2 * line_num - 2], end='')
        print()
