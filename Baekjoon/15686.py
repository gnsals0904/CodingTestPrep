import sys
from itertools import permutations, product, combinations


def cal_distance(per_nums):
    # 최대 N의 크기가 50 이므로
    temp_result = 0
    for i1 in range(N):
        for j1 in range(N):
            if graph[i1][j1] == 1:
                temp_dist = 101
                ptr = 0
                for now_cor in chicken_xy:
                    # 폐업한 치킨집 좌표이므로 넘어감
                    if per_nums[ptr] == 0:
                        ptr += 1
                        continue
                    ptr += 1
                    n_distance = abs(i1 - now_cor[0]) + abs(j1 - now_cor[1])
                    # 현재 계산한 거리가 더 작으면
                    if n_distance < temp_dist:
                        temp_dist = n_distance
                # 이 집의 최단거리는 temp_dist 에 들어있으므로
                temp_result += temp_dist
    # 다 계산하면 리턴
    return temp_result


N, M = map(int, input().split())
# 전체 치킨집 개수
chicken_num = 0
# 치킨 집 좌표 리스트
chicken_xy = []
graph = []
for i in range(N):
    one_line = list(map(int, sys.stdin.readline().split()))
    for j in range(N):
        if one_line[j] == 2:
            chicken_xy.append([i, j])
            chicken_num += 1
    graph.append(one_line)
nums = [0 for _ in range(chicken_num)]
combi = list(combinations(range(chicken_num), M))
perm_nums = []
for com in combi:
    temp_nums = nums[:]
    for x in com:
        temp_nums[x] = 1
    perm_nums.append(temp_nums)


result = 100 * 50 * 50 + 1
# 모든 경우에 대해서 수행
for now in perm_nums:
    temp_r = cal_distance(now)
    if result > temp_r:
        result = temp_r
print(result)
