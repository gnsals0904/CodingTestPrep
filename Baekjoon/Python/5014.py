from collections import deque

F, S, G, U, D = map(int, input().split())
floor = [-1 for _ in range(F)]
vector = [U, D * -1]
queue = deque()
count = 0
queue.append((S - 1, count))
floor[S - 1] = 0


def bfs():
    while queue:
        x, now_c = queue.popleft()
        for v in vector:
            nx = x + v
            if nx < 0 or nx >= F:
                continue
            if floor[nx] == -1:
                queue.append((nx, now_c + 1))
                floor[nx] = now_c + 1
            if nx == G - 1:
                return


bfs()
result = floor[G - 1]
if result != -1:
    print(result)
else:
    print("use the stairs")
