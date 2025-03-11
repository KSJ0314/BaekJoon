-- 코드를 입력하세요
SELECT hour(datetime) HOUR, count(*) COUNT
from ANIMAL_OUTS 
group by HOUR
having hour between 9 and 19
order by HOUR;