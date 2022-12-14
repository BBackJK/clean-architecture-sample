package bbackjk.test.caat.clean.article.application.service;

import bbackjk.test.caat.clean.article.application.port.in.BoardArticleListQuery;
import bbackjk.test.caat.clean.article.application.port.in.ListBoardArticleCommand;
import bbackjk.test.caat.clean.article.application.port.out.LoadBoardArticlePort;
import bbackjk.test.caat.clean.article.domain.BoardArticle;
import bbackjk.test.caat.clean.common.annotation.QueryCommand;
import lombok.RequiredArgsConstructor;

import java.util.List;

@QueryCommand
@RequiredArgsConstructor
public class ArticleListQueryService implements BoardArticleListQuery {

    private final LoadBoardArticlePort loadBoardArticlePort;

    @Override
    public List<BoardArticle> readPaging(ListBoardArticleCommand command) {
        return loadBoardArticlePort.loadPaging(command);
    }

    @Override
    public List<BoardArticle> readList(ListBoardArticleCommand command) {
        return loadBoardArticlePort.loadList(command);
    }
}
