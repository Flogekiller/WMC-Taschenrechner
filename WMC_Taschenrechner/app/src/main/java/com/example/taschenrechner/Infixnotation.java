package com.example.taschenrechner;

import java.util.ArrayList;
import java.util.List;

public class Infixnotation
{


    public List<Token> InfixnationAsList(String s)
    {
        List<Token> infix = new ArrayList<>();
        Token currentToken;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '+')
            {
                currentToken = new OperatorToken(OperatorType.PLUS);
            }
            else if(s.charAt(i) == '-')
            {
                currentToken = new OperatorToken(OperatorType.SUB);
            }
            else if (s.charAt(i) == '*'){
                currentToken = new OperatorToken(OperatorType.MUL);
            }
            else if(s.charAt(i) == '/')
            {
                currentToken = new OperatorToken(OperatorType.DIV);
            }
            else if(s.charAt(i) == '(')
            {
                currentToken = new BracketToken(true);
            }
            else if(s.charAt(i) == ')')
            {
                currentToken = new BracketToken(false);
            }
            else
            {
                String a = String.valueOf(s.charAt(i));
                currentToken = new NumberToken(Double.parseDouble(a));
            }
            infix.add(currentToken);

        }
        return infix;
    }
}
