import sys


num_list = sys.stdin.readline().rstrip()
len_num_list = len(num_list)
max_r = -99999*11
r_start_idx = 0
r_end_idx = 0
result = 0
check = False
for i in range(len_num_list):
    # - 위치 찾기
    if num_list[i] == '-':
        # - 가 있는경우
        check = True
        # - 위치 저장
        r_start_idx = i
        temp = ''
        temp_r = 0
        flag = False
        for j in range(i + 1, len_num_list):
            if num_list[j] == '+' or num_list[j] == '-':
                # 첫번째 수는 무조건 더하고 이전에 나온 기호값이 + 면 더한다
                if not flag:
                    temp_r += int(temp)
                    temp = ''
                # 이전에 나온 기호값이 - 면 뺀다
                else:
                    temp_r -= int(temp)
                    temp = ''
                if num_list[j] == '+':
                    flag = False
                if num_list[j] == '-':
                    flag = True
                if max_r < temp_r:
                    max_r = temp_r
                    # 기호의 위치 저장 이 앞이 닫는괄호
                    r_end_idx = j
            else:
                temp += num_list[j]
            if j == len_num_list - 1:
                if not flag:
                    temp_r += int(temp)
                else:
                    temp_r -= int(temp)
                if max_r < temp_r:
                    max_r = temp_r
                    # 기호의 위치 저장 이 앞이 닫는괄호
                    r_end_idx = j + 1

# -가 식에 존재할때
if check:
    # 여는 괄호 나올때까지 결과 계산
    temp = ''
    flag = False
    temp_r = 0
    for i in range(r_start_idx):
        if num_list[i] == '+' or num_list[i] == '-':
            # 첫번째 수는 무조건 더하고 이전에 나온 기호값이 + 면 더한다
            if not flag:
                temp_r += int(temp)
                temp = ''
            # 이전에 나온 기호값이 - 면 뺀다
            else:
                temp_r -= int(temp)
                temp = ''
            if num_list[j] == '+':
                flag = False
            if num_list[j] == '-':
                flag = True
        else:
            temp += num_list[i]
    # 마지막 수를 계산안해줫으니 계산 해주기
    if not flag:
        temp_r += int(temp)
    else:
        temp_r -= int(temp)
    # 결과 값에 괄호 까지의 결과 계산
    result = (temp_r - max_r)

    # 괄호 뒤가 없는경우
    if r_end_idx == len_num_list:
        print(result)
    # 괄호 뒤가 있으면
    else:
        temp = ''
        flag = False
        temp_r = 0
        for i in range(r_end_idx + 1, len_num_list):
            if num_list[i] == '+' or num_list[i] == '-':
                # 첫번째 수는 무조건 더하고 이전에 나온 기호값이 + 면 더한다
                if not flag:
                    temp_r += int(temp)
                    temp = ''
                # 이전에 나온 기호값이 - 면 뺀다
                else:
                    temp_r -= int(temp)
                    temp = ''
                if num_list[i] == '+':
                    flag = False
                if num_list[i] == '-':
                    flag = True
            else:
                temp += num_list[i]
        # 마지막 수를 계산안해줫으니 계산 해주기
        if not flag:
            temp_r += int(temp)
        else:
            temp_r -= int(temp)
        # 마지막 결과 계산 후 출력
        if num_list[r_end_idx] == '-':
            result = result - temp_r
        else:
            result = result + temp_r
        print(result)
# -가없으면 그냥 계산
else:
    temp = ''
    temp_r = 0
    for i in range(len_num_list):
        if num_list[i] == '+':
            temp_r += int(temp)
            temp = ''
        else:
            temp += num_list[i]
    # 마지막 수 더해주기
    temp_r += int(temp)
    print(temp_r)
