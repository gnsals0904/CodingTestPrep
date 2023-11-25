from collections import deque

n = int(input())
k = int(input())
snake = {}
board = [[0] *
         (n + 1) for _ in range(n + 1)]
dx = [+1, 0, -1, 0]
dy = [0, 1, 0, -1]
dir = 1  # default
curx = 1
cury = 1
time = 1
tail_stack = deque()

for _ in range(k):
    x, y = map(int, input().split())
    board[x][y] = 1

l = int(input())
for _ in range(l):
    x, c = input().split()
    snake[int(x)] = c

board[1][1] = 2
curx += dx[dir]
cury += dy[dir]
tail_stack.append((1, 1))

while True:
    if curx < 1 or cury < 1 or curx > n or cury > n or board[curx][cury] == 2:
        break

    if board[curx][cury] != 1:
        tuple = tail_stack.popleft()
        board[tuple[0]][tuple[1]] = 0

    board[curx][cury] = 2

    if time in snake:
        dd = snake[time]
        if dd == 'L':
            dir = (dir + 1) % 4
        elif dd == 'D':
            dir = (dir + 3) % 4

    tail_stack.append((curx, cury))
    time += 1
    curx += dx[dir]
    cury += dy[dir]

print(time)