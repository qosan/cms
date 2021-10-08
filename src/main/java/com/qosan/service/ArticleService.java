package com.qosan.service;

import com.qosan.model.Article;
import com.qosan.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ArticleService {

    private static final Logger log = LoggerFactory.getLogger(ArticleService.class);
    private final ArticleRepository articleRepository;

    public ArticleService(final ArticleRepository articleRepository1) {
        this.articleRepository = articleRepository1;

    }

    public Mono<ResponseEntity<Article>> create(Article article) {
        //TODO save image in filesystem, now we have only ids list
        //TODO check how we can send image in article objecy
        return articleRepository.save(article).map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response))
                .doOnError(e -> log.error("cannot create article: {}, {}", article, e.getMessage()))
                .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));
    }

    public Mono<ResponseEntity<Article>> update(Article article) {
        //TODO change status when update: use dto in request and convert to article and then send to repo
        return articleRepository.save(article).map(response -> ResponseEntity.ok().body(response))
                .doOnError(e -> log.error("cannot update article: {}, {}", article, e.getMessage()))
                .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));
    }

    public Flux<ResponseEntity<Article>> getAllArticle() {
        return articleRepository.findAll().map(response -> ResponseEntity.ok().body(response))
                .doOnError(e -> log.error("cannot get articles: {}", e.getMessage()))
                .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));
    }

    public Mono<ResponseEntity<Article>> getArticle(String id) {
        return articleRepository.findById(id).map(response -> ResponseEntity.ok().body(response))
                .doOnError(e -> log.error("cannot get article: {}, {}",id, e.getMessage()))
                .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));
    }

    public Mono<ResponseEntity<Void>> deleteArticle(String id) {
        return articleRepository.deleteById(id).map(response -> ResponseEntity.ok().body(response))
                .doOnError(e -> log.error("cannot delete article: {}, {}",id,  e.getMessage()))
                .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));
    }
}
