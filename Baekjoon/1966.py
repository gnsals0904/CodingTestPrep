from collections import deque

t = int(input())
for _ in range(t):
    result = 0
    N, M = map(int, input().split())
    one_line = list(map(int, input().split()))
    priority_number_list = [0 for _ in range(9)]
    queue = deque()
    # 해당 index 의 우선순위 값 저장
    check_v = 0
    for i in range(N):
        now_v = one_line[i]
        if i == M:
            check_v = now_v
        priority_number_list[now_v - 1] += 1
        queue.append((now_v, i))
    for j in range(8, check_v - 1, -1):
        while priority_number_list[j] != 0:
            if queue[0][0] == j + 1:
                queue.popleft()
                result += 1
                priority_number_list[j] -= 1
            else:
                queue.rotate(-1)
    while queue:
        if queue[0][0] == check_v:
            v = queue.popleft()
            result += 1
            if v[1] == M:
                print(result)
                break
        else:
            queue.rotate(-1)
