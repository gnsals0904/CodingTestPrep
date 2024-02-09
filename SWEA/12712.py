def cal1(x, y):
    r_temp = 0
    for v in range(1, M):
        if x - v < 0:
            continue
        r_temp += graph[x - v][y]
    for v in range(1, M):
        if x + v >= N:
            continue
        r_temp += graph[x + v][y]
    for v in range(1, M):
        if y - v < 0:
            continue
        r_temp += graph[x][y - v]
    for v in range(1, M):
        if y + v >= N:
            continue
        r_temp += graph[x][y + v]
    r_temp += graph[x][y]
    return r_temp


def cal2(x, y):
    r_temp = 0
    for v in range(1, M):
        if x - v < 0:
            continue
        if y - v < 0:
            continue
        r_temp += graph[x - v][y - v]
    for v in range(1, M):
        if x + v >= N:
            continue
        if y + v >= N:
            continue
        r_temp += graph[x + v][y + v]
    for v in range(1, M):
        if x - v < 0:
            continue
        if y + v >= N:
            continue
        r_temp += graph[x - v][y + v]
    for v in range(1, M):
        if x + v >= N:
            continue
        if y - v < 0:
            continue
        r_temp += graph[x + v][y - v]
    r_temp += graph[x][y]
    return r_temp


t = int(input())
for test_case in range(t):
    N, M = map(int, input().split())
    graph = []
    for _ in range(N):
        one_line = list(map(int, input().split()))
        graph.append(one_line)
    result = 0
    for i in range(N):
        for j in range(N):
            temp = max(cal1(i, j), cal2(i, j))
            if temp > result:
                result = temp
    print(f"#{test_case + 1} {result}")
