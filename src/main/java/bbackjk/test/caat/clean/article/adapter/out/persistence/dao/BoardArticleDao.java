package bbackjk.test.caat.clean.article.adapter.out.persistence.dao;

import bbackjk.test.caat.clean.article.adapter.out.persistence.entity.BoardArticleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface BoardArticleDao {

    Optional<BoardArticleEntity> findById(long id);

    int insert(BoardArticleEntity entity);
    int update(BoardArticleEntity entity);


    int increaseViewCount(BoardArticleEntity entity);
}
