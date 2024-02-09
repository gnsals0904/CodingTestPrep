str = input()
result = 0
for i in range(len(str)):
    num = int(str[i])
    result = result + (num ** 5)
print(result)