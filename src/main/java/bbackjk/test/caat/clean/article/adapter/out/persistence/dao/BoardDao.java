package bbackjk.test.caat.clean.article.adapter.out.persistence.dao;

import bbackjk.test.caat.clean.article.adapter.out.persistence.entity.BoardEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface BoardDao {

    @Select(" select b.* from board b where b.id = #{id} ")
    Optional<BoardEntity> findById(String id);
}
