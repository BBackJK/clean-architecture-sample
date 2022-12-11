package bbackjk.test.caat.clean.article.domain;


import bbackjk.test.caat.clean.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardArticle {

    @Getter BoardArticleId id;
    @Getter Board board;
    @Getter
    User user;

    @Getter String title;
    @Getter String contents;
    @Getter long viewCount;

    @Getter LocalDateTime createdAt;
    @Getter User createdBy;
    @Getter LocalDateTime updatedAt;
    @Getter User updatedBy;

    List<BoardComment> boardCommentList;

    @Value
    public static class BoardArticleId {
        Long value;
    }

    public static BoardArticle createRegisterInstance(Board board, User loginUser, String title, String contents) {
        return new BoardArticle(
                null
                , board
                , loginUser
                , title
                , contents
                , 0
                , LocalDateTime.now()
                , loginUser
                , LocalDateTime.now()
                , loginUser
                , Collections.emptyList()
        );
    }

    public static BoardArticle of(
            BoardArticleId id
            , Board board
            , User user
            , String title
            , String contents
            , long viewCount
            , LocalDateTime createdAt
            , User createdBy
            , LocalDateTime updatedAt
            , User updatedBy
            , List<BoardComment> boardCommentList
    ) {
        return new BoardArticle(
                id
                , board
                , user
                , title
                , contents
                , viewCount
                , createdAt
                , createdBy
                , updatedAt
                , updatedBy
                , boardCommentList
        );
    }

    public void modify(String title, String contents, User loginUser) {
        this.title = title;
        this.contents = contents;
        this.updatedBy = loginUser;
        this.updatedAt = LocalDateTime.now();
    }

    public boolean isNotSameUser(User loginUser) {
        return user == null || loginUser == null || user.getId().getValue() != loginUser.getId().getValue();
    }

    public void increaseViewCount() {
        this.viewCount += 1;
    }
}
