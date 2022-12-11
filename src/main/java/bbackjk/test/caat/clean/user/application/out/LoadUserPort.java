package bbackjk.test.caat.clean.user.application.out;

import bbackjk.test.caat.clean.user.domain.User;

public interface LoadUserPort {

    User loadUserById(User.UserId id);
}
