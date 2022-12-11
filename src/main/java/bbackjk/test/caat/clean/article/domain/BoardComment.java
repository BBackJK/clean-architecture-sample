package bbackjk.test.caat.clean.article.domain;

import bbackjk.test.caat.clean.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class BoardComment {

    BoardCommentId id;
    BoardArticle.BoardArticleId boardArticleId;
    User.UserId userId;

    String contents;

    @Value
    public static class BoardCommentId {
        long value;
    }

    public static BoardComment of(
            BoardCommentId id
            , BoardArticle.BoardArticleId boardArticleId
            , User.UserId userId
            , String contents
    ) {
        return new BoardComment(
                id
                , boardArticleId
                , userId
                , contents
        );
    }
}
