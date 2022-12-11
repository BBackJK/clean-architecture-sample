package bbackjk.test.caat.clean.article.adapter.out.persistence;

import bbackjk.test.caat.clean.article.adapter.out.persistence.entity.BoardArticleEntity;

import bbackjk.test.caat.clean.article.adapter.out.persistence.entity.BoardCommentEntity;
import bbackjk.test.caat.clean.article.adapter.out.persistence.entity.BoardEntity;
import bbackjk.test.caat.clean.article.domain.Board;
import bbackjk.test.caat.clean.article.domain.BoardArticle;
import bbackjk.test.caat.clean.article.domain.BoardComment;
import bbackjk.test.caat.clean.user.adapter.out.persistence.entity.UserEntity;
import bbackjk.test.caat.clean.user.domain.User;
import bbackjk.test.caat.clean.common.DomainMapHelper;

import java.util.List;
import java.util.stream.Collectors;

@DomainMapHelper
class BoardArticleMapHelper {

    BoardArticle entityToDomain(
            BoardArticleEntity boardArticleEntity
            , BoardEntity boardEntity
            , List<BoardCommentEntity> boardCommentEntityList
            , UserEntity userEntity
            , UserEntity createdBy
            , UserEntity updatedBy
    ) {
        return BoardArticle.of(
                new BoardArticle.BoardArticleId(boardArticleEntity.getId())
                , boardEntityToDomain(boardEntity)
                , userEntityToDomain(userEntity)
                , boardArticleEntity.getTitle()
                , boardArticleEntity.getContents()
                , boardArticleEntity.getViewCount()
                , boardArticleEntity.getCreatedAt()
                , userEntityToDomain(createdBy)
                , boardArticleEntity.getUpdatedAt()
                , userEntityToDomain(updatedBy)
                , boardCommentToDomain(boardCommentEntityList)
        );
    }

    BoardArticleEntity domainToEntity(BoardArticle boardArticle) {
        return new BoardArticleEntity(
            boardArticle.getId().getValue()
                , boardArticle.getBoard().getId().getValue()
                , boardArticle.getUser().getId().getValue()
                , boardArticle.getTitle()
                , boardArticle.getContents()
                , boardArticle.getViewCount()
                , boardArticle.getCreatedAt()
                , boardArticle.getCreatedBy().getId().getValue()
                , boardArticle.getUpdatedAt()
                , boardArticle.getUpdatedBy().getId().getValue()
        );
    }

    BoardArticleEntity domainToNewEntity(BoardArticle boardArticle) {
        return new BoardArticleEntity(
                0
                , boardArticle.getBoard().getId().getValue()
                , boardArticle.getUser().getId().getValue()
                , boardArticle.getTitle()
                , boardArticle.getContents()
                , boardArticle.getViewCount()
                , boardArticle.getCreatedAt()
                , boardArticle.getCreatedBy().getId().getValue()
                , boardArticle.getUpdatedAt()
                , boardArticle.getUpdatedBy().getId().getValue()
        );
    }


    Board boardEntityToDomain(BoardEntity entity) {
        return Board.of(
                new Board.BoardId(entity.getId())
                , entity.getName()
        );
    }

    private List<BoardComment> boardCommentToDomain(List<BoardCommentEntity> entityList) {
        return entityList.stream().map(x ->
            BoardComment.of(
                new BoardComment.BoardCommentId(x.getId())
                , new BoardArticle.BoardArticleId(x.getBoardArticleId())
                , new User.UserId(x.getUserId())
                , x.getContents()
        )).collect(Collectors.toList());
    }

    private User userEntityToDomain(UserEntity entity) {
        return User.of(
                new User.UserId(entity.getId())
                , entity.getName()
        );
    }
}
