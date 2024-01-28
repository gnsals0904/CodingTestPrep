import sys


num_list = sys.stdin.readline().rstrip()
len_num_list = len(num_list)
result = 0
check = False
temp = ''
for i in range(len_num_list):
    # - 찾기
    if num_list[i] == '-':
        # 처음은 무조건 더하고
        if not check:
            result += int(temp)
            temp = ''
        # 처음이 아니면 빼고
        else:
            result -= int(temp)
            temp = ''
        check = True
    elif num_list[i] == '+' and not check:
        result += int(temp)
        temp = ''
    # + 이지만 앞에 - 이므로 -로
    elif num_list[i] == '+' and check:
        result -= int(temp)
        temp = ''
    else:
        temp += num_list[i]
if check:
    result -= int(temp)
if not check:
    result += int(temp)
print(result)
