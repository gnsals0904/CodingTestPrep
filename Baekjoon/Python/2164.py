from collections import deque

N = int(input())
queue = deque()
check = False
for i in range(N):
    queue.append(i + 1)
while len(queue) != 1:
    if not check:
        queue.popleft()
        check = True
    else:
        queue.append(queue.popleft())
        check = False
print(queue.popleft())

