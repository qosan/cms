package com.qosan.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ArticleDto {

    private String id;
    private LocalDateTime creationDate;
    private String signature;
    private LocalDateTime modifyDate;
    private List<String> imagesIds;
    private String title;
    private String content;
}
