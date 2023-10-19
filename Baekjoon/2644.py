import sys
sys.setrecursionlimit(1000000)


def dfs(v_list, count, search_x):
    v_list[search_x] = True
    count += 1
    for i in relationship_list[search_x]:
        if not v_list[i]:
            if i == target_y:
                result_list.append(count)
            dfs(v_list, count, i)


people_num = int(input())
target_x, target_y = map(int, input().split())
edge_num = int(input())
relationship_list = [[]for _ in range(people_num + 1)]
visit_list = [False] * (people_num + 1)
result_list = list()
for _ in range(edge_num):
    x, y = map(int, input().split())
    relationship_list[x].append(y)
    relationship_list[y].append(x)
r_count = 0
dfs(visit_list, r_count, target_x)
if len(result_list) == 0:
    print(-1)
else:
    print(result_list[0])


