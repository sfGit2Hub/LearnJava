package study.RTTI.reflect;

import java.lang.reflect.Field;

/**
 * Created by SF on 2017/3/6.
 */
public class AnnotationReflect {
    private String name;
    private Field field;
    private Value value;
    private Class<?> type;

    public AnnotationReflect(Value value, String name, Class<?> type) {
        this.value = value;
        this.name = name;
        this.type = type;
    }

    public AnnotationReflect(Value value, Field field) {
        this.value = value;
        this.field = field;
        this.name = field.getName();
        this.type = field.getType();
    }

    public AnnotationReflect(){}

    public String getName() {
        return name;
    }

    public AnnotationReflect setName(String name) {
        this.name = name;
        return this;
    }

    public Field getField() {
        return field;
    }

    public AnnotationReflect setField(Field field) {
        this.field = field;
        return this;
    }

    public Value getValue() {
        return value;
    }

    public AnnotationReflect setValue(Value value) {
        this.value = value;
        return this;
    }

    public Class<?> getType() {
        return type;
    }

    public AnnotationReflect setType(Class<?> type) {
        this.type = type;
        return this;
    }
}
