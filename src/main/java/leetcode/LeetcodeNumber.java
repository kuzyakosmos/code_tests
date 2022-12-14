package leetcode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.SOURCE)
@Target(value = ElementType.TYPE)
public @interface LeetcodeNumber {
    int number();
    Level level() default Level.UNASSIGNED;
}
enum Level {
    EASY,
    MEDIUM,
    HARD,
    UNASSIGNED
}