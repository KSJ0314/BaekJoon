-- 코드를 입력하세요
SELECT      ANIMAL_ID, NAME
FROM        ANIMAL_INS 
WHERE       NAME LIKE '%el%' && ANIMAL_TYPE = 'Dog'
ORDER BY    NAME;