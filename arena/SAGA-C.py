import sys
from collections import deque

N = int(input())
fruit = list(map(int, sys.stdin.readline().split()))
check_fruit = []
check_len = 0

queue = deque()
queue_len = 0

count = 0
result = 0
for i in range(N):
    # 중복 체크 리스트의 길이가 0이면 비어있는 것이므로 그냥 넣고
    if check_len == 0:
        check_fruit.append([fruit[i], i])
        check_len += 1
        count += 1
        result += 1
    # 중복 체크 리스트의 길이가 1이면 확인을 해야함
    elif check_len == 1:
        # 중복 체크 리스트에 없는거면 넣고
        if fruit[i] != check_fruit[0][0]:
            check_fruit.append([fruit[i], i])
            check_len += 1
            count += 1
            result += 1
        # 이미 넣은 종류면 최신 인덱스 갱신
        else:
            check_fruit[0][1] = i
            count += 1
            result += 1
    # 중복 체크 리스트의 길이가 두 종류가 꽉 찬 것이므로
    else:
        # 이미 있는 과일이면
        if fruit[i] == check_fruit[0][0] or fruit[i] == check_fruit[1][0]:
            # 개수 증가 시키고
            count += 1
            # 최신 인덱스 최신화
            if check_fruit[0][0] == fruit[i]:
                check_fruit[0][1] = i
            else:
                check_fruit[1][1] = i
        # 새로운 종류의 과일이면
        else:
            # 최근에 나온 과일 종류는 나두고 예전에 나온 과일 종류를 삭제
            # count 값이 갱신되어야함. 예전에 나온 과일 종류의 인덱스 - 새로 들어온 과일 종류의 인덱스
            # 두 과일 종류의 인덱스 값중 큰 값이 최신 인덱스
            if check_fruit[0][1] > check_fruit[1][1]:
                count = i - check_fruit[1][1]
                check_fruit[1][0] = fruit[i]
                check_fruit[1][1] = i
            else:
                count = i - check_fruit[0][1]
                check_fruit[0][0] = fruit[i]
                check_fruit[0][1] = i
        if result < count:
            result = count
if N <= 2:
    print(N)
else:
    print(result)
