package project.project.repository;

import org.springframework.data.repository.CrudRepository;
import project.project.entity.Article;

public interface ArticleRepository extends CrudRepository<Article,Long> {
}
