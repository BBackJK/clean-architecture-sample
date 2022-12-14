package bbackjk.test.caat.clean.user.adapter.out.persistence;

import bbackjk.test.caat.clean.common.annotation.DomainMapHelper;
import bbackjk.test.caat.clean.user.adapter.out.persistence.entity.UserEntity;
import bbackjk.test.caat.clean.user.domain.User;


@DomainMapHelper
class UserMapHelper {

    User entityToDomain(UserEntity userEntity) {
        return User.of(
                new User.UserId(userEntity.getId())
                , userEntity.getName()
        );
    }
}
