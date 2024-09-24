package com.farmstory.dto;

import com.farmstory.entity.Article;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ArticleDTO {

    private int artNo;
    private String group;
    private String category;
    private String title;
    private String content;
    private int file;
    private int hit;
    private int comment;
    private String author;
    private String regip;
    private String rdate;

    public Article toEntity() {
        return Article.builder()
                .artNo(artNo)
                .group(group)
                .category(category)
                .title(title)
                .content(content)
                .file(file)
                .hit(hit)
                .comment(comment)
                .author(author)
                .regip(regip)
                .rdate(rdate)
                .build();
    }

}
