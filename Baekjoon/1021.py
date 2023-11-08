from collections import deque

N, M = map(int, input().split())
q_queue = deque(map(int, input().split()))
whole_queue = deque()
whole_queue_len = N
result = 0
for i in range(N):
    whole_queue.append(i + 1)
while q_queue:
    v = q_queue[0]
    v_idx = whole_queue.index(v)
    if v_idx == 0:
        whole_queue.popleft()
        q_queue.popleft()
        whole_queue_len -= 1
    # 2번 경우
    elif v_idx > whole_queue_len // 2:
        temp = whole_queue_len - v_idx
        result += temp
        whole_queue.rotate(temp)
    # 3번 경우
    else:
        result += v_idx
        temp = v_idx * -1
        whole_queue.rotate(temp)
print(result)
