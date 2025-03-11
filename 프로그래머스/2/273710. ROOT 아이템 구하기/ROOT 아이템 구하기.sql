-- 코드를 작성해주세요
select ITEM_ID, (select ITEM_NAME from ITEM_INFO  where ITEM_ID = t.ITEM_ID)	ITEM_NAME
from ITEM_TREE t
where PARENT_ITEM_ID is null