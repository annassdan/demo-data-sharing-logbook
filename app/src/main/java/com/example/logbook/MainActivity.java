package com.example.logbook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Integer IFIP_REQUEST_CODE = 1990;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_open_ifip);
        textView = findViewById(R.id.text_view_logbook);

        String packageName = "com.example.ifip";
        String action = "com.example.ifip.OPEN_ACTIVITY";

        button.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "REQUEST SEND, and OPEN IFIP", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(action);
            intent.setPackage(packageName);
            if (intent != null) {
                startActivityForResult(intent, IFIP_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IFIP_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "RESPONSE OK", Toast.LENGTH_SHORT).show();
                String result = data.getStringExtra("IFIP_PROCESS_RESULT");

                if (textView != null) {
                    textView.setText("IFIP Response is " + result);
                }
            }
        }
    }
}