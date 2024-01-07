import sys
from collections import deque


def bfs():
    while queue:
        temp = queue.popleft()
        for v in vector:
            v_x = temp[0] + v[0]
            v_y = temp[1] + v[1]
            v_z = temp[2] + v[2]
            if v_x < 0 or v_x >= R or v_y < 0 or v_y >= C or v_z < 0 or v_z >= L:
                continue
            if graph[v_z][v_x][v_y] == '#':
                continue
            if graph[v_z][v_x][v_y] == '.' or graph[v_z][v_x][v_y] == 'E':
                queue.append([v_x, v_y, v_z])
                graph[v_z][v_x][v_y] = graph[temp[2]][temp[0]][temp[1]] + 1


while True:
    L, R, C = map(int, sys.stdin.readline().split())
    if L == 0 and R == 0 and C == 0:
        break
    graph = []
    start = [0, 0, 0]
    end = [0, 0, 0]
    for floor in range(L):
        each_graph = []
        for f in range(R):
            one_line = list(map(str, sys.stdin.readline().rstrip()))
            for w in range(C):
                if one_line[w] == 'S':
                    start = [f, w, floor]
                if one_line[w] == 'E':
                    end = [f, w, floor]
            each_graph.append(one_line)
        sys.stdin.readline().rstrip()
        graph.append(each_graph)
    vector = [[1, 0, 0], [-1, 0, 0], [0, 1, 0], [0, -1, 0], [0, 0, 1], [0, 0, -1]]
    queue = deque()
    graph[start[2]][start[0]][start[1]] = 0
    queue.append(start)
    bfs()
    if graph[end[2]][end[0]][end[1]] == 'E':
        print('Trapped!')
    else:
        print(f"Escaped in {graph[end[2]][end[0]][end[1]]} minute(s).")
