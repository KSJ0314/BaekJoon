-- 코드를 입력하세요
SELECT
    BOOK_ID,
    (select AUTHOR_NAME from AUTHOR where AUTHOR_ID = b.AUTHOR_ID) AUTHOR_NAME,
    date_Format(PUBLISHED_DATE, '%Y-%m-%d') PUBLISHED_DATE
from BOOK b
where CATEGORY = '경제'
order by PUBLISHED_DATE;