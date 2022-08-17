package ml.kathan1509.kite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentSignup2 extends AppCompatActivity {
    EditText edtPhoneNumber, edtSemester;
    Button btnSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_signup2);

        final FirebaseAuth mAuth = FirebaseAuth.getInstance();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


        edtPhoneNumber = findViewById(R.id.edtStuPhoneNumber);
        edtSemester = findViewById(R.id.edtStuSemester);
        btnSignup = findViewById(R.id.btnSignUp);

        final String email = getIntent().getStringExtra("email");
        final String password  = getIntent().getStringExtra("password");
        String enroll = getIntent().getStringExtra("enrollment");

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = edtPhoneNumber.getText().toString().trim();
                String Semester = edtSemester.getText().toString().trim();

                if (TextUtils.isEmpty(phoneNumber)){
                    Toast.makeText(getApplicationContext(),"Enter Phone Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Semester)){
                    Toast.makeText(getApplicationContext(),"Enter Semester",Toast.LENGTH_SHORT).show();
                }

                //create user
                assert email != null;
                assert password != null;
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(StudentSignup2.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(StudentSignup2.this,"Create User With Email:onComplete:"+task.isSuccessful(),Toast.LENGTH_SHORT).show();

                        if (!task.isSuccessful()){
                            Toast.makeText(StudentSignup2.this,"Authentication Failed :"+task.getException(),Toast.LENGTH_SHORT).show();

                        }else {
                            startActivity(new Intent(StudentSignup2.this,StudentSignup2.class));
                        }
                    }
                });

            }
        });
    }
}