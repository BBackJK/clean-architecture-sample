package bbackjk.test.caat.clean.article.application.port.in;

import bbackjk.test.caat.clean.article.domain.BoardArticle;
import bbackjk.test.caat.clean.user.domain.User;
import bbackjk.test.caat.clean.common.SelfValidating;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class ModifyBoardArticleCommand extends SelfValidating<ModifyBoardArticleCommand> {

    @NotNull
    BoardArticle.BoardArticleId boardArticleId;

    @NotNull
    String title;
    @NotNull
    String contents;

    @NotNull
    User.UserId loginUserId;

    public ModifyBoardArticleCommand(
        BoardArticle.BoardArticleId boardArticleId
        , String title
        , String contents
        , User.UserId loginUserId
    ) {
        this.boardArticleId = boardArticleId;
        this.title = title;
        this.contents = contents;
        this.loginUserId = loginUserId;
        this.validateSelf();
    }
}
