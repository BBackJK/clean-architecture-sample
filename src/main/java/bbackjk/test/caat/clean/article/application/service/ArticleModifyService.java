package bbackjk.test.caat.clean.article.application.service;


import bbackjk.test.caat.clean.article.application.port.in.ArticleModifyUseCase;
import bbackjk.test.caat.clean.article.application.port.in.ModifyBoardArticleCommand;
import bbackjk.test.caat.clean.article.application.port.out.LoadBoardArticlePort;
import bbackjk.test.caat.clean.user.application.out.LoadUserPort;
import bbackjk.test.caat.clean.article.application.port.out.ModifyBoardArticlePort;
import bbackjk.test.caat.clean.article.domain.BoardArticle;
import bbackjk.test.caat.clean.user.domain.User;
import bbackjk.test.caat.clean.common.UseCase;
import bbackjk.test.caat.common.exception.UpdateNoPermissionException;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ArticleModifyService implements ArticleModifyUseCase {

    private final LoadBoardArticlePort loadBoardArticlePort;
    private final LoadUserPort loadUserPort;
    private final ModifyBoardArticlePort modifyBoardArticlePort;

    @Override
    public void modify(ModifyBoardArticleCommand command) {

        final BoardArticle boardArticle = loadBoardArticlePort.loadById(command.getBoardArticleId());
        final User loginUser = loadUserPort.loadUserById(command.getLoginUserId());

        if (boardArticle.isNotSameUser(loginUser)) {
            throw new UpdateNoPermissionException();
        }

        // 내용 수정
        boardArticle.modify(command.getTitle(), command.getContents(), loginUser);

        modifyBoardArticlePort.modify(boardArticle);
    }
}
