package bbackjk.test.caat.clean.user.domain;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class User {

    UserId id;
    String name;

    @Value
    @EqualsAndHashCode(of = {"value"})
    public static class UserId {
        long value;
    }

    public static User of(UserId id, String name) {
        return new User(
                id
                , name
        );
    }
}
