from collections import deque
import sys


# 문제를 보자마자 BFS나 DFS로 풀어야겠다고 생각한 문제이다.
# (1, 1) 위치에서 출발하여 최대한 빨리 (N, M) 위치로 나가면 된다.
# bfs 함수 선언 부분
def bfs(x, y):
    # 큐를 선언한다. 파이썬에서는 큐를 deque 라이브러리로 선언하는 것이 좋다.
    queue = deque()
    # 큐에 x, y 쌍을 집어넣는다. x, y 좌표 부터 bfs 를 시작할 것이기 때문.
    queue.append((x, y))
    # 큐에 데이터가 남아있으면 while 반복문을 계속해서 돈다.
    while queue:
        # queue 에서 데이터를 하나 가져온다. popleft 는 FIFO 방식이다.
        now_x, now_y = queue.popleft()
        # 가져온 데이터의 x y 좌표를 보고 내가 갈 수 있는 방향(동 서 남 북)으로 갈 수 있는지 체크한다.
        for v in vector:
            # 다음 x 좌표 계산
            nx = now_x + v[0]
            # 다음 y 좌표 계산
            ny = now_y + v[1]
            # 만약 다음 내가 확인하는 좌표가 배열의 범위를 벗어나면 미로밖으로 나가는 것이므로 안된다.
            if not (0 <= nx < n and 0 <= ny < m):
                continue
            # 0의 값을 갖는 곳은 벽이므로 진행할 수 없다
            if maze[nx][ny] == 0:
                continue
            # 1을 값을 갖는 곳만 진행할 수 있다.
            if maze[nx][ny] == 1:
                # 다음 내가 진행하는 곳에 내가 전에 왔던 곳의 값 + 1을 저장해준다.
                # 이렇게 쭉 진행해주면 마지막에 n - 1, m - 1의 값을 출력하면 답이다.
                maze[nx][ny] = maze[now_x][now_y] + 1
                # 그리고 큐에 다음 내가 진행하는 좌표를 넣어준다
                queue.append((nx, ny))
    return maze[n - 1][m - 1]


# 먼저, n과 m의 입력(배열의 크기가 주어지므로 입력을 받는다.
n, m = map(int, sys.stdin.readline().split())
# 미로의 정보를 받기위해서 비어있는 배열을 선언한다.
maze = []
# 반복문으로 배열 데이터를 받아서 집어 넣는다.
for i in range(n):
    one_line = list(map(int, sys.stdin.readline().rstrip()))
    maze.append(one_line)
# vector 는 내가 갈 수 있는 방향을 의미한다. 문제에서 동서남북 총 4방향으로 움직일 수 있으므로, 아래의 4가지 경우로 움직일 수 있다.
vector = [[-1, 0], [0, -1], [0, 1], [1, 0]]
# 그리고 0,0 좌표 기준에서 시작해서 가장 빨리 미로를 탈출하는 경우를 찾아서 리턴하는 bfs 함수를 실행한다.
result = bfs(0, 0)
# 결과 출력하면 끝!
print(result)

# 수행 결과 : 메모리 34060KB 시간 76ms
# 문제 번호 : 백준 2178번
