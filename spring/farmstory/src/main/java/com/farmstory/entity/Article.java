package com.farmstory.entity;

import com.farmstory.dto.ArticleDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artNo;

    @Column(name = "artGroup")
    private String group;

    @Column(name = "artCate")
    private String category;

    @Column(name = "artTitle")
    private String title;

    @Column(name = "artContent")
    private String content;

    @Column(name = "artFile")
    private int file;

    @Column(name = "artHit")
    private int hit;

    @Column(name = "artComment")
    private int comment;

    @Column(name = "artWriter")
    private String author;

    @Column(name = "artregip")
    private String regip;

    @Column(name = "artRdate")
    private String rdate;

    public ArticleDTO toDTO (){
        return ArticleDTO.builder()
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
