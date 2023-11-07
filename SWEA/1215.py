for tc in range(1, 11):
    graph = []
    n = int(input())
    for _ in range(8):
        one_line = list(map(str, input()))
        graph.append(one_line)
    result = 0
    for i in range(8):
        for j in range(8):
            s = ''
            # 아래 검사
            if i <= 8 - n:
                for k in range(n):
                    s = s + graph[i + k][j]
                if s == s[::-1]:
                    result += 1
                s = ''
            # 오른쪽 검사
            if j <= 8 - n:
                for k in range(n):
                    s = s + graph[i][j + k]
                if s == s[::-1]:
                    result += 1
                s = ''
                check = 0
    print('#' + str(tc), result)
