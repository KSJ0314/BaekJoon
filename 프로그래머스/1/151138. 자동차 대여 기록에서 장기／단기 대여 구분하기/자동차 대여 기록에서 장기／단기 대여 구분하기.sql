-- 코드를 입력하세요
SELECT
    HISTORY_ID,
    CAR_ID,
    date_format(START_DATE, '%Y-%m-%d'),
    date_format(END_DATE, '%Y-%m-%d'),
    if(datediff(END_DATE,START_DATE) >= 29, "장기 대여", "단기 대여") RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where month(START_DATE) = 9
order by HISTORY_ID desc