-- 코드를 작성해주세요

select
    (select sum(SCORE) SCORE
    from HR_GRADE
    where year = 2022
    group by EMP_NO
    order by SCORE desc
    limit 1) SCORE,
    EMP_NO,
    EMP_NAME,
    POSITION,
    EMAIL
from HR_EMPLOYEES
where EMP_NO = (select g.EMP_NO
                from (select EMP_NO, sum(SCORE) SCORE
                        from HR_GRADE
                        where year = 2022
                        group by EMP_NO
                        order by SCORE desc
                        limit 1) g)