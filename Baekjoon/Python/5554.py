second = list()
for i in range(4):
    second.append(int(input()))
result = 0
for j in range(4):
    result = result + second[j]
print(result//60)
print(result%60)