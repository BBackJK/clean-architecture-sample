package bbackjk.test.caat.common.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtilz {

    public String FORMAT_DEFAULT = "yyyy.MM.dd HH:mm";

    public String toString(LocalDateTime value) {
        return toString(value, FORMAT_DEFAULT);
    }

    public String toString(LocalDateTime value, String format) {
        if (value == null) {
            return StringUtilz.EMPTY;
        }

        try {
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return value.format(formatter);
        } catch (IllegalArgumentException e) {
            return StringUtilz.EMPTY;
        }
    }
}
