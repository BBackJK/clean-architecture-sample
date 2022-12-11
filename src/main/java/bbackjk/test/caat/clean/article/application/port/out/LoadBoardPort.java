package bbackjk.test.caat.clean.article.application.port.out;

import bbackjk.test.caat.clean.article.domain.Board;

public interface LoadBoardPort {

    Board loadBoardById(Board.BoardId id);
}
