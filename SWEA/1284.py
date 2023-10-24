t = int(input())
for test_case in range(t):
    p, q, r, s, w = map(int, input().split())
    a_result = w * p
    if r < w:
        b_result = q + s * (w - r)
    else:
        b_result = q
    print("#" + str(test_case + 1), min(a_result, b_result))
