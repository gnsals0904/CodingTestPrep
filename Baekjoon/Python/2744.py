string = input()
result = ""
for i in range(len(string)):
    if 64 < ord(string[i]) < 91:
        result = result + (chr(ord(string[i]) + 32))
    else:
        result = result + (chr(ord(string[i]) - 32))
print(result)
