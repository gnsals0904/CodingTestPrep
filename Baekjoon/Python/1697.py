from collections import deque

N, K = map(int, input().split())
max_v = 10 ** 5
dp = [0] * (max_v + 1)


def bfs():
    queue = deque()
    queue.append(N)
    while queue:
        now = queue.popleft()
        if now == K:
            break
        for v in (now - 1, now + 1, 2 * now):
            if 0 <= v <= max_v and dp[v] == 0:
                dp[v] = dp[now] + 1
                queue.append(v)
    return now


result = bfs()
if N == K:
    print(0)
else:
    print(dp[result])
