package com.sec17.obj;

import java.io.Serializable;

public class SendData implements Serializable {
    private static final long serialVersionUID = 1L;


    private double num1;
    private double num2;
    private double result;
    private String op;

    public SendData(double num1, double num2, String op) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
}
