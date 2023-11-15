for test_case in range(1, 11):
    n, s = map(str, input().split())
    n = int(n)
    stack = []
    stack_count = 0
    for i in range(n):
        # 스택이 비어있지 않을때
        if stack_count > 0:
            # 스택의 top 과 비교 후 같으면
            if stack[stack_count - 1] == s[i]:
                stack.pop()
                stack_count -= 1
            # 다르면 그냥 push
            else:
                stack.append(s[i])
                stack_count += 1
        # 스택이 비어 있으면
        elif stack_count == 0:
            stack.append(s[i])
            stack_count += 1

    print(f"#{test_case}", "".join(stack))
