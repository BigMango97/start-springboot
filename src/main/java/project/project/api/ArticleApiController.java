package project.project.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.project.ArticleService;
import project.project.dto.ArticleForm;
import project.project.entity.Article;
import project.project.repository.ArticleRepository;

import java.util.List;

@Slf4j
@RestController // Rest컨트롤러선언
public class ArticleApiController {
@Autowired
private ArticleService articleService;
//GET
//전체조회
    @GetMapping("/api/articles") // URL요청접수
    public List<Article> index(){
        return articleService.index();
    }
//단건조회
    @GetMapping("/api/articles/{id}") // URL요청접수
    public Article show(@PathVariable Long id){
        return articleService.show(id);
    }
//POST
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
        Article created = articleService.create(dto); //서비스로 게시글 생성
        return (created!=null)?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
//PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto){
       Article updated = articleService.update(id,dto);
       return (updated!=null)?
               ResponseEntity.status(HttpStatus.OK).body(updated):
               ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
//    //DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article deleted = articleService.delete(id);
    return(deleted != null) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
    ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTEST(
            @RequestBody List<ArticleForm> dtos){
        List<Article> createdList = articleService.createArticles(dtos);
    return(createdList != null) ? ResponseEntity.status(HttpStatus.OK).body(createdList):
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
