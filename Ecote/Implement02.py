N = int(input())
z, x, y = 0, 0, 0
result = 0
while True:
    str_y = str(y)
    str_x = str(x)
    str_z = str(z)
    if '3' in str_y or '3' in str_x or '3' in str_z:
        result += 1
    if y == 59:
        if x == 59:
            x = 0
            z += 1
            y = 0
            if z == N + 1:
                break
        else:
            x += 1
            y = 0
    else:
        y += 1
print(result)