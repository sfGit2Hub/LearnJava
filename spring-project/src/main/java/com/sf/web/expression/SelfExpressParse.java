package com.sf.web.expression;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SelfExpressParse {

    public static void main(String[] args) {
        String condition = "context.channelCode.contains('google')";
        String urlFormat = "#{context.channelCode} + #{context.hotelPassport}";
        DeepLink deepLink = new DeepLink();
        deepLink.setChannelCode("google-hilton");
        deepLink.setHotelPassport("HILTON-5432");
        ExpressionObject expressionObject = new ExpressionObject(condition, urlFormat, deepLink);

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(expressionObject.getCondition());
        System.out.println(exp.getValue(expressionObject, Boolean.class));

        EvaluationContext evaluationContext = new StandardEvaluationContext(expressionObject);
        Expression urlExp = new SpelExpressionParser().parseExpression(urlFormat, new TemplateParserContext());
        System.out.println(urlExp.getValue(evaluationContext, String.class));

    }

}
