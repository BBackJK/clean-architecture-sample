package bbackjk.test.caat.clean.user.adapter.out.persistence.dao;

import bbackjk.test.caat.clean.user.adapter.out.persistence.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserDao {

    Optional<UserEntity> findById(long id);
}
