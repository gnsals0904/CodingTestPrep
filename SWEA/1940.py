t = int(input())
for test_case in range(t):
    n = int(input())
    input_list = [[], []]
    for _ in range(n):
        one_line = list(map(int, input().split()))
        if one_line[0] == 0:
            input_list[0].append(0)
            input_list[1].append(0)
        else:
            input_list[0].append(one_line[0])
            input_list[1].append(one_line[1])
    result = 0
    now_speed = 0
    for k in range(n):
        if input_list[0][k] == 0:
            result = result + now_speed
        elif input_list[0][k] == 1:
            now_speed = now_speed + input_list[1][k]
            result = result + now_speed
        else:
            if now_speed < input_list[1][k]:
                now_speed = 0
            else:
                now_speed = now_speed - input_list[1][k]
            result = result + now_speed
    print("#" + str(test_case + 1), result)
