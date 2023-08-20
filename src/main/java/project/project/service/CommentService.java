package project.project.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.project.dto.CommentDto;
import project.project.entity.Article;
import project.project.entity.Comment;
import project.project.repository.ArticleRepository;
import project.project.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static project.project.dto.CommentDto.createCommentDto;

@Service // 서비스로 선언
public class CommentService {
    @Autowired
    private CommentRepository commentRepository; // 댓글 리파지터리 객체 주입
    @Autowired
    private ArticleRepository articleRepository; //게시글 리파지터리 객체 주입

    public List<CommentDto> comments(Long articleId) {
//        //1. 댓글 조회
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//        //2. 엔티티 ->DTO 변환
//        List<CommentDto> dtos = new ArrayList<CommentDto>();
//        //3. 결과 반환
//        for(int i=0; i<comments.size(); i++){
//            Comment c = comments.get(i);
//            CommentDto dto = createCommentDto(c);
//            dtos.add(dto);
//        }

        //3. 결과 반환
        return commentRepository.findByArticleId(articleId).stream().map(comment -> CommentDto.createCommentDto(comment)).collect(Collectors.toList());
    }

@Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        // 1. 게시글 조회 및 예외 발생
    Article article = articleRepository.findById(articleId).orElseThrow(()-> new IllegalArgumentException("댓글 실패 ! " + "대상 게시글이 없습니다!"));
        // 2. 댓글 엔티티 생성
    Comment comment = Comment.createComment(dto,article);
        // 3. 댓글 엔티티를 DB에 저장
    Comment created = commentRepository.save(comment);
        // 4. DTO로 변환해 반환
    return  CommentDto.createCommentDto(created);
    }

    @Transactional // update메서드는 DB의 내용을 변경하므로 실패할 경우를 대비해서 롤백할 수 있도록 추가
    public CommentDto update(Long id, CommentDto dto) {
        // 1. 댓글 조회 예외 발생
        Comment target = commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("댓글 수정 실패!" + "대상 댓글이 없습니다."));
        // 2. 댓글 수정
        target.patch(dto);
        // 3. DB로 갱신
        Comment updated = commentRepository.save(target);
        // 4. 댓글 엔티티를 DTO로 변환 및 반환
        return CommentDto.createCommentDto(updated);
    }
    @Transactional
    public CommentDto delete(Long id) {
        // 1. 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("댓글 삭제 실패!" + "대상 댓글이 없습니다."));
        // 2. 댓글 삭제
        commentRepository.delete(target);
        // 3. 삭제 댓글을 DTO 변환 및 반환
        return CommentDto.createCommentDto(target);
    }
}
