package bbackjk.test.caat.legacy.biz.dao;

import bbackjk.test.caat.legacy.biz.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface LegacyBoardDao {

    @Select(" select b.* from board b where b.id = #{id} ")
    Optional<BoardDto> findById(String id);
}
