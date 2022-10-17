package com.example.taschenrechner;

public class OperatorToken implements Token
{
    private OperatorType opType;

    public OperatorToken(OperatorType opType) {
        this.opType = opType;

    }

    public OperatorType getOpType() {
        return opType;
    }
}
