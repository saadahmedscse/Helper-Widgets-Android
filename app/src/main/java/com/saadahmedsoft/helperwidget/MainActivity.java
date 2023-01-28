package com.saadahmedsoft.helperwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.saadahmedev.helperwidget.widgets.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv_custom);
        LinearLayout layout = findViewById(R.id.layout);

//        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        p.setMargins(15,15,15,15);
//        layout.setLayoutParams(p);

        tv.setOnClickListener(v -> {
            //Toast.makeText(this, tv.getString(), Toast.LENGTH_SHORT).show();
        });

        tv.enable();
    }
}