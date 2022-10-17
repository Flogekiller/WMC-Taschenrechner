package com.example.taschenrechner;

public class BracketToken implements Token
{
    private boolean bracketToken;

    public BracketToken(boolean bracketToken) {
        this.bracketToken = bracketToken;
    }

    public boolean getBracketToken() {
        return bracketToken;
    }
}
