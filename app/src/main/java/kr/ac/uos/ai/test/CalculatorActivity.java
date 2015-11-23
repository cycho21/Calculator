package kr.ac.uos.ai.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class CalculatorActivity extends Activity implements View.OnClickListener {


    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b_plus;
    private Button b_multi;
    private Button b_divide;
    private TextView tv;
    private Button b_equal;
    private ImageButton b_claer;
    private Button b_back;
    private Button b_minus;
    private TextView result;
    private ArrayList<String> operatorList;
    private boolean isPreOperator;
    private Animation ani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_main);
        init();


    }

    private void init() {

        b1 = (Button) findViewById( R.id.button_1 );
        b1.setOnClickListener(this);
        b2 = (Button) findViewById( R.id.button_2 );
        b2.setOnClickListener(this);
        b3 = (Button) findViewById( R.id.button_3 );
        b3.setOnClickListener(this);
        b4 = (Button) findViewById( R.id.button_4 );
        b4.setOnClickListener(this);
        b5 = (Button) findViewById( R.id.button_5 );
        b5.setOnClickListener(this);
        b6 = (Button) findViewById( R.id.button_6 );
        b6.setOnClickListener(this);
        b7 = (Button) findViewById( R.id.button_7 );
        b7.setOnClickListener(this);
        b8 = (Button) findViewById( R.id.button_8 );
        b8.setOnClickListener(this);
        b9 = (Button) findViewById( R.id.button_9 );
        b9.setOnClickListener(this);
        b_claer = (ImageButton) findViewById( R.id.button_clear );
        b_claer.setOnClickListener(this);
        b_back = (Button) findViewById( R.id.button_back );
        b_back.setOnClickListener(this);
        b_divide = (Button) findViewById( R.id.button_divide );
        b_divide.setOnClickListener(this);
        b_plus = (Button) findViewById( R.id.button_plus );
        b_plus.setOnClickListener(this);
        b_minus = (Button) findViewById( R.id.button_minus );
        b_minus.setOnClickListener(this);
        b_multi = (Button) findViewById( R.id.button_multi );
        b_multi.setOnClickListener(this);
        b_equal = (Button) findViewById( R.id.button_equal );
        b_equal.setOnClickListener(this);
        result = (TextView) findViewById( R.id.text_result );

        operatorList = new ArrayList<String>();
        isPreOperator = false;
    }

    @Override
    public void onClick(final View v) {
        ani = AnimationUtils.loadAnimation(CalculatorActivity.this, R.anim.animation_buttonclick);
        v.startAnimation(ani);

        ani.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                buttonAnalysis(v);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void buttonAnalysis(View v) {
        if (v.equals(b1)) {
            isPreOperator = false;
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("1");
            } else {
                result.setText(result.getText() + "1");
            }
        } else if (v.equals(b2)) {
            isPreOperator = false;
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("2");
            } else {
                result.setText(result.getText() + "2");
            }
        } else if (v.equals(b3)) {
            isPreOperator = false;
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("3");
            } else {
                result.setText(result.getText() + "3");
            }
        } else if (v.equals(b4)) {
            isPreOperator = false;
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("4");
            } else {
                result.setText(result.getText() + "4");
            }
        } else if (v.equals(b5)) {
            isPreOperator = false;
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("5");
            } else {
                result.setText(result.getText() + "5");
            }
        } else if (v.equals(b6)) {
            isPreOperator = false;
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("6");
            } else {
                result.setText(result.getText() + "6");
            }
        } else if (v.equals(b7)) {
            isPreOperator = false;
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("7");
            } else {
                result.setText(result.getText() + "7");
            }
        } else if (v.equals(b8)) {
            isPreOperator = false;
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("8");
            } else {
                result.setText(result.getText() + "8");
            }
        } else if (v.equals(b9)) {
            isPreOperator = false;
            if (result.getText().length() == 1 && "0".equals(result.getText())) {
                result.setText("9");
            } else {
                result.setText(result.getText() + "9");
            }
        } else if (v.equals(b_claer)) {
            isPreOperator = false;
            result.setText("0");
            operatorList.clear();
        } else if (v.equals(b_back)) {
            if (result.getText().length() != 0) {
                String str = result.getText().subSequence(result.getText().length() - 1, result.getText().length()).toString();
                if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
                    operatorList.remove(operatorList.size());
                }
                result.setText(result.getText().subSequence(0, result.getText().length() - 1));
            }

        } else if (v.equals(b_divide)) {
            if (isPreOperator == true) {
                return;
            }
            result.setText(result.getText() + "/");
            isPreOperator = true;
            operatorList.add("/");
        } else if (v.equals(b_plus)) {
            if (isPreOperator == true) {
                return;
            }
            isPreOperator = true;
            result.setText(result.getText() + "+");
            operatorList.add("+");

        } else if (v.equals(b_minus)) {
            if (isPreOperator == true) {
                return;
            }
            isPreOperator = true;
            result.setText(result.getText() + "-");
            operatorList.add("-");
        } else if (v.equals(b_multi)) {
            if (isPreOperator == true) {
                return;
            }
            isPreOperator = true;
            result.setText(result.getText() + "X");
            operatorList.add("*");
        } else if (v.equals(b_equal)) {
            if (isPreOperator == true) {
                result.setText("0");
                operatorList.clear();
                isPreOperator = false;
                return;
            }
            result.setText(calc(result.getText().toString()));
        }
    }

    private String calc(String exp) {


        ArrayList<Double> numberList = new ArrayList<Double>();
        StringTokenizer st = new StringTokenizer(exp,"X/+-");

        while( st.hasMoreTokens() ) {
            double number = Double.parseDouble(st.nextToken());
            numberList.add( number );
            Log.d("aaa", String.valueOf(number) );
        }

        double result = numberList.get(0);
        Log.d("aaa", String.valueOf(result) );
        for( int i = 0 ; i < operatorList.size() ; i++ ) {
            String operator = operatorList.get(i);

            if( "*".equals(operator)){
                result = ( result * numberList.get(i+1));
            }else if( "/".equals(operator)){
                result = ( result / numberList.get(i+1));
            }else if( "+".equals(operator)){
                result = ( result + numberList.get(i+1));
            }else if( "-".equals(operator)){
                result = ( result - numberList.get(i+1));
            }
        }
        operatorList.clear();
        numberList.clear();
        return String.valueOf(result);
    }
}
