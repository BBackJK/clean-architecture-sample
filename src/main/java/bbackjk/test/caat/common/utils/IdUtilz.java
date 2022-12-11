package bbackjk.test.caat.common.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class IdUtilz {

    public Long orZero(Long value) {
        return value == null ? 0L : value;
    }
}
