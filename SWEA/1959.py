t = int(input())
for test_case in range(t):
    n, m = map(int, input().split())
    n_list = list(map(int, input().split()))
    m_list = list(map(int, input().split()))
    result = 0
    if n > m:
        for j in range(n - m + 1):
            temp_result = 0
            for i in range(m):
                temp_result = temp_result + (n_list[i + j] * m_list[i])
            if temp_result > result:
                result = temp_result
    else:
        for j in range(m - n + 1):
            temp_result = 0
            for i in range(n):
                temp_result = temp_result + (m_list[i + j] * n_list[i])
            if temp_result > result:
                result = temp_result
    print("#" + str(test_case + 1), result)
