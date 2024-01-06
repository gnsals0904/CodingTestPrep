import sys
from collections import deque

N = int(input())
reservation_list = []
for _ in range(N):
    one_line = list(map(int, sys.stdin.readline().split()))
    reservation_list.append(one_line)
reservation_list.sort(key=lambda x: (x[1], x[0]))
queue = deque(reservation_list)
result = 1
temp = queue.popleft()
while queue:
    if temp[1] > queue[0][0]:
        queue.popleft()
    else:
        temp = queue.popleft()
        result += 1
print(result)
