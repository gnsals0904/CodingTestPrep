import sys


N, M = map(int, sys.stdin.readline().split())
girl_group = []

# 자료 채워넣기
for _ in range(N):
    member_name_set = set()
    girl_group_name = sys.stdin.readline().rstrip()
    member_num = int(sys.stdin.readline().rstrip())
    for _ in range(member_num):
        member_name_set.add(sys.stdin.readline().rstrip())
    temp = [girl_group_name, member_name_set]
    girl_group.append(temp)

# 질문
for _ in range(M):
    quest_name = sys.stdin.readline().rstrip()
    quest_number = int(sys.stdin.readline().rstrip())
    # member question
    if quest_number == 1:
        for x in girl_group:
            if quest_name in x[1]:
                print(x[0])
    else:
        for x in girl_group:
            if quest_name == x[0]:
                result = list(x[1])
                result.sort()
                for r in result:
                    print(r)
