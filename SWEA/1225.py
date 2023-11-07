from collections import deque

for tc in range(10):
    t = int(input())
    queue = deque(map(int, input().split()))
    count = 1
    while queue:
        value = queue.popleft()
        if count > 5:
            count = 1
        value -= count
        if value <= 0:
            value = 0
            queue.append(value)
            break
        queue.append(value)
        count += 1
    print("#" + str(t), *queue)
