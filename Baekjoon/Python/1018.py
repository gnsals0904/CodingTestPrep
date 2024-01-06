import sys

N, M = map(int, input().split())
chess_board = []
for _ in range(N):
    one_line = list(map(str, sys.stdin.readline().strip()))
    chess_board.append(one_line)

check = 0
b_check = 0
w_check = 0
min_result = 64
for k in range(N - 7):
    for p in range(M - 7):
        for i in range(0, 8, 2):
            for j in range(0, 8, 2):
                if chess_board[k + i][p + j] != 'B':
                    b_check += 1
                if chess_board[k + i][p + j + 1] != 'W':
                    b_check += 1
        for i in range(1, 8, 2):
            for j in range(0, 8, 2):
                if chess_board[k + i][p + j] != 'W':
                    b_check += 1
                if chess_board[k + i][p + j + 1] != 'B':
                    b_check += 1
        for i in range(0, 8, 2):
            for j in range(0, 8, 2):
                if chess_board[k + i][p + j] != 'W':
                    w_check += 1
                if chess_board[k + i][p + j + 1] != 'B':
                    w_check += 1
        for i in range(1, 8, 2):
            for j in range(0, 8, 2):
                if chess_board[k + i][p + j] != 'B':
                    w_check += 1
                if chess_board[k + i][p + j + 1] != 'W':
                    w_check += 1
        if b_check > w_check:
            check = w_check
        else:
            check = b_check
        if min_result > check:
            min_result = check
        check = 0
        b_check = 0
        w_check = 0

print(min_result)
