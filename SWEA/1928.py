t = int(input())
for test_case in range(t):
    s = input()
    s_1 = ''
    for i in range(len(s)):
        s_ord = ord(s[i])
        if 65 <= s_ord <= 90:
            s_ord -= 65
        elif 97 <= s_ord <= 122:
            s_ord -= 71
        elif 48 <= s_ord <= 57:
            s_ord += 4
        elif s_ord == 43:
            s_ord += 19
        elif s_ord == 45:
            s_ord += 18
        else:
            print('wrong')
        s_bin_str = bin(s_ord)
        s_bin_str = s_bin_str[2:]
        while len(s_bin_str) != 6:
            s_bin_str = '0' + s_bin_str
        s_1 += str(s_bin_str)
    result = ''
    for k in range(6 * len(s) // 8):
        temp_str = s_1[0:8]
        temp_str = '0b' + temp_str
        temp_str = chr(int(temp_str, 2))
        result = result + temp_str
        s_1 = s_1[8:]
    print('#' + str(test_case + 1), result)
