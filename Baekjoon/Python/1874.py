import sys
from collections import deque

# 이문제 쉽게푼 사람들은 진짜 쉽게품
n = int(input())
num_serial = deque()
stack = []
# 스택의 제일 위 값
now_stack_value = 0
# 리스트에서 어디까지 스택에 넣었는지 저장
now_num_serial_value = 0
result = []
stack_len = 0
check = False
check2 = False
can_use_list = [i + 1 for i in range(n)]
for _ in range(n):
    num_serial.append(int(sys.stdin.readline().rstrip()))
while num_serial:
    # 현재 찾아야하는 값
    now_value = num_serial.popleft()
    # 스택의 제일 위 값보다 큰값을 원하면
    if now_value > now_stack_value:
        if now_value >= now_num_serial_value:
            for j in range(now_num_serial_value, now_value):
                now_stack_value = can_use_list[j]
                stack_len += 1
                stack.append(can_use_list[j])
                result.append('+')
            stack.pop()
            stack_len -= 1
            result.append('-')
            # 길이보다 1 더 빼야함
            if stack_len != 0:
                now_stack_value = stack[stack_len - 1]
            else:
                now_stack_value = 0
            # idx 가 value 보다 1 적으므로
            now_num_serial_value = now_value
        else:
            print('NO')
            check = True
            break
    elif now_value == now_stack_value:
        stack.pop()
        stack_len -= 1
        result.append('-')
        # 길이보다 1 더 빼야함
        if stack_len != 0:
            now_stack_value = stack[stack_len - 1]
        else:
            now_stack_value = 0
    else:
        while stack:
            temp = stack.pop()
            stack_len -= 1
            # 길이보다 1 더 빼야함
            if stack_len != 0:
                now_stack_value = stack[stack_len - 1]
            else:
                now_stack_value = 0
            result.append('-')
            if temp == now_value:
                check2 = True
                break
        if stack_len == 0 and not check2:
            print('NO')
            check = True
            break

if not check:
    for x in result:
        print(x)
