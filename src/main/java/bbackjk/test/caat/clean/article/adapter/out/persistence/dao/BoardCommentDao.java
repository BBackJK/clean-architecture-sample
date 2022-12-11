package bbackjk.test.caat.clean.article.adapter.out.persistence.dao;

import bbackjk.test.caat.clean.article.adapter.out.persistence.entity.BoardCommentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardCommentDao {

    List<BoardCommentEntity> findAllByBoardArticleId(long boardArticleId);
}
