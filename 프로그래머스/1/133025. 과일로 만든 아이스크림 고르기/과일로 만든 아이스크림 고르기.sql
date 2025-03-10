-- 코드를 입력하세요
SELECT fh.FLAVOR
from FIRST_HALF fh right join ICECREAM_INFO info on fh.FLAVOR = info.FLAVOR
where
    fh.TOTAL_ORDER > 3000
    && info.INGREDIENT_TYPE = 'fruit_based'
order by fh.TOTAL_ORDER desc