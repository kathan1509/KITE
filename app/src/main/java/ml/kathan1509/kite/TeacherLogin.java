package ml.kathan1509.kite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class TeacherLogin extends AppCompatActivity {
    Button btnLoginTeacher;
    EditText edtemail, edtpassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        mAuth = FirebaseAuth.getInstance();

        btnLoginTeacher = findViewById(R.id.btnLoginTeacher);
        edtemail = findViewById(R.id.edttechloginemail);
        edtpassword = findViewById(R.id.edttechloginpassword);

        btnLoginTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = edtemail.getText().toString();
                String password = edtpassword.getText().toString();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(TeacherLogin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(TeacherLogin.this,"Authentication Probelm",Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(TeacherLogin.this,"Login Successful",Toast.LENGTH_SHORT).show();
                            SharedPreferences.Editor editor;
                            SharedPreferences sharedPreferences;
                            sharedPreferences = getApplicationContext().getSharedPreferences("kite_login", Context.MODE_PRIVATE);
                            editor = sharedPreferences.edit();
                            editor.putString("email",email);
                            editor.apply();
                            editor.commit();
                            Intent intent = new Intent(TeacherLogin.this, TeacherDashboard.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(TeacherLogin.this,TeacherLoginSignup.class));
        finish();
    }
}