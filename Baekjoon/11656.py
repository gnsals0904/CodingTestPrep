S = input()
s_list = []
len_S = len(S)
for i in range(len_S):
    s_list.append(S[i:])
s_list.sort()
for x in s_list:
    print(x)
