import sys
from collections import deque

N = int(input())
queue = deque()
count = 0
for i in range(N):
    one_line = list(map(str, sys.stdin.readline().split()))
    if one_line[0] == 'push_front':
        queue.appendleft(one_line[1])
        count += 1
    elif one_line[0] == 'push_back':
        queue.append(one_line[1])
        count += 1
    elif one_line[0] == 'size':
        print(count)
    elif one_line[0] == 'empty':
        if count == 0:
            print(1)
        else:
            print(0)
    elif one_line[0] == 'pop_front':
        if count == 0:
            print(-1)
        else:
            print(queue.popleft())
            count -= 1
    elif one_line[0] == 'pop_back':
        if count == 0:
            print(-1)
        else:
            print(queue.pop())
            count -= 1
    # front
    elif one_line[0] == 'front':
        if count == 0:
            print(-1)
        else:
            print(queue[0])
    # back
    else:
        if count == 0:
            print(-1)
        else:
            print(queue[count - 1])
