package ml.kathan1509.kite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button btnStudentProfile, btnStudentAttendance, btnNotice, btnResults, btnManageApplication, btnStudyMaterial;

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStudentProfile = findViewById(R.id.btnStudentProfile);
        btnStudentAttendance = findViewById(R.id.btnStudentAtendance);
        btnNotice = findViewById(R.id.btnStudentNotice);
        btnStudentAttendance = findViewById(R.id.btnStudentAtendance);
        btnResults = findViewById(R.id.btnResults);
        btnManageApplication = findViewById(R.id.btnManageApplication);
        btnStudyMaterial = findViewById(R.id.btnStudyMaterial);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        btnStudentProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StudentProfile.class));
            }
        });

        btnStudentAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StudentAttendance.class));
            }
        });

        btnNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,StudentNotice.class));
            }
        });

        btnStudentAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,StudentAttendance.class));
            }
        });

        btnResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,StudentResult.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        MenuCompat.setGroupDividerEnabled(menu, true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.aboutusitem:
                startActivity(new Intent(MainActivity.this,AboutUs.class));
                return true;
            case R.id.settingitem:
                startActivity(new Intent(MainActivity.this,Setting.class));
                return true;
            case R.id.logoutitem:
                SharedPreferences.Editor editor;
                SharedPreferences sharedPreferences;
                sharedPreferences = getApplicationContext().getSharedPreferences("kite_login", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.remove("email");
                editor.apply();
                editor.commit();
                startActivity(new Intent(MainActivity.this, UserType.class));
                finish();
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
    }
}