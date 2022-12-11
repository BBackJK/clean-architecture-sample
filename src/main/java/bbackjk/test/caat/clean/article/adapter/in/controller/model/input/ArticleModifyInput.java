package bbackjk.test.caat.clean.article.adapter.in.controller.model.input;


import bbackjk.test.caat.clean.article.application.port.in.ModifyBoardArticleCommand;
import bbackjk.test.caat.clean.article.domain.BoardArticle;
import bbackjk.test.caat.clean.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ArticleModifyInput {

    private long id;
    private String title;
    private String contents;

    public ModifyBoardArticleCommand toCommand(long loginUserId) {
        return new ModifyBoardArticleCommand(
                new BoardArticle.BoardArticleId(this.id)
                , this.title
                , this.contents
                , new User.UserId(loginUserId)
        );
    }
}
