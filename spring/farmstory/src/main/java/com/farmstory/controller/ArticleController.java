package com.farmstory.controller;

import com.farmstory.dto.ArticleDTO;
import com.farmstory.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/article/list")
    public String list(Model model) {
        return "article/list";
    }
    @GetMapping("/article/view")
    public String view(@RequestParam("no") String no, Model model) {
        ArticleDTO article = articleService.getArticleById(no);
        model.addAttribute("article", article);
        return "article/view";
    }
    @GetMapping("/article/modify")
    public String modify(Model model) {
        return "article/modify";
    }
    @GetMapping("/article/delete")
    public String delete(Model model) {
        return "article/delete";
    }

}
