package project.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.project.dto.ArticleForm;
import project.project.entity.Article;
import org.springframework.ui.Model;

import project.project.repository.ArticleRepository;

@Slf4j //로깅 기능을 위한 어노테이션 추가
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository; // -> 리파지터리 구현객체 주입받기
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create") //url요청 접수
    public String createArticle(ArticleForm form){ //메서드 생성 및 반환값 작성 //form데이터를 dto로 받기
        System.out.println(form.toString());
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(form.toString());
        //System.out.println(article.toString()); //DTO가 엔티티로 잘 변환되는지 확인 출력
        // 2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString()); //article이 DB에 잘 저장되는지 확인 출력s
        return "";
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){ //id를 매개변수로 가져오기
        log.info("id =" + id); //id를 잘 가져왔는지 확인하기
        // 1. id를 조회해 데이터를 가져오기 -> DB에서 데이터를 가져오는 주체 : 리파지터리
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2. 모델에 데이터를 등록하기
        model.addAttribute("article",articleEntity);
        // 3. 뷰 페이지 반환하기
        return "articles/show";
    }
}
