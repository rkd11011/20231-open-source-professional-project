/* **********************************************
 * 프로젝트명 :  Button properties
 * 작성자 : 2017015040 강수
 * 작성일 : 2023.04.02
 *프로그램 설명 : 체크박스를 선택할 때마다, 버튼의 속성이 설정되는 프로그램
 ************************************************/
package com.example.buttonproperties;
import android.os.Bundle;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox1, checkBox2, checkBox3;//체크박스 변수 선언
    Button Button;//버튼 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //레이아웃 파일에서 각 위젯에 변수 할당
        checkBox1 = findViewById(R.id.Checkbox1);
        checkBox2 = findViewById(R.id.Checkbox2);
        checkBox3 = findViewById(R.id.Checkbox3);
        Button = findViewById(R.id.Button);

        //첫 번째 체크박스 체크 변경 리스너 등록
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //체크박스의 체크 상태에 따라 버튼의 활성화 상태를 변경
                if (checkBox1.isChecked() == true){
                    Button.setEnabled(true);
                } else {
                    Button.setEnabled(false);
                }
            }
        });

        //두 번째 체크박스 체크 변경 리스너 등록
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //체크박스의 체크 상태에 따라 버튼의 클릭 가능 상태를 변경
                if (checkBox2.isChecked() == true){
                    Button.setClickable(true);
                } else {
                    Button.setClickable(false);
                }
            }
        });


        //세 번째 체크박스 체크 변경 리스너 등록
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //체크박스의 체크 상태에 따라 버튼 각도 변경
                if (checkBox3.isChecked() == true){
                    Button.setRotation(45);
                } else {
                    Button.setRotation(0);
                }
            }
        });
    }
}