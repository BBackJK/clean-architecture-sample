package bbackjk.test.caat.clean.article.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * Value 어노테이션은
 * 1. Getter
 * 2. FieldDefaults --> final and private 처리
 * 3. AllArgsConstructor
 * 4. ToString
 * 5. EqualsAndHashCode
 * 를 합쳐놓아서 최대한 불변성을 지키려고 사용
 *
 * RequiredArgsConstructor 어노테이션으로 필드들을 생성자를 통해서 값을 주입받음.
 */
@Value
@RequiredArgsConstructor
public class Board {

    // @Value 어노테이션에 의해 private final 자동 적용
    BoardId id;
    String name;

    @Value
    public static class BoardId {
        String value;
    }

    public static Board of(BoardId id, String name) {
        return new Board(
                id
                , name
        );
    }
}
