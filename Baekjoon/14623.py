a = input()
b = input()
a = '0b' + a
b = '0b' + b
result = int(a, 2) * int(b, 2)
result = bin(result)
print(result[2:len(result)])