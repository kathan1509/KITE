package ml.kathan1509.kite;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class StudentSignup extends AppCompatActivity {
    Button btnNext;
    EditText edtEmail, edtEnroll, edtPassword;
    CheckBox check;
    ProgressBar progressBar;
    private static final String TAG = "DocSnippets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_signup);

        // Initialize FireBase Auth
        final FirebaseAuth mAuth = FirebaseAuth.getInstance();

        // Access a Cloud Firestore instance from your Activity
        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        //FindViewBy id part
        btnNext =  findViewById(R.id.btnNext);
        edtEmail = findViewById(R.id.signupemail);
        edtEnroll = findViewById(R.id.signupenroll);
        edtPassword = findViewById(R.id.siguppassword);
        check = findViewById(R.id.signupcheck);
        progressBar = findViewById(R.id.signupProgressBar);

        //Methods
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = edtEmail.getText().toString().trim();
                String enrollment = edtEnroll.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Enter Email Address",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(enrollment)){
                    Toast.makeText(getApplicationContext(),"Enter Enrollment Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Enter the Password",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!check.isChecked()){
                    Toast.makeText(getApplicationContext(),"You haven't Agreed to our term",Toast.LENGTH_SHORT).show();
                    return;
                }

                else {
                    Intent i = new Intent(StudentSignup.this,StudentSignup2.class);
                    i.putExtra("email",email);
                    i.putExtra("password",password);
                    i.putExtra("enrollment",enrollment);
                    startActivity(i);
                }

                progressBar.setVisibility(View.VISIBLE);

                /*Map<String,Object> user = new HashMap<>();
                user.put("email",email);
                user.put("password",password);
                user.put("enrollment",enrollment);

                db.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG,"DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Log.w(TAG,"Error Adding Document",e);
                    }
                });

                //create user
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(StudentSignup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(StudentSignup.this,"Create User With Email:onComplete:"+task.isSuccessful(),Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);

                        if (!task.isSuccessful()){
                            Toast.makeText(StudentSignup.this,"Authentication Failed :"+task.getException(),Toast.LENGTH_SHORT).show();

                        }else {
                            startActivity(new Intent(StudentSignup.this,StudentSignup2.class));
                        }
                    }
                });*/
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}