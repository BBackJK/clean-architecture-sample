package bbackjk.test.caat.clean.article.application.port.in;

import bbackjk.test.caat.clean.article.domain.BoardArticle;

public interface BoardArticleDetailQuery {

    BoardArticle getById(BoardArticle.BoardArticleId id);
    BoardArticle readById(BoardArticle.BoardArticleId id);
}
