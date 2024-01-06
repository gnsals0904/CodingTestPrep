import sys
from collections import deque

T = int(input())
for _ in range(T):
    check = False
    s = sys.stdin.readline().rstrip()
    queue_len = int(sys.stdin.readline().rstrip())
    s1 = sys.stdin.readline().rstrip()
    s1 = s1[1:len(s1) - 1]
    if queue_len != 0:
        queue = deque(map(int, s1.split(',')))
    else:
        queue = deque()
    error_check = False
    result = []
    for x in s:
        if x == 'R':
            if not check:
                check = True
            else:
                check = False
        else:
            if check:
                if queue_len > 0:
                    queue.pop()
                    queue_len -= 1
                else:
                    # 에러 발생
                    error_check = True
                    break
            # 바른 방향
            else:
                if queue_len > 0:
                    queue.popleft()
                    queue_len -= 1
                else:
                    # 에러 발생
                    error_check = True
                    break
    if error_check:
        print("error")
    else:
        if check:
            queue.reverse()
        result_s = '['
        if queue_len != 0:
            while queue:
                now_v = queue.popleft()
                queue_len -= 1
                if queue_len <= 0:
                    result_s = result_s + str(now_v) + ']'
                else:
                    result_s = result_s + str(now_v) + ','
        else:
            result_s += ']'
        print(result_s)
