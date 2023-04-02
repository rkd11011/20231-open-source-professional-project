/* **********************************************
 * 프로젝트명 :  Toast message
 * 작성자 : 2017015040 강수
 * 작성일 : 2023.04.02
 *프로그램 설명 : . 에디트텍스트에 키가 눌릴 때마다, 바뀐 글자가 Toast 메시지로 나오도록 프로그램
 ************************************************/
package com.example.toastmessage;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1;//editText 변수 이름
    String result;//입력된 문자열 저장 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//레이아웃 설정

        setTitle("연습문제 4-8");//엑티비티 타이틀

        editText1 = (EditText) findViewById(R.id.editText1);//editText 객체 할당

        editText1.setOnKeyListener(new View.OnKeyListener() {//키가눌릴때 마다 작동하는 함수
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                result =editText1.getText().toString();//editText에 입력된 문자열을 변수에 저장

                Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
                //Tost 메시지로 입력된 문자열 표시

                return false;
            }
        });
    }
}