-- 코드를 입력하세요
SELECT
    FLOOR(PRICE / 10000)*10000 AS PRICE_GROUP,
    COUNT(*) AS PRODUCTS
from PRODUCT
group by PRICE_GROUP
order by price;