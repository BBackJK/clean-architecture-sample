package bbackjk.test.caat.clean.article.application.port.in;

import bbackjk.test.caat.clean.article.domain.BoardArticle;

import java.util.List;

public interface BoardArticleListQuery {

    List<BoardArticle> readPaging(ListBoardArticleCommand command);
    List<BoardArticle> readList(ListBoardArticleCommand command);
}
