-- 코드를 작성해주세요

select count(*) FISH_COUNT, (select FISH_NAME from FISH_NAME_INFO where FISH_TYPE = i.FISH_TYPE) FISH_NAME
from FISH_INFO i
group by FISH_NAME
order by FISH_COUNT desc;