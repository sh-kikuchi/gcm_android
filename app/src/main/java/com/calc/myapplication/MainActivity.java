package com.calc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onclickButton(View view){
        //フォームを値の取得
        EditText num_a_form = (EditText) this.findViewById(R.id.num_a_form);
        EditText num_b_form = (EditText) this.findViewById(R.id.num_b_form);
        TextView calc_result = (TextView) this.findViewById(R.id.calc_result);

        //文字列で変数に格納（フォームの値を）
        String str_a = num_a_form.getText().toString();
        String str_b = num_b_form.getText().toString();

        //文字列を整数に変換
        int a = Integer.parseInt(str_a);
        int b = Integer.parseInt(str_b);

        //大きい数をXに、小さい数をYに格納、Zは剰余
        int X,Y,Z;

        if(a > b) {
            X = a;
            Y = b;
        }else {
            X = b;
            Y = a;
        }

        //ユークリッドの互除法
        while( (Z = X % Y) != 0 ) {
            X = Y;
            Y = Z;
        }

        String msg = "最大公約数は "+Y;

        calc_result.setText(msg);
    }

}