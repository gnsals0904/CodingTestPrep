t = int(input())
l1 = list(map(int, input().split()))
y_result = 0
y_sum = 0
m_result = 0
m_sum = 0
for i in range(t):
    y_result = (l1[i] // 30 + 1) * 10
    m_result = (l1[i] // 60 + 1) * 15
    y_sum = y_result + y_sum
    m_sum = m_result + m_sum
if y_sum < m_sum:
    print("Y " + str(y_sum))
elif y_sum > m_sum:
    print("M " + str(m_sum))
else:
    print("Y M " + str(y_sum))

