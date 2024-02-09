N = int(input())
result_list = []
i = 2
while N != 1:
    if N < i * i:
        result_list.append(N)
        break
    if N % i == 0:
        result_list.append(i)
        N = N // i
        continue
    i += 1
for x in result_list:
    print(x)
