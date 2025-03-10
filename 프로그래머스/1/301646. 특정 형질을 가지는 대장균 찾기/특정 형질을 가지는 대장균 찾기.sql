-- 코드를 작성해주세요
select  count(*) COUNT
from    ECOLI_DATA
where  
    (GENOTYPE & 1 << 1) = 0
    && ((GENOTYPE & 1 << 0) != 0 || (GENOTYPE & 1 << 2) != 0)