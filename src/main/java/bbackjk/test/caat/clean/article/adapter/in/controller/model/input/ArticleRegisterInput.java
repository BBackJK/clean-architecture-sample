package bbackjk.test.caat.clean.article.adapter.in.controller.model.input;


import bbackjk.test.caat.clean.article.application.port.in.RegisterBoardArticleCommand;
import bbackjk.test.caat.clean.article.domain.Board;
import bbackjk.test.caat.clean.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleRegisterInput {

    private String boardId;
    private String title;
    private String contents;

    public RegisterBoardArticleCommand toCommand(long loginUserId) {
        return new RegisterBoardArticleCommand(
                new Board.BoardId(this.boardId)
                , this.title
                , this.contents
                , new User.UserId(loginUserId)
        );
    }
}
