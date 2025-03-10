-- 코드를 입력하세요
SELECT count(*) USERS
from USER_INFO 
where
    year(joined) = 2021
    && age between 20 and 29