package com.example.praktikos_darbas_1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button changeTextButton;
    private TextView changeTextView;
    private  Button changeColorButton;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        changeTextButton = findViewById(R.id.buttonChangeText);
        changeTextView = findViewById(R.id.textView);
        changeColorButton = findViewById(R.id.buttonChangeColor);

        changeTextButton.setOnClickListener(view -> {
            changeTextView.setText(R.string.textViewUpdatedText);
        });

        changeColorButton.setOnClickListener(view -> {
            changeTextView.setTextColor(Color.argb(255, random.nextInt(256),
                    random.nextInt(256), random.nextInt(256)));
        });
    }


}