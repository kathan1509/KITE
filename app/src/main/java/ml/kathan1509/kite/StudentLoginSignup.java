package ml.kathan1509.kite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentLoginSignup extends AppCompatActivity {
    Button btnStudentSignup, btnStudentLogin;

    @Override
    public void onBackPressed() {
        startActivity(new Intent(StudentLoginSignup.this, UserType.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login_signup);

        btnStudentLogin = findViewById(R.id.btnstudentlogin);
        btnStudentSignup =  findViewById(R.id.btnstudentsignup);

        btnStudentSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentLoginSignup.this,StudentSignup.class));
                finish();
            }
        });

        btnStudentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentLoginSignup.this,StudentLogin.class));
                finish();
            }
        });
    }
}
