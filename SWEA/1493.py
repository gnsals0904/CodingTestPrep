T = int(input())
arr = []
for i in range(10000):
    if i == 0:
        arr.append(1)
    else:
        arr.append(arr[i - 1] + i + 1)


def find_cor(x):
    temp_idx = 0
    for i1 in range(10000):
        if i1 == 9999:
            temp_idx = 9999
            continue
        if arr[i1] == x:
            temp_p = 0
            temp_q = i1
            return temp_q, temp_p
        if arr[i1] < x < arr[i1 + 1]:
            temp_idx = i1
            break
    temp_value = 1 + arr[temp_idx]
    temp_p = temp_idx + 1
    temp_q = 0
    for k in range(temp_idx + 1):
        if temp_value == x:
            return temp_q, temp_p
        temp_value += 1
        temp_p -= 1
        temp_q += 1


def find_value(cor_x, cor_y):
    temp_v = arr[cor_x]
    for i2 in range(10000):
        if i2 == cor_y:
            temp_v += i2 + cor_x
            return temp_v
        if i2 == 0:
            continue
        temp_v += i2 + cor_x


for test_case in range(T):
    p, q = map(int, input().split())
    x1, y1 = find_cor(p)
    x2, y2 = find_cor(q)
    real_x = x1 + x2 + 2
    real_y = y1 + y2 + 2
    result = find_value(real_x - 1, real_y - 1)
    print(f"#{test_case + 1} {result}")
