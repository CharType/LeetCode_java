package com.myCompile;

import com.compile.interFace.Token;
import com.compile.interFace.TokenReader;
import com.compile.lexicalAnalysis.TokenType;

import java.util.List;

public class SimpleLexer {
    public static void main(String[] args) {

    }

    // 临时保存Token的文本
    private StringBuffer tokenText = null;
    // 保存已经解析出来的token
    private List<Token> tokens = null;
    // 当前正在解析的Token
    private SimpleToken token = null;

    // 是否是字母
    private boolean isAlpha(int ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    // 判断是否是数字
    private boolean isDigit(int ch) {
        return ch >= '0' && ch <= '9';
    }

    // 判断是否是空白字符
    private boolean isBlank(int ch) {
        return ch == ' ' || ch == '\t' || ch == '\n';
    }

    /**
     * 有限状态机进入初始化状态
     * 开始解析的时候进入初始化状态，解析完毕的时候会把Token记录下来，然后重新进入初始化状态
     *
     * @param ch
     * @return
     */
    private DfaState initToken(int ch) {
        if (tokenText.length() > 0) {
            // 如果之前的结果有数据，先将之前的Token保存起来
            token.text = tokenText.toString();
            tokens.add(token);
            // 重新初始化数据
            tokenText = new StringBuffer();
            token = new SimpleToken();
        }

        DfaState newState = DfaState.Initial;
        if (isAlpha(ch)) {
            if (ch == 'i') {
                newState = DfaState.Int;
            } else {
                newState = DfaState.Id;
            }
            token.type = TokenType.Identifier;
            tokenText.append(ch);
        } else if (isDigit(ch)) {
            newState = DfaState.IntLiteral;
            token.type = TokenType.IntLiteral;
            tokenText.append(ch);
        } else if (ch == '>') {
            newState = DfaState.GT;
            token.type = TokenType.GT;
            tokenText.append(ch);
        } else if (ch == '+') {
            newState = DfaState.Plus;
            token.type = TokenType.Plus;
            tokenText.append(ch);
        } else if (ch == '-') {
            newState = DfaState.Minus;
            token.type = TokenType.Minus;
            tokenText.append(ch);
        } else if (ch == '*') {
            newState = DfaState.Star;
            token.type = TokenType.Star;
            tokenText.append(ch);
        } else if (ch == '/') {
            newState = DfaState.Slash;
            token.type = TokenType.Slash;
            tokenText.append(ch);
        } else if (ch == ';') {
            newState = DfaState.SemiColon;
            token.type = TokenType.SemiColon;
            tokenText.append(ch);
        } else if (ch == '(') {
            newState = DfaState.LeftParen;
            token.type = TokenType.LeftParen;
            tokenText.append(ch);
        } else if (ch == ')') {
            newState = DfaState.RightParen;
            token.type = TokenType.RightParen;
            tokenText.append(ch);
        } else if (ch == '=') {
            newState = DfaState.Assignment;
            token.type = TokenType.Assignment;
            tokenText.append(ch);
        } else {
            newState = DfaState.Initial;
        }

        return newState;

    }

    // 一个Token实例，只有类型和文本两个属性
    private final class SimpleToken implements Token {
        // Token类型
        private TokenType type = null;
        // Token对应的文本值
        private String text = null;

        @Override
        public TokenType getType() {
            return type;
        }

        @Override
        public String getText() {
            return text;
        }
    }

    // 有限状态机的各种状态
    private enum DfaState {
        // 最开始的初始状态
        Initial,

        // if关键字识别状态
        If,
        Id_if1,
        Id_if2,

        // else关键字识别
        Else,
        Id_else1,
        Id_else2,
        Id_else3,
        Id_else4,

        // Int关键字解析
        Int,
        Id_int1,
        Id_int2,
        Id_int3,

        Id, // 标识符
        GT, // >
        GE, // >=
        Assignment, // =
        Plus, // +
        Minus, // -
        Star, // *
        Slash, // /
        SemiColon, // ;
        LeftParen, // (
        RightParen, // )
        IntLiteral, // 整形字面量
    }

    // 一个简单的Token流，把Token列表进行了封装
    private class SimpleTokenReader implements TokenReader {
        List<Token> tokens = null;
        int pos = 0;

        public SimpleTokenReader(List<Token> tokens) {
            this.tokens = tokens;
        }

        @Override
        public Token read() {
            if (pos < tokens.size()) {
                return tokens.get(pos++);
            }
            return null;
        }

        @Override
        public Token peek() {
            if (pos < tokens.size()) {
                return tokens.get(pos);
            }
            return null;
        }

        @Override
        public void unread() {
            if (pos > 0) {
                pos--;
            }
        }

        @Override
        public int getPosition() {
            return pos;
        }

        @Override
        public void setPosition(int position) {
            if (pos > 0 && pos < tokens.size()) {
                pos = position;
            }
        }
    }
}
