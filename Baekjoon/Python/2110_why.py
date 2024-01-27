import sys


N, C = map(int, sys.stdin.readline().split())
house = []
for _ in range(N):
    house.append(int(sys.stdin.readline().rstrip()))
house.sort()
# 집 최대 거리
max_dis = house[N - 1] - house[0]
# 내 생각에 놓은 공유기 위치 좌표 모음
maybe = []
if C == 2:
    print(max_dis)
else:
    maybe.append(house[0])
    # 앞으로 놓을 공유기의 개수
    wifi_num = C - 2
    # 이상적인 거리
    ideal_dis = max_dis / (wifi_num + 1)
    # 결과는 여기에
    result = house[N - 1] - house[0]
    # 내가 몇개를 놓았지?
    count = 0
    # 이분탐색으로 놓자
    for i in range(wifi_num):
        flag = False
        start = 0
        end = N - 1
        target = 0
        # 현재 찾아야하는 위치값
        find_dis = house[0] + ideal_dis * (i + 1)
        # 현재 찾은 임시 거리 값
        # temp_dis = 0
        while start < end:
            target = (end + start) // 2
            # 내가 찾는 이상적인 값이 마침 있으면 저장하고 break 하면 됨
            if house[target] == int(find_dis):
                # temp_dis = find_dis - house[0]
                maybe.append(house[target])
                flag = True
                break
            # 내가 찾는 이상적인 값과 가장 가까운 값을 찾자
            # 내가 찾는 값보다 크면 start 포인트를 옮기고
            if house[target] < find_dis:
                start = target + 1
            # 작으면 end 포인트를 옮기고
            else:
                end = target - 1
        # 내가 찾는 최적 값이 없었으니 아쉬운대로 넣고
        # if temp_dis == 0:
            # temp_dis = house[target - 1]
        if not flag:
            temp1 = abs(house[target - 1] - find_dis)
            temp2 = abs(house[target] - find_dis)
            temp3 = abs(house[target + 1] - find_dis)
            temp4 = min(temp1, temp2, temp3)
            if temp1 == temp4:
                maybe.append(house[target - 1])
            elif temp2 == temp4:
                maybe.append(house[target])
            else:
                maybe.append(house[target + 1])
        # 한바퀴 돌았으면 저장
        # if result > temp_dis:
        #     result = temp_dis
    maybe.append(house[N - 1])
    for i in range(1, C):
        temp_v = maybe[i] - maybe[i - 1]
        if max_dis > temp_v:
            max_dis = temp_v
    print(max_dis)
