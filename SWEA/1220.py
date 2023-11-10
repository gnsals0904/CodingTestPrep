for tc in range(10):
    n = int(input())
    graph = []
    for _ in range(n):
        one_line = list(map(int, input().split()))
        graph.append(one_line)
    result = 0
    for i in range(n):
        # 이 둘 위치 사이의 자석은 전부 교착 상태
        now_n = 0
        now_s = 0
        count = 0
        find_1 = False
        for j in range(n):
            # 제일 위의 N위치 저장
            if graph[j][i] == 1:
                now_n = j
                break
        for k in range(n - 1, -1, -1):
            # 제일 아래의의 S위치 저장
            if graph[k][i] == 2:
                now_s = k
                break
        # 둘 위치 사이의 교착 상태 자석 개수 세기
        for z in range(now_n, now_s + 1):
            if graph[z][i] == 1:
                find_1 = True
            if graph[z][i] == 2 and find_1:
                count += 1
                find_1 = False
        # 다 세었으면 result 에 저장
        result += count
    print("#" + str(tc + 1), result)
