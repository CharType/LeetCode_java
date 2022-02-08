package com.myCompile;

public enum TokenType {
    Plus, // +
    Minus,// -
    Star, // *
    Slash, // /

    GE, // >=
    GT, // >
    EQ, // ==
    LE, // <=
    LT, // <

    SemiColon, // ;
    LeftParen, // (
    RightParen, // )
    Assignment, // =

    If,
    Else,
    Int,
    Identifier, // 标识符，变量名称
    IntLiteral, // 整形字面量
    StringLiteral,// 字符串字面量
}
