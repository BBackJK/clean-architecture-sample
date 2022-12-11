package bbackjk.test.caat.common.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtilz {

    public static final String EMPTY = "";

    public boolean isEmpty(String s) {
        return s == null || s.length() < 1;
    }

    public boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
    public String logLineBar() {
        return "##############################";
    }
}
