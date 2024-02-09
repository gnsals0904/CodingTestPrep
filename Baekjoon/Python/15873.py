n = input()
result = 0
if len(n) == 2:
    result = int(n[0]) + int(n[1])
elif len(n) == 3:
    if int(n[1]) == 0:
        result = 10 + int(n[2])
    elif int(n[2]) == 0:
        result = 10 + int(n[0])
else:
    result = 20
print(result)
