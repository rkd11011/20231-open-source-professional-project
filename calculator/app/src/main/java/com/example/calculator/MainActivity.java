/* **********************************************
 * 프로젝트명 :  calculator
 * 작성자 : 2017015040 강수
 * 작성일 : 2023.04.02
 *프로그램 설명 : 테이블레이아웃 계산기 프로그램
 ************************************************/

package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;

    // 10개 숫자 버튼 배열
    Button[] numButtons = new Button[10];
    // 10개 숫자 버튼의 id 값 배열
    Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
            R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6,
            R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };
    int i; // 증가값 용도

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //액션바 설정
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.images);

        setTitle("테이블레이아웃 계산기");


        //인스턴스 생성
        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);

        textResult = (TextView) findViewById(R.id.TextResult);

        //더하기
        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        //뻬기
        btnSub.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        //곱하기
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        //나누기
        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        // 숫자 버튼 10개를 대입
        for (i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }
        // 숫자 버튼 10개에 대해서 클릭이벤트 처리
        for (i = 0; i < numBtnIDs.length; i++) {

            final int index; //버튼 인덱스
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // 포커스가 되어 있는 에디트텍스트에 숫자 추가
                    if (edit1.isFocused() == true) {//첫번째 에디트텍스트
                        num1 = edit1.getText().toString()
                                + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused() == true) {//두번째 에디트텍스트
                        num2 = edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {//에디트텍스트 선택 안된경우
                        Toast.makeText(getApplicationContext(),
                                "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }

    }
}
