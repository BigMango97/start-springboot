INSERT INTO article(title, content) VALUES('가가가가','11111');
INSERT INTO article(title, content) VALUES('나나나나','22222');
INSERT INTO article(title, content) VALUES('다다다다','33333');

INSERT INTO article(title, content) VALUES('당신의 인생영화는?','댓글 고');
INSERT INTO article(title,content) VALUES('당신의 소울푸드는?','댓글 고고');
INSERT INTO article(title, content) VALUES('당신의 취미는?','댓글 고고고');
-- 4번 게시글 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(4,'park','굿 윌 헌팅');
INSERT INTO comment(article_id, nickname, body) VALUES(4,'kim','아이 엠 샘');
INSERT INTO comment(article_id, nickname, body) VALUES(4,'Choi','쇼생크 탈출');
-- 5번 게시글 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(5,'park','치킨');
INSERT INTO comment(article_id, nickname, body) VALUES(5,'kim','샤브샤브');
INSERT INTO comment(article_id, nickname, body) VALUES(5,'Choi','초밥');
-- 6번 게시글 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(6,'park','조깅');
INSERT INTO comment(article_id, nickname, body) VALUES(6,'kim','유튜브 시청');
INSERT INTO comment(article_id, nickname, body) VALUES(6,'Choi','독서');