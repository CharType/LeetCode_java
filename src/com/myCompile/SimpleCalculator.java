package com.myCompile;

import com.compile.grammaticalAnalysis.ASTNodeType;
import com.compile.interFace.ASTNode;
import com.compile.interFace.Token;
import com.compile.interFace.TokenReader;
import com.compile.lexicalAnalysis.TokenType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 一个简单的计算器，算是一个简单的语义分析工具，但是计算顺序是有问题的
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        String script = "int a = b + 3;";
        System.out.println("解析变量声明语句：" + script);
        SimpleLexer lexer = new SimpleLexer();
        TokenReader tokens = lexer.tokenize(script);
        try {
            SimpleASTNode node = calculator.intDeclare(tokens);
            calculator.dumpAST(node, "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //测试表达式
        script = "2+3*5";
        System.out.println("\n计算: " + script + "，看上去一切正常。");
        calculator.evaluate(script);

        //测试语法错误
        script = "2+";
        System.out.println("\n: " + script + "，应该有语法错误。");
        calculator.evaluate(script);

        script = "2+3+4";
        System.out.println("\n计算: " + script + "，结合性出现错误。");
        calculator.evaluate(script);
    }


    // 打印输出AST的求值过程
    public void evaluate(String code) {
        try {
            ASTNode tree = parse(code);
            dumpAST(tree, "");
            evaluate(tree, "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ASTNode parse(String code) throws Exception {
        SimpleLexer lexer = new SimpleLexer();
        TokenReader tokens = lexer.tokenize(code);
        ASTNode node = prog(tokens);
        return node;
    }

    private int evaluate(ASTNode node, String indent) {
        int result = 0;
        System.out.println(indent + "Calculating" + node.getType());
        switch (node.getType()) {
            case Programm: {
                for (ASTNode child : node.getChildren()) {
                    result = evaluate(child, indent + "\t");
                }
            }
            break;
            case Additive: {
                ASTNode child1 = node.getChildren().get(0);
                int value1 = evaluate(child1, indent + "\t");
                ASTNode child2 = node.getChildren().get(1);
                int value2 = evaluate(child1, indent + "\t");
                if (node.getText().equals("+")) {
                    result = value1 + value2;
                } else {
                    result = value1 - value2;
                }
            }
            break;
            case Multiplicative: {
                ASTNode child1 = node.getChildren().get(0);
                int value1 = evaluate(child1, indent + "\t");
                ASTNode child2 = node.getChildren().get(1);
                int value2 = evaluate(child1, indent + "\t");
                if (node.getText().equals("*")) {
                    result = value1 * value2;
                } else {
                    result = value1 / value2;
                }
            }
            break;
            case IntLiteral: {
                result = Integer.valueOf(node.getText()).intValue();
            }
            break;
            default:
        }
        System.out.println(indent + "Result:" + result);
        return result;
    }


    private SimpleASTNode intDeclare(TokenReader tokens) throws Exception {
        SimpleASTNode node = null;
        Token token = tokens.peek();
        // 如果下一个Token是Int类型
        if (token != null && token.getType() == TokenType.Int) {
            // 消耗掉Int类型
            token = tokens.read();
            if (tokens.peek().getType() == TokenType.Identifier) {
                // 如果下一个类型是标识符类型
                token = tokens.read();
                node = new SimpleASTNode(ASTNodeType.IntDeclaration, token.getText());
                // 预读
                token = tokens.peek();
                if (token.getType() != null && token.getType() == TokenType.Assignment) {
                    // 如果是赋值token
                    // 使用等号标识符
                    token = tokens.read();
                    SimpleASTNode child = additive(tokens);
                    if (child == null) {
                        throw new Exception("invalide variable initialization, expecting an expression");
                    } else {
                        node.addChild(child);
                    }
                }
            } else {
                throw new Exception("variable name expected");
            }

            if (node != null) {
                // 判断是否是分号结尾
                token = tokens.peek();
                if (token != null && token.getType() == TokenType.SemiColon) {
                    tokens.read();
                } else {
                    throw new Exception("invalid statement, expecting semicolon");
                }
            }
        }
        return node;
    }

    /**
     * 根节点
     *
     * @param tokens
     * @return
     * @throws Exception
     */
    private SimpleASTNode prog(TokenReader tokens) throws Exception {
        SimpleASTNode node = new SimpleASTNode(ASTNodeType.Primary, "Calculator");
        SimpleASTNode child = additive(tokens);
        if (child != null) {
            node.addChild(child);
        }
        return node;
    }

    /**
     * 语法解析，解析加法表达式
     *
     * @param tokens
     * @return
     */
    private SimpleASTNode additive(TokenReader tokens) throws Exception {
        SimpleASTNode child1 = primary(tokens);
        SimpleASTNode node = child1;
        Token token = tokens.peek();
        if (child1 != null && token != null) {
            if (token.getType() == TokenType.Plus || token.getType() == TokenType.Minus) {
                token = tokens.read();
                SimpleASTNode child2 = multiplicative(tokens);
                if (child2 != null) {
                    node = new SimpleASTNode(ASTNodeType.Additive, token.getText());
                    node.addChild(child1);
                    node.addChild(child2);
                } else {
                    throw new Exception("invalid additive expression, expecting the right part.");
                }
            }
        }
        return node;
    }

    /**
     * 语法解析，解析乘法表达式
     *
     * @param tokens
     * @return
     */
    private SimpleASTNode multiplicative(TokenReader tokens) throws Exception {
        SimpleASTNode child1 = primary(tokens);
        SimpleASTNode node = child1;
        Token token = tokens.peek();
        if (child1 != null && token != null) {
            if (token.getType() == TokenType.Star || token.getType() == TokenType.Slash) {
                token = tokens.read();
                SimpleASTNode child2 = multiplicative(tokens);
                if (child2 != null) {
                    node = new SimpleASTNode(ASTNodeType.Multiplicative, token.getText());
                    node.addChild(child1);
                    node.addChild(child2);
                } else {
                    throw new Exception("invalid multiplicative expression, expecting the right part.");
                }
            }
        }
        return node;
    }

    /**
     * 语法解析，解析基础表达式
     *
     * @param tokens
     * @return
     */
    private SimpleASTNode primary(TokenReader tokens) throws Exception {
        SimpleASTNode node = null;
        Token token = tokens.peek();
        if (token != null) {
            if (token.getType() == TokenType.IntLiteral) {
                token = tokens.read();
                node = new SimpleASTNode(ASTNodeType.IntLiteral, token.getText());
            } else if (token.getType() == TokenType.Identifier) {
                token = tokens.read();
                node = new SimpleASTNode(ASTNodeType.Identifier, token.getText());
            } else if (token.getType() == TokenType.LeftParen) {
                tokens.read();
                node = additive(tokens);
                if (node != null) {
                    token = tokens.peek();
                    if (token != null && token.getType() == TokenType.RightParen) {
                        tokens.read();
                    } else {
                        throw new Exception("expecting right parenthesis");
                    }
                } else {
                    throw new Exception("expecting an additive expression inside parenthesis");
                }
            }
        }
        return node;
    }

    /**
     * 一个简单的ASTNode节点的实现
     */
    public class SimpleASTNode implements ASTNode {
        // 父节点
        SimpleASTNode parent = null;
        // 所有的子节点
        List<ASTNode> children = new ArrayList<>();
        List<ASTNode> readonlyChildren = Collections.unmodifiableList(children);
        // 类型
        ASTNodeType nodeType = null;
        // 文本值
        String text = null;

        public SimpleASTNode(ASTNodeType nodeType, String text) {
            this.nodeType = nodeType;
            this.text = text;
        }

        @Override
        public ASTNode getParent() {
            return parent;
        }

        @Override
        public List<ASTNode> getChildren() {
            return readonlyChildren;
        }

        @Override
        public ASTNodeType getType() {
            return nodeType;
        }

        @Override
        public String getText() {
            return text;
        }

        public void addChild(SimpleASTNode child) {
            children.add(child);
            child.parent = this;
        }
    }

    /**
     * 打印ASTNode的树状结构
     *
     * @param node
     * @param indent
     */
    private void dumpAST(ASTNode node, String indent) {
        System.out.println(indent + node.getType() + " " + node.getText());
        for (ASTNode child : node.getChildren()) {
            dumpAST(child, indent + "\t");
        }
    }
}
