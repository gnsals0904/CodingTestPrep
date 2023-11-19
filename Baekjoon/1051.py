N, M = map(int, input().split())
graph = []
for _ in range(N):
    one_line = list(map(int, input()))
    graph.append(one_line)
result = 1
for i in range(N):
    for j in range(M):
        now_check_number = graph[i][j]
        # 세로 검사
        temp_1 = []
        for i1 in range(i, N):
            if now_check_number == graph[i1][j]:
                temp_1.append(i1 - i + 1)
        # 가로 검사
        temp_2 = []
        for j1 in range(j, M):
            if now_check_number == graph[i][j1]:
                temp_2.append(j1 - j + 1)
        # 가로 세로 같은 길이 있는지 검사
        for x in temp_1:
            # 있으면
            if x in temp_2:
                if now_check_number == graph[i + x - 1][j + x - 1]:
                    # 같으면 사각형
                    if result < x ** 2:
                        result = x ** 2

print(result)
