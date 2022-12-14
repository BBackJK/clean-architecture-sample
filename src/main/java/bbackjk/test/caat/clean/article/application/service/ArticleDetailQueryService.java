package bbackjk.test.caat.clean.article.application.service;

import bbackjk.test.caat.clean.article.application.port.in.BoardArticleDetailQuery;
import bbackjk.test.caat.clean.article.application.port.out.LoadBoardArticlePort;
import bbackjk.test.caat.clean.article.application.port.out.ModifyBoardArticlePort;
import bbackjk.test.caat.clean.article.domain.BoardArticle;
import bbackjk.test.caat.clean.common.annotation.QueryCommand;
import lombok.RequiredArgsConstructor;

@QueryCommand
@RequiredArgsConstructor
public class ArticleDetailQueryService implements BoardArticleDetailQuery {

    private final LoadBoardArticlePort loadBoardArticlePort;

    private final ModifyBoardArticlePort modifyBoardArticlePort;


    @Override
    public BoardArticle getById(BoardArticle.BoardArticleId id) {
        return loadBoardArticlePort.loadByIdWithComments(id);
    }

    @Override
    public BoardArticle readById(BoardArticle.BoardArticleId id) {

        final BoardArticle detail = loadBoardArticlePort.loadByIdWithComments(id);

        detail.increaseViewCount();

        modifyBoardArticlePort.modify(detail);

        return detail;
    }
}
