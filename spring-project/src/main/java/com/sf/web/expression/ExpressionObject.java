package com.sf.web.expression;

public class ExpressionObject {
    private String condition;
    private String urlFormat;
    private Object context;

    public ExpressionObject() {
    }

    public ExpressionObject(String condition, String urlFormat, Object context) {
        this.condition = condition;
        this.urlFormat = urlFormat;
        this.context = context;
    }

    public Object getContext() {
        return context;
    }

    public ExpressionObject setContext(Object context) {
        this.context = context;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public ExpressionObject setCondition(String condition) {
        this.condition = condition;
        return this;
    }

    public String getUrlFormat() {
        return urlFormat;
    }

    public ExpressionObject setUrlFormat(String urlFormat) {
        this.urlFormat = urlFormat;
        return this;
    }

}
