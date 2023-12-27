import sys


def board_tilt(direct):
    # 오른쪽으로 기울이는 경우
    if direct == 0:
        # 0 은 제외하고 n_board_line 에 숫자 채우기
        for i1 in range(N):
            n_board_line = []
            for j1 in range(N - 1, -1, -1):
                if board[i1][j1] == 0:
                    continue
                n_board_line.append(board[i1][j1])
            len_n_b = len(n_board_line)
            f_board_line = []
            # 현재 가리키고 있는 인덱스를 나타낼 변수
            ptr = 0
            while ptr < len_n_b:
                # 포인터가 리스트의 마지막을 가리키고 있다면 합칠 대상이 없으므로 그대로 리스트에 추가
                if ptr == len_n_b - 1:
                    f_board_line.append(n_board_line[ptr])
                    break
                # 포인터가 가리키고 있는 값과 다음 값이 같다면 합치고 리스트에 추가
                if n_board_line[ptr] == n_board_line[ptr + 1]:
                    f_board_line.append(n_board_line[ptr] * 2)
                    ptr += 2
                # 포인터가 가리키고 있는 값과 다음 값이 다르다면 가리키고 있는 값만 추가
                else:
                    f_board_line.append(n_board_line[ptr])
                    ptr += 1
            # 남은 자리는 0으로 채워주어야 함
            len_f = len(f_board_line)
            for _ in range(N - len_f):
                f_board_line.append(0)
            # 이 리스트를 그대로 갱신
            board[i1] = f_board_line[:]
    # 좌측으로 기울이는 경우
    elif direct == 1:
        for i1 in range(N):
            n_board_line = []
            for x in board[i1]:
                if x == 0:
                    continue
                n_board_line.append(x)
            # 왼쪽이니까 앞에서부터 확인
            len_n_b = len(n_board_line)
            f_board_line = []
            ptr = 0
            while ptr < len_n_b:
                if ptr == len_n_b - 1:
                    f_board_line.append(n_board_line[ptr])
                    break
                if n_board_line[ptr] == n_board_line[ptr + 1]:
                    f_board_line.append(n_board_line[ptr] * 2)
                    ptr += 2
                else:
                    f_board_line.append(n_board_line[ptr])
                    ptr += 1
            # 남은 자리는 0으로 채워주어야 함
            len_f = len(f_board_line)
            for _ in range(N - len_f):
                f_board_line.append(0)
            # 이 리스트를 그대로 갱신해주어야 함. 왼쪽으로 틸팅했으므로
            for j2 in range(N):
                board[i1][j2] = f_board_line[j2]
    # 위로 기울이는 경우
    elif direct == 2:
        for j1 in range(N):
            n_board_line = []
            for i1 in range(N):
                if board[i1][j1] == 0:
                    continue
                n_board_line.append(board[i1][j1])
            # 위쪽이니까 앞에서부터 확인
            len_n_b = len(n_board_line)
            f_board_line = []
            ptr = 0
            while ptr < len_n_b:
                if ptr == len_n_b - 1:
                    f_board_line.append(n_board_line[ptr])
                    break
                if n_board_line[ptr] == n_board_line[ptr + 1]:
                    f_board_line.append(n_board_line[ptr] * 2)
                    ptr += 2
                else:
                    f_board_line.append(n_board_line[ptr])
                    ptr += 1
            # 남은 자리는 0으로 채워주어야 함
            len_f = len(f_board_line)
            for _ in range(N - len_f):
                f_board_line.append(0)
            # 이 리스트를 그대로 갱신해주어야 함. 위쪽으로 틸팅했으므로
            for i1 in range(N):
                board[i1][j1] = f_board_line[i1]
    # 아래로 기울이는 경우
    else:
        for j1 in range(N):
            n_board_line = []
            for i1 in range(N - 1, -1, -1):
                if board[i1][j1] == 0:
                    continue
                n_board_line.append(board[i1][j1])
            # 아래쪽이지만 뒤에서부터 넣었으므로 앞에서부터 확인
            len_n_b = len(n_board_line)
            f_board_line = []
            ptr = 0
            while ptr < len_n_b:
                if ptr == len_n_b - 1:
                    f_board_line.append(n_board_line[ptr])
                    break
                if n_board_line[ptr] == n_board_line[ptr + 1]:
                    f_board_line.append(n_board_line[ptr] * 2)
                    ptr += 2
                else:
                    f_board_line.append(n_board_line[ptr])
                    ptr += 1
            # 남은 자리는 0으로 채워주어야 함
            len_f = len(f_board_line)
            for _ in range(N - len_f):
                f_board_line.append(0)
            # 이 리스트를 그대로 갱신해주어야 함.
            for i1 in range(N):
                board[i1][j1] = f_board_line[i1]


N = int(input())
board = []
real_board = [[] for _ in range(N)]
for i_2 in range(N):
    one_line = list(map(int, sys.stdin.readline().split()))
    board.append(one_line)
    real_board[i_2] = one_line[:]

result = 0
# 총 1024개의 경우
for i in range(1024):
    # 현재 진행하는 경우를 now 로 표현
    now = i
    for _ in range(5):
        # now_j 는 현재 보드를 어느쪽으로 기울일지
        now_j = now % 4
        # now 를 4 씩 나누며 다음 경우로 넘어감
        now = now // 4
        # board 기울이기
        board_tilt(now_j)
    # 기울이기는 끝났으니 최대값 찾기
    for i_1 in range(N):
        for j_1 in range(N):
            if board[i_1][j_1] > result:
                result = board[i_1][j_1]
    # 다 하고 보드 초기화
    for i_2 in range(N):
        board[i_2] = real_board[i_2][:]

print(result)
