package bbackjk.test.caat.legacy.biz.dao;

import bbackjk.test.caat.legacy.biz.dto.BoardCommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LegacyBoardCommentDao {

    int insert(BoardCommentDto parameter);

    int update(BoardCommentDto parameter);
    int deleteById(long id);

    List<BoardCommentDto> findAllByBoardArticleId(long boardArticleId);
    Optional<BoardCommentDto> findById(long id);
}
