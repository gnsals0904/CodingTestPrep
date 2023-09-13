N = int(input())
string_array = list()

for i in range(N):
    s = input()
    string_array.append(s)

string_array_temp = set(string_array)
string_array = list(string_array_temp)

result = sorted(string_array, key=lambda x: [len(x), x])

for j in range(len(result)):
    if j == len(result) - 1:
        print(result[j], end='')
    else:
        print(result[j])
