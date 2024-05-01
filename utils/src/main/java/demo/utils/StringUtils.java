package demo.utils;

import java.util.Objects;

public class StringUtils {

    public static String toString(Object o){
        return Objects.isNull(o) ? "" : o.toString();
    }

}
