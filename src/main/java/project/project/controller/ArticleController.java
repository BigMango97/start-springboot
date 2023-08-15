package project.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.project.dto.ArticleForm;
import project.project.entity.Article;

import project.project.repository.ArticleRepository;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create") //url요청 접수
    public String createArticle(ArticleForm form){ //메서드 생성 및 반환값 작성 //form데이터를 dto로 받기
        System.out.println(form.toString());
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        System.out.println(article.toString()); //DTO가 엔티티로 잘 변환되는지 확인 출력
         // 2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString()); //article이 DB에 잘 저장되는지 확인 출력s
        return "";
    }
}
