for tc in range(10):
    t = int(input())
    graph = []
    for _ in range(100):
        one_line = list(map(str, input()))
        graph.append(one_line)
    result = 1
    for i in range(100):
        for j in range(100):
            temp = graph[i][j]
            temp_s = '' + graph[i][j]
            # 세로 확인
            for k1 in range(i + 1, 100):
                temp_s = temp_s + graph[k1][j]
                if temp == graph[k1][j]:
                    if temp_s == temp_s[::-1]:
                        if result < k1 - i + 1:
                            result = k1 - i + 1
            temp = graph[i][j]
            temp_s = '' + graph[i][j]
            # 가로 확인
            for k2 in range(j + 1, 100):
                temp_s = temp_s + graph[i][k2]
                if temp == graph[i][k2]:
                    if temp_s == temp_s[::-1]:
                        if result < k2 - j + 1:
                            result = k2 - j + 1

    print(f"#{tc + 1} {result}")
