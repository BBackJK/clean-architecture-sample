package bbackjk.test.caat.clean.article.application.service;


import bbackjk.test.caat.clean.article.application.port.in.ArticleRegisterUseCase;
import bbackjk.test.caat.clean.article.application.port.in.RegisterBoardArticleCommand;
import bbackjk.test.caat.clean.article.application.port.out.LoadBoardPort;
import bbackjk.test.caat.clean.user.application.out.LoadUserPort;
import bbackjk.test.caat.clean.article.application.port.out.RegisterBoardArticlePort;
import bbackjk.test.caat.clean.article.domain.Board;
import bbackjk.test.caat.clean.article.domain.BoardArticle;
import bbackjk.test.caat.clean.user.domain.User;
import bbackjk.test.caat.clean.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ArticleRegisterService implements ArticleRegisterUseCase {

    private final RegisterBoardArticlePort registerArticlePort;
    private final LoadBoardPort loadBoardPort;
    private final LoadUserPort loadUserPort;

    @Override
    public void register(RegisterBoardArticleCommand command) {

        final Board board = loadBoardPort.loadBoardById(command.getBoardId());
        final User loginUser = loadUserPort.loadUserById(command.getLoginUserId());

        registerArticlePort.register(
                BoardArticle.createRegisterInstance(
                        board
                        , loginUser
                        , command.getTitle()
                        , command.getContents()
                )
        );
    }
}
