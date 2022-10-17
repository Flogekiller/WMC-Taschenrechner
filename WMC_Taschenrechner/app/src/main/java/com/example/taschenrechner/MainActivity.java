package com.example.taschenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick1(View view) {
        Button button = findViewById(R.id.button1);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClick2(View view) {
        Button button = findViewById(R.id.button2);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClick3(View view) {
        Button button = findViewById(R.id.button3);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClick4(View view) {
        Button button = findViewById(R.id.button4);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClick5(View view) {
        Button button = findViewById(R.id.button5);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClick6(View view) {
        Button button = findViewById(R.id.button6);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClick7(View view) {
        Button button = findViewById(R.id.button7);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClick8(View view) {
        Button button = findViewById(R.id.button8);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClick9(View view) {
        Button button = findViewById(R.id.button9);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClick0(View view) {
        Button button = findViewById(R.id.button0);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClickGleich(View view) {
        Button button = findViewById(R.id.Gleich);
        EditText editText = findViewById(R.id.textView2);
        Rechner rechner = new Rechner(editText.getText().toString());
        List<Token> list =  rechner.shuntingYard();
        List<NumberToken> tempNmbrList = new ArrayList<>();
        for(Token t:list)
        {
            if(t instanceof NumberToken)
            {
                tempNmbrList.add((NumberToken) t);
            }
            else if(t instanceof OperatorToken) {
                while (tempNmbrList.size() > 1) {
                    OperatorToken op = new OperatorToken(((OperatorToken) t).getOpType());
                    if ((op.getOpType().equals(OperatorType.PLUS))) {
                        double a = tempNmbrList.get(tempNmbrList.size() - 1).getNumberToken();
                        double b = tempNmbrList.get(tempNmbrList.size() - 2).getNumberToken();
                        double sum = a + b;
                        NumberToken nm = new NumberToken(sum);
                        tempNmbrList.remove(tempNmbrList.size() - 1);
                        tempNmbrList.remove(tempNmbrList.size() - 2);
                        tempNmbrList.add(nm);
                    }
                    if ((op.getOpType().equals(OperatorType.SUB))) {
                        double a = tempNmbrList.get(tempNmbrList.size() - 1).getNumberToken();
                        double b = tempNmbrList.get(tempNmbrList.size() - 2).getNumberToken();
                        double sum = a - b;
                        NumberToken nm = new NumberToken(sum);
                        tempNmbrList.remove(tempNmbrList.size() - 1);
                        tempNmbrList.remove(tempNmbrList.size() - 2);
                        tempNmbrList.add(nm);
                    }
                    if ((op.getOpType().equals(OperatorType.MUL))) {
                        double a = tempNmbrList.get(tempNmbrList.size() - 1).getNumberToken();
                        double b = tempNmbrList.get(tempNmbrList.size() - 2).getNumberToken();
                        double sum = a * b;
                        NumberToken nm = new NumberToken(sum);
                        tempNmbrList.remove(tempNmbrList.size() - 1);
                        tempNmbrList.remove(tempNmbrList.size() - 2);
                        tempNmbrList.add(nm);
                    }
                    if ((op.getOpType().equals(OperatorType.DIV))) {
                        double a = tempNmbrList.get(tempNmbrList.size() - 1).getNumberToken();
                        double b = tempNmbrList.get(tempNmbrList.size() - 2).getNumberToken();
                        double sum = a / b;
                        NumberToken nm = new NumberToken(sum);
                        tempNmbrList.remove(tempNmbrList.size() - 1);
                        tempNmbrList.remove(tempNmbrList.size() - 2);
                        tempNmbrList.add(nm);
                    }
                }
            }
        }
        editText.setText(tempNmbrList.get(1).toString());

    }
    public void onClickMal(View view) {
        Button button = findViewById(R.id.Mal);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClickPlus(View view) {
        Button button = findViewById(R.id.Plus);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClickMinus(View view) {
        Button button = findViewById(R.id.Minus);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClickGeteil(View view) {
        Button button = findViewById(R.id.Geteilt);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClickClear(View view) {
        Button button = findViewById(R.id.Clear);
        EditText editText = findViewById(R.id.textView2);
        editText.setText("");
    }
    public void onClickPunkt(View view) {
        Button button = findViewById(R.id.Punkt);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClickAuf(View view) {
        Button button = findViewById(R.id.KlammerAuf);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }
    public void onClickZu(View view) {
        Button button = findViewById(R.id.KlammerZu);
        EditText editText = findViewById(R.id.textView2);
        editText.setText(editText.getText() +""+ button.getText());
    }



}