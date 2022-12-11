package bbackjk.test.caat.clean.article.application.port.out;

import bbackjk.test.caat.clean.article.application.port.in.ListBoardArticleCommand;
import bbackjk.test.caat.clean.article.domain.BoardArticle;

import java.util.List;

public interface LoadBoardArticlePort {

    BoardArticle loadById(BoardArticle.BoardArticleId id);

    BoardArticle loadByIdWithComments(BoardArticle.BoardArticleId id);

    List<BoardArticle> loadPaging(ListBoardArticleCommand command);
    List<BoardArticle> loadList(ListBoardArticleCommand command);
}
