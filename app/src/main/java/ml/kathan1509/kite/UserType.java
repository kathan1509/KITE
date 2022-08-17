package ml.kathan1509.kite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserType extends AppCompatActivity {
    Button btnstudent, btnteacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("kite_login", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("email"))
        {
            startActivity(new Intent(UserType.this, MainActivity.class));
            finish();
        }

        btnstudent = findViewById(R.id.btnstudent);
        btnteacher =  findViewById(R.id.btnteacher);

        btnstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserType.this,StudentLoginSignup.class));
                finish();
            }
        });

        btnteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserType.this,TeacherLoginSignup.class));
                finish();
            }
        });
    }
}
