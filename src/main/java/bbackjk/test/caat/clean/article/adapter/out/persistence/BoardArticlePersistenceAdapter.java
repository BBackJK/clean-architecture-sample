package bbackjk.test.caat.clean.article.adapter.out.persistence;

import bbackjk.test.caat.clean.article.adapter.out.persistence.dao.BoardArticleDao;
import bbackjk.test.caat.clean.article.adapter.out.persistence.dao.BoardCommentDao;
import bbackjk.test.caat.clean.article.adapter.out.persistence.dao.BoardDao;
import bbackjk.test.caat.clean.article.application.port.in.ListBoardArticleCommand;
import bbackjk.test.caat.clean.article.application.port.out.LoadBoardArticlePort;
import bbackjk.test.caat.clean.article.application.port.out.LoadBoardPort;
import bbackjk.test.caat.clean.article.application.port.out.ModifyBoardArticlePort;
import bbackjk.test.caat.clean.article.application.port.out.RegisterBoardArticlePort;
import bbackjk.test.caat.clean.article.domain.Board;
import bbackjk.test.caat.clean.article.domain.BoardArticle;
import bbackjk.test.caat.clean.common.annotation.PersistenceAdapter;
import bbackjk.test.caat.clean.user.adapter.out.persistence.dao.UserDao;
import bbackjk.test.caat.common.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class BoardArticlePersistenceAdapter implements LoadBoardArticlePort
        , LoadBoardPort
        , RegisterBoardArticlePort
        , ModifyBoardArticlePort {

    private final BoardArticleDao boardArticleDao;
    private final BoardDao boardDao;
    private final BoardCommentDao boardCommentDao;
    private final BoardArticleMapHelper boardArticleMapHelper;
    private final UserDao userDao;

    @Override
    public BoardArticle loadById(BoardArticle.BoardArticleId id) {

        // TODO: 귀찮아서 이렇게 했는데..
        // Mybatis에서는 조인으로 맵핑해서 처리할 수 있을거같고
        // Jpa에서는 queryDsl 혹은 jooq를 통해서 처리할 수 있음.
        final var boardArticle = boardArticleDao.findById(id.getValue()).orElseThrow(EntityNotFoundException::new);
        final var board = boardDao.findById(boardArticle.getBoardId()).orElseThrow(EntityNotFoundException::new);
        final var writer = userDao.findById(boardArticle.getUserId()).orElseThrow(EntityNotFoundException::new);

        return boardArticleMapHelper.entityToDomain(
                boardArticle
                , board
                , Collections.emptyList()
                , writer
                , writer.getId()
                , writer.getId()
        );
    }

    @Override
    public BoardArticle loadByIdWithComments(BoardArticle.BoardArticleId id) {

        final var boardArticle = boardArticleDao.findById(id.getValue()).orElseThrow(EntityNotFoundException::new);
        final var board = boardDao.findById(boardArticle.getBoardId()).orElseThrow(EntityNotFoundException::new);
        final var writer = userDao.findById(boardArticle.getUserId()).orElseThrow(EntityNotFoundException::new);
        final var boardCommentList = boardCommentDao.findAllByBoardArticleId(boardArticle.getId());

        return boardArticleMapHelper.entityToDomain(
                boardArticle
                , board
                , boardCommentList
                , writer
                , writer.getId()
                , writer.getId()
        );
    }

    @Override
    public List<BoardArticle> loadPaging(ListBoardArticleCommand command) {
        // TODO: 페이징 처리 하려는데 귀찮아서 안함... ==> 이 때는 페이징에 대한 리스폰스 객체로 맵핑이 필요함.
        // TODO: 즉, list와 총 개수를 같이 가져와야함.
        return Collections.emptyList();
    }

    @Override
    public List<BoardArticle> loadList(ListBoardArticleCommand command) {
        // TODO: 페이징 처리 하려는데 귀찮아서 안함...
        return Collections.emptyList();
    }

    @Override
    public void modify(BoardArticle article) {
        boardArticleDao.update(
                boardArticleMapHelper.domainToEntity(article)
        );
    }

    @Override
    public void register(BoardArticle article) {
        boardArticleDao.insert(
                boardArticleMapHelper.domainToNewEntity(article)
        );
    }

    @Override
    public Board loadBoardById(Board.BoardId id) {
        return boardArticleMapHelper.boardEntityToDomain(
            boardDao.findById(id.getValue()).orElseThrow(EntityNotFoundException::new)
        );
    }
}
