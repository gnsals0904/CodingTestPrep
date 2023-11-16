t = int(input())
for test_case in range(t):
    s = input()
    result = ''
    for i in range(len(s)):
        if s[i] == 'a' or s[i] == 'e' or s[i] == 'i' or s[i] == 'o' or s[i] == 'u':
            continue
        result += s[i]
    print(f"#{test_case + 1} {result}")
