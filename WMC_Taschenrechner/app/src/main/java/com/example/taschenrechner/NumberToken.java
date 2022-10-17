package com.example.taschenrechner;

public class NumberToken implements Token
{
    private double numberToken;

    public NumberToken(double numberToken) {
        this.numberToken = numberToken;
    }

    public double getNumberToken() {
        return numberToken;
    }
}
