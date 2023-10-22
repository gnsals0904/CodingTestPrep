t = int(input())
for i in range(t):
    sudoku_puzzle = []
    result = 1
    check_value = [False] * 9
    for j in range(9):
        one_line = list(map(int, input().split()))
        sudoku_puzzle.append(one_line)
    # 가로 검증
    for x in range(9):
        sort_line = sorted(sudoku_puzzle[x])
        for y in range(9):
            if not check_value[sort_line[y] - 1]:
                check_value[sort_line[y] - 1] = True
            else:
                result = 0
        check_value = [False] * 9
    # 세로 검증
    for y in range(9):
        for x in range(9):
            check_value[sudoku_puzzle[x][y] - 1] = True
        # 전부 있는지 검증
        for c in range(9):
            if not check_value[c]:
                result = 0
        check_value = [False] * 9
    # 박스 검증
    zx_list = [0, 3, 6]
    zy_list = [0, 3, 6]
    # 시작 좌표
    for zx in zx_list:
        for zy in zy_list:
            for x in range(3):
                for y in range(3):
                    check_value[sudoku_puzzle[zx + x][zy + y] - 1] = True
            # 전부 있는지 검증
            for c in range(9):
                if not check_value[c]:
                    result = 0
            check_value = [False] * 9
    print("#" + str(i + 1), result)
