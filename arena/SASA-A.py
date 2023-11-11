import sys

N = int(input())
flower_list = list(map(int, sys.stdin.readline().split()))
Q = int(input())
for _ in range(Q):
    query = list(map(int, sys.stdin.readline().split()))
    # 꽃 개수 출력
    if query[0] == 1:
        l1 = query[1]
        r1 = query[2]
        k1 = query[3]
        count = 0
        for i in range(l1 - 1, r1):
            if flower_list[i] == k1:
                count += 1
        print(count)
    # 꽃 지우기
    else:
        l2 = query[1]
        r2 = query[2]
        for j in range(l2 - 1, r2):
            flower_list[j] = 0
