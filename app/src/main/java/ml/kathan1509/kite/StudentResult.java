package ml.kathan1509.kite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class StudentResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_result);



        WebView myWebView = findViewById(R.id.webView);
        myWebView.loadUrl("https://www.students.gtu.ac.in/StudHist.aspx");
    }
}
