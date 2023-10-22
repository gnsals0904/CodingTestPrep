t = int(input())
for i in range(t):
    h_1, m_1, h_2, m_2 = map(int, input().split())
    result_hour = h_1 + h_2
    result_minute = m_1 + m_2
    if result_minute >= 60:
        result_minute -= 60
        result_hour += 1
    if result_hour > 12:
        result_hour -= 12
    print("#" + str(i + 1), result_hour, result_minute)
