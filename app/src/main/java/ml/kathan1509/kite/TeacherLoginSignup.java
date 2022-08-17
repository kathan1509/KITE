package ml.kathan1509.kite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherLoginSignup extends AppCompatActivity {
    Button btnTeacherLogin, btnTeacherSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login_signup);

        btnTeacherLogin = findViewById(R.id.btnTeacherLogin);
        btnTeacherSignUp = findViewById(R.id.btnTeacherSignUp);

        btnTeacherLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeacherLoginSignup.this,TeacherLogin.class));
                finish();
            }
        });

        btnTeacherSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeacherLoginSignup.this,StudentSignup.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(TeacherLoginSignup.this,UserType.class));
        finish();
    }
}