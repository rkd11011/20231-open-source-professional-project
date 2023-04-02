/* **********************************************
 * 프로젝트명 :  Button rotate
 * 작성자 : 2017015040 강수
 * 작성일 : 2023.04.02
 *프로그램 설명 : 버튼을 클릭하면 이미지가 10도씩 회전하는 프로그램
 ************************************************/

package com.example.buttonrotate;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button rotateButton; // 회전 버튼 선언
    private ImageView imageView; // 이미지 뷰 선언
    private int rotation = 0; // 이미지 회전 값 초기화

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rotateButton = findViewById(R.id.rotate_button); // 회전 버튼을 레이아웃에서 할당
        imageView = findViewById(R.id.image_view); // 이미지 뷰를 레이아웃에서 할당

        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 회전 버튼이 클릭될 때 호출
                rotation += 10; // 현재 이미지 회전값에 10을 더함
                imageView.setRotation(rotation); // 이미지뷰에 회전값을 적용하여 이미지 회전
            }
        });
    }
}