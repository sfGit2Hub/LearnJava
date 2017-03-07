package study.RTTI.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SF on 2017/3/6.
 */
public class AnnotationParent<T> {
    private Class<T> entity;
    
    public AnnotationParent() {
        this.init();
    }

    private List<AnnotationReflect> init() {
        List<AnnotationReflect> annotationReflectList = new ArrayList<>();
        /**
         * getClass().getGenericSuperclass()返回表示此 Class 所表示的实体（类、接口、基本类型或 void）
         * 的直接超类的 Type(Class<T>泛型中的类型)，然后将其转换ParameterizedType
         *  getActualTypeArguments()返回表示此类型实际类型参数的 Type 对象的数组。
         *  [0]就是这个数组中第一个了
         *  简而言之就是获得超类的泛型参数的实际类型
         *  */
        this.entity = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (this.entity != null) {
            Field[] fields = this.entity.getFields();
            for (Field f : fields) {
                Value value = f.getAnnotation(Value.class);
                if (value != null) {
                    AnnotationReflect reflect = new AnnotationReflect(value, f);
                    annotationReflectList.add(reflect);
                }
            }

            Method[] methods = this.entity.getMethods();
            for (Method m : methods) {
                Value value = m.getAnnotation(Value.class);
                if (value != null) {
                    AnnotationReflect reflect = new AnnotationReflect(value, m.getName(), m.getReturnType());
                    annotationReflectList.add(reflect);
                }
            }
        }
        return annotationReflectList;
    }
}
