from collections import deque

N, K = map(int, input().split())
queue = deque()
for i in range(N):
    queue.append(i + 1)
check = 0
result_list = []
while queue:
    now_v = queue.popleft()
    check += 1
    if check == K:
        result_list.append(now_v)
        check = 0
    else:
        queue.append(now_v)
result = str(result_list)
result = result[1:len(result)-1]
print('<' + result + '>')
