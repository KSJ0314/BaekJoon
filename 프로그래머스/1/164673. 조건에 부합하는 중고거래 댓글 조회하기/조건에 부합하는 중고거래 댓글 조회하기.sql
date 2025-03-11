-- 코드를 입력하세요
-- 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일
SELECT  gb.TITLE, gr.BOARD_ID, gr.REPLY_ID, gr.WRITER_ID, gr.CONTENTS, date_format(gr.CREATED_DATE, '%Y-%m-%d') CREATED_DATE
from    USED_GOODS_BOARD gb join USED_GOODS_REPLY gr on gb.BOARD_ID = gr.BOARD_ID
where   gb.CREATED_DATE between '2022-10-01' and '2022-10-31'
order by gr.CREATED_DATE, gb.TITLE;

-- where   year(gb.CREATED_DATE) = 2022 && month(gb.CREATED_DATE) = 10