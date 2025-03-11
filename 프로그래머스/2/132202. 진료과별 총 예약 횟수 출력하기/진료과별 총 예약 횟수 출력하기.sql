-- 코드를 입력하세요
-- APNT_YMD, APNT_NO, PT_NO, MCDP_CD, MDDR_ID, APNT_CNCL_YN, APNT_CNCL_YMD
-- 진료예약일시, 진료예약번호, 환자번호, 진료과코드, 의사ID, 예약취소여부, 예약취소날짜

SELECT MCDP_CD as 진료과코드, count(*) as 5월예약건수
from APPOINTMENT 
where APNT_YMD >= '2022-05-01' and APNT_YMD < '2022-06-01' 
group by 진료과코드
order by 5월예약건수, 진료과코드