t = int(input())
for test_case in range(t):
    n = int(input())
    now_number = 1
    # 한번 돌면 플러스 1
    turn = 0
    # 결과 리스트 초기화
    result_list = [[] for _ in range(n)]
    for a in range(n):
        for _ in range(n):
            result_list[a].append(0)
    # 값을 넣었는지 체크 하는 리스트
    check_list = [[] for _ in range(n)]
    for x in range(n):
        for _ in range(n):
            check_list[x].append(False)
    # 달팽이 배열 생성
    for i in range(n * 2):
        for j in range(n):
            # i == 0, 4
            if i % 4 == 0 and not check_list[i % 4 + turn][j]:
                result_list[i % 4 + turn][j] = now_number
                check_list[i % 4 + turn][j] = True
                now_number += 1
            # i == 1, 5
            elif i % 4 == 1 and not check_list[j][n - i % 4 - turn]:
                result_list[j][n - i % 4 - turn] = now_number
                check_list[j][n - i % 4 - turn] = True
                now_number += 1
            # i == 2, 6
            elif i % 4 == 2 and not check_list[n - i % 4 + 1 - turn][n - j - 1]:
                result_list[n - i % 4 + 1 - turn][n - j - 1] = now_number
                check_list[n - i % 4 + 1 - turn][n - j - 1] = True
                now_number += 1
            # i == 3, 7
            elif i % 4 == 3 and not check_list[n - j - 1][i % 4 - 3 + turn]:
                result_list[n - j - 1][i % 4 - 3 + turn] = now_number
                check_list[n - j - 1][i % 4 - 3 + turn] = True
                now_number += 1
            elif i % 4 == 3 and j == n - 1:
                turn += 1
    print("#" + str(test_case + 1))
    for now_line in range(n):
        print(*result_list[now_line])
