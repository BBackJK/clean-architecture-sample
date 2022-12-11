package bbackjk.test.caat.clean.user.adapter.out.persistence;

import bbackjk.test.caat.clean.user.adapter.out.persistence.dao.UserDao;
import bbackjk.test.caat.clean.user.domain.User;
import bbackjk.test.caat.clean.common.PersistenceAdapter;
import bbackjk.test.caat.clean.user.application.out.LoadUserPort;
import bbackjk.test.caat.common.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements LoadUserPort {

    private final UserDao userDao;
    private final UserMapHelper userMapHelper;

    @Override
    public User loadUserById(User.UserId id) {
        return userMapHelper.entityToDomain(
                userDao.findById(id.getValue()).orElseThrow(EntityNotFoundException::new)
        );
    }
}
