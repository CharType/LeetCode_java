package com.compile.lexicalAnalysis;

/**
 * 一个简单的Token。
 * 只有类型和文本值两个属性。
 */
public interface Token {

    /**
     * Token的类型
     *
     * @return
     */
    public com.compile.lexicalAnalysis.TokenType getType();

    /**
     * Token的文本值
     *
     * @return
     */
    public String getText();

}