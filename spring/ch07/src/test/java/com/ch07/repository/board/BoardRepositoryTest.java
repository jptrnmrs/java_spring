package com.ch07.repository.board;

import com.ch07.entity.board.Article;
import com.ch07.entity.board.Comment;
import com.ch07.entity.board.File;
import com.ch07.entity.board.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertUserTest() {
        User user = User.builder()
                .uid("s101")
                .name("신사임당")
                .nick("사임사임")
                .email("gentleman@imda.com")
                .build();

        userRepository.save(user);
    }

    @Test
    public void insertArticleTest() {
        User user = User.builder()
                .uid("s101")
                .build();

        Article article = Article.builder()
                .title("안녕하세요")
                .content("저는 신사임당")
                .user(user)
                .build();

        articleRepository.save(article);
    }

    @Test
    public void insertCommentTest() {
        User user = User.builder()
                .uid("s101")
                .build();

        Article article = Article.builder()
                .no(1)
                .build();

        Comment comment = Comment.builder()
                .content("신사가 맞습니다")
                .article(article)
                .user(user)
                .build();
        commentRepository.save(comment);

    }

    // 테스트4 - 파일 등록
    @Test
    public void insertFileTest() {
        Article article = Article.builder()
                .no(1)
                .build();

        File file = File.builder()
                .article(article)
                .oName("test.txt")
                .sName("124412sdjadhiwajsjdckaldw.txt")
                .build();

        fileRepository.save(file);


    }

    // 테스트5 - 글 전체 조회
    @Transactional
    @Test
    public void selectArticleTest() {
        List<Article> articles = articleRepository.findAll();
        for (Article article : articles) {
            System.out.println(article);
        }

    }

}
