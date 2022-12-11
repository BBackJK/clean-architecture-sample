package bbackjk.test.caat.legacy.biz.dao;

import bbackjk.test.caat.legacy.biz.dto.BoardArticleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface LegacyBoardArticleDao {

    Optional<BoardArticleDto> findById(long id);

    int insert(BoardArticleDto parameter);

    int update(BoardArticleDto parameter);

    int increaseViewCount(long id);
}
