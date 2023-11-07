for tc in range(1, 11):
    t = int(input())
    graph = []
    # 후보값
    candidate_list = []
    # 우하단 대각선 값
    right_down_value = 0
    # 우하단 대각선 값을 구하기 위해 필요
    right_down_minus_value = 0
    # 우상단 대각선 값
    right_up_value = 0
    # 우상단 대각선 값을 구하기 위해 필요
    right_up_minus_value = 0
    # 좌측 값 중 max
    result1 = 0
    for _ in range(100):
        one_line = list(map(int, input().split()))
        graph.append(one_line)
    for i in range(100):
        for j in range(1, 100):
            graph[i][j] = graph[i][j - 1] + graph[i][j]
            if i == j:
                right_down_value += graph[i][j]
            if i + j == 99:
                right_up_value += graph[i][j]
            if i - j == 1:
                right_down_minus_value += graph[i][j]
            if i + j == 98:
                right_up_minus_value += graph[i][j]
            if j == 99:
                if result1 < graph[i][j]:
                    result1 = graph[i][j]
    right_down_value -= right_down_minus_value
    right_up_value -= right_up_minus_value
    result2 = 0
    for x in range(100):
        temp = 0
        for y in range(100):
            temp += graph[y][x]
            if x > 0:
                temp -= graph[y][x - 1]
        if result2 < temp:
            result2 = temp
    print("#" + str(tc), max(result1, result2, right_up_value, right_down_value))
