s = list()
k = list()
for i in range(4):
    s.append(int(input()))
for j in range(2):
    k.append(int(input()))
result = 0
temp1 = min(s)
temp1_index = s.index(temp1)
for a in range(4):
    if a != temp1_index:
        result = result + s[a]
if k[0] > k[1]:
    result = result + k[0]
else:
    result = result + k[1]
print(result)
