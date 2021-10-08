package com.qosan.controller;

import com.qosan.model.Article;
import com.qosan.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(final ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/")
    public Mono<ResponseEntity<Article>> createArticle(@RequestBody Article article) {

        return articleService.create(article);
    }

    @PutMapping("/")
    public Mono<ResponseEntity<Article>> updateArticle(@RequestBody Article article) {

        return articleService.update(article);
    }

    @GetMapping("/")
    public Flux<ResponseEntity<Article>> getAllArticle() {

        return articleService.getAllArticle();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Article>> getArticle(@PathVariable("id") String id) {

        return articleService.getArticle(id);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteArticle(@PathVariable("id") String id) {

        return articleService.deleteArticle(id);

    }
}
