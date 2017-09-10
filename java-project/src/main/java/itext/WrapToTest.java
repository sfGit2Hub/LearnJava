package itext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by SF on 2017/8/3.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface WrapToTest {
    /**
     * Should be true is referent PDf file and resultant PDF file should be compared be renders.
     * @return
     */
    public boolean compareRenders() default false;

}
