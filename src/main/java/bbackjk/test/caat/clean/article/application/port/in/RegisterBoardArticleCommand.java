package bbackjk.test.caat.clean.article.application.port.in;

import bbackjk.test.caat.clean.article.domain.Board;
import bbackjk.test.caat.clean.user.domain.User;
import bbackjk.test.caat.clean.common.SelfValidating;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class RegisterBoardArticleCommand extends SelfValidating<RegisterBoardArticleCommand> {

    @NotNull
    Board.BoardId boardId;

    @NotNull(message = "제목은 필수값입니다.")
    String title;
    @NotNull(message = "내용은 필수값입니다.")
    String contents;

    @NotNull
    User.UserId loginUserId;

    public RegisterBoardArticleCommand(
        Board.BoardId boardId
        , String title
        , String contents
        , User.UserId loginUserId
    ) {
        this.boardId = boardId;
        this.title = title;
        this.contents = contents;
        this.loginUserId = loginUserId;

        this.validateSelf();
    }
}
