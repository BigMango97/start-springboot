package project.project.repository;

import org.springframework.data.repository.CrudRepository;
import project.project.entity.Article;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article,Long> {
    @Override
    ArrayList<Article> findAll();
}
