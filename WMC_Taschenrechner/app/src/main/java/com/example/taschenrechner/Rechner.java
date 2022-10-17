package com.example.taschenrechner;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Rechner
{
    String eingabe;
    List<Token> tokenList = new ArrayList<>();
    List<Token> inOrder = new ArrayList<>();
    List<Token> stacks = new ArrayList<>();
    public Rechner(String eingabe) {
        this.eingabe = eingabe;
    }

    public List<Token> shuntingYard()
    {
        Infixnotation infixnotation = new Infixnotation();
        tokenList.addAll(infixnotation.InfixnationAsList(eingabe));
        while (!tokenList.isEmpty())
        {
            for (int i = 0; i < tokenList.size(); i++) {
                if(tokenList.get(i) instanceof NumberToken)
                {
                    inOrder.add(tokenList.get(i));
                }
                else if(tokenList.get(i) instanceof OperatorToken)
                {
                    if (!inOrder.isEmpty() && stacks.get(stacks.size()-1).getClass().getSimpleName().equals("OperatorType") && lingsassoziativ(OperatorType.valueOf(tokenList.get(i).toString())) && prezidänz(stacks.get(stacks.size()-1)) >= prezidänz(tokenList.get(i)))
                    {
                        inOrder.add(stacks.get(stacks.size()-1));
                    }
                   stacks.add(tokenList.get(i));
                }
                else if(tokenList instanceof BracketToken)
                {
                    BracketToken br = (BracketToken)tokenList.get(i);
                    if(br.getBracketToken())
                    {
                        stacks.add(tokenList.get(i));
                    }
                    else if(!br.getBracketToken())
                    {
                        while(!stacks.get(i).equals(true))
                        {
                            if(stacks.isEmpty())
                            {
                                return null;
                            }
                          inOrder.add(stacks.get(stacks.size()-1));
                        }
                        stacks.remove(stacks.size()-1);
                    }
                }

            }
            while (!stacks.isEmpty())
            {
                BracketToken br = (BracketToken)stacks.get(stacks.size()-1);
                if(br.getBracketToken())
                {
                    return null;
                }
                inOrder.add(stacks.get(stacks.size()-1));
            }
        }
        return inOrder;
    }
    private Boolean lingsassoziativ(OperatorType operatorType)
    {
        if(operatorType.equals(OperatorType.DIV) || operatorType.equals(OperatorType.SUB))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private int prezidänz(Token token)
    {

      if(token instanceof NumberToken)
      {
          return 0;
      }
      else if(token instanceof BracketToken)
      {
          return 3;
      }
      OperatorToken operatorToken = (OperatorToken) token;
       if(operatorToken.getOpType() == OperatorType.PLUS || operatorToken.getOpType() == OperatorType.SUB)
      {
          return 1;
      }
       else if (operatorToken.getOpType() == OperatorType.DIV || operatorToken.getOpType() == OperatorType.MUL)
       {
           return 2;
       }
       return 0;
    }
}
