package project.project.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import project.project.entity.Article;
import project.project.entity.Comment;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CommentRepositoryTest {
@Autowired
CommentRepository commentRepository; //commentRepository 객체 주입
    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /*Case1 : 4번 게시글의 모든 댓글 조회*/
        {
            //1. 입력 데이터 준비
            Long articleId = 4L;
            //2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //3. 예상 데이터
            Article article = new Article(4L, "당신의 인생영화는?","댓글 고");
            Comment a = new Comment(1L,article,"park","굿 윌 헌팅");
            Comment b = new Comment(2L,article,"kim","아이 엠 샘");
            Comment c = new Comment(3L,article,"Choi","쇼생크 탈출");
            List<Comment> expected = Arrays.asList(a,b,c);
            //4. 비교 및 검증
            assertEquals(expected.toString(),comments.toString(),"4번 글의 모든 데이터를 출력!");
        }
        /*Case3 : 1번 게시글의 모든 댓글 조회*/
        {
            //1. 입력 데이터 준비
            Long articleId = 1L;
            //2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //3. 예상 데이터
            Article article = new Article(1L, "가가가가","11111");
            Comment a = new Comment(1L,article,"park","굿 윌 헌팅");
            Comment b = new Comment(2L,article,"kim","아이 엠 샘");
            Comment c = new Comment(3L,article,"Choi","쇼생크 탈출");
            List<Comment> expected = Arrays.asList();
            //4. 비교 및 검증
            assertEquals(expected.toString(),comments.toString(),"1번 글은 댓글이 없음");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /*Case 2: "park"의 모든 댓글 조회*/
        {
            //1. 입력 데이터 준비
            String nickname = "park";
            //2. 실제 데이터
            List<Comment> comments = commentRepository.findByNickname(nickname);
            //3. 예상 데이터
            Comment a = new Comment(1L, new Article(4L, "당신의 인생영화는?","댓글 고"),nickname,"굿 윌 헌팅");
            Comment b = new Comment(4L, new Article(5L, "당신의 소울푸드는?","댓글 고고"),nickname,"치킨");
            Comment c = new Comment(7L, new Article(6L, "당신의 취미는?","댓글 고고고"),nickname,"조깅");
            List<Comment> expected = Arrays.asList(a,b,c);
            //4. 비교 및 검증
            assertEquals(expected.toString(),comments.toString(),"park의 모든 댓글 출력!");
        }
    }
}