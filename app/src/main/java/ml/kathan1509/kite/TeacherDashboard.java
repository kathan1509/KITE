package ml.kathan1509.kite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

public class TeacherDashboard extends AppCompatActivity {
    Button btnTeacherProfile, btnEnterAttendance, btnEnterNotice, btnManageApplication, btnEnterStudyMaterial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        btnTeacherProfile = findViewById(R.id.btnTeacherProfile);
        btnEnterAttendance = findViewById(R.id.btnEnterAtendance);
        btnEnterNotice = findViewById(R.id.btnTeacherNotice);
        btnManageApplication = findViewById(R.id.btnManageApplication);
        btnEnterStudyMaterial = findViewById(R.id.btnEnterStudyMaterial);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        btnTeacherProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeacherDashboard.this,TeacherProfile.class));
                finish();
            }
        });

        btnEnterAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnEnterNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnEnterStudyMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnManageApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                startActivity(new Intent(TeacherDashboard.this, AboutUs.class));
                return true;
            case R.id.settingitem:
                startActivity(new Intent(TeacherDashboard.this, Setting.class));
                return true;
            case R.id.logoutitem:
                SharedPreferences.Editor editor;
                SharedPreferences sharedPreferences;
                sharedPreferences = getApplicationContext().getSharedPreferences("kite_login", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.remove("email");
                editor.apply();
                editor.commit();
                startActivity(new Intent(TeacherDashboard.this,UserType.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}