package project.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.project.dto.ArticleForm;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create") //url요청 접수
    public String createArticle(ArticleForm form){ //메서드 생성 및 반환값 작성 //form데이터를 dto로 받기
        System.out.println(form.toString());
        return "";
    }
}
