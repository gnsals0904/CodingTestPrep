from collections import deque

N, M = map(int, input().split())
graph = []
visited = [[False] * M for _ in range(N)]
for _ in range(N):
    one_line = list(map(int, input().split()))
    graph.append(one_line)
copy_graph = [item[:] for item in graph]


def bfs():
    temp_result = 0
    queue = deque()
    for v1 in range(N):
        for v2 in range(M):
            if copy_graph[v1][v2] == 2:
                queue.append((v1, v2))
                visited[v1][v2] = True
    while queue:
        now_x, now_y = queue.popleft()
        for temp_vector in vector:
            nx = now_x + temp_vector[0]
            ny = now_y + temp_vector[1]
            # 범위 밖은 제외
            if nx < 0 or N <= nx or ny < 0 or M <= ny:
                continue
            # 0이 아니거나 방문한 곳은 제외
            if copy_graph[nx][ny] != 0 or visited[nx][ny]:
                continue
            copy_graph[nx][ny] = 2
            visited[nx][ny] = True
            queue.append((nx, ny))
    # 안전구역 세고
    for x in range(N):
        temp_result += copy_graph[x].count(0)
    return temp_result


vector = [[1, 0], [-1, 0], [0, 1], [0, -1]]
max_safe_zone = 0

# 벽을 세울 위치 탐색 하면서
all_num = N * M
for k in range(all_num):
    for i in range(k + 1, all_num):
        result = 0
        for j in range(i + 1, all_num):
            kx, ky = k // M, k % M
            ix, iy = i // M, i % M
            jx, jy = j // M, j % M
            # 이미 뭐가 있으면 넘기고
            if copy_graph[kx][ky] != 0 or copy_graph[ix][iy] != 0 or copy_graph[jx][jy] != 0:
                continue
            else:
                # 벽 세우기
                copy_graph[kx][ky] = 1
                copy_graph[ix][iy] = 1
                copy_graph[jx][jy] = 1
                # 바이러스 감염 시키고 안전구역 수 리턴
                result = bfs()
                # 지금 안전구역 경우의 수가 max 값보다 크면 저장
                if result > max_safe_zone:
                    max_safe_zone = result
                # graph 원복
                copy_graph = [item[:] for item in graph]
                visited = [[False] * M for _ in range(N)]
print(max_safe_zone)
