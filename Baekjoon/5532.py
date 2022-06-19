vac_day = int(input())
math_hw = int(input())
kor_hw = int(input())
math_mx = int(input())
kor_mx = int(input())
if math_hw % math_mx > 0:
    math_day = math_hw // math_mx + 1
else:
    math_day = math_hw // math_mx
if kor_hw % kor_mx > 0:
    kor_day = kor_hw // kor_mx + 1
else:
    kor_day = kor_hw // kor_mx
if math_day > kor_day:
    print(vac_day - math_day)
else:
    print(vac_day - kor_day)