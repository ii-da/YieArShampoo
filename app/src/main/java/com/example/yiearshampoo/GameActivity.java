package com.example.yiearshampoo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {

    private TextView counterTextView;
    private TextView timerTextView;
    private CountDownTimer timer;
    private static final int DEFAULT_TIMER_VALUE = 10;


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, GameActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        counterTextView = findViewById(R.id.counter_text);
        timerTextView = findViewById(R.id.timer_text);

        initTimer();

    }

    private void initTimer() {
        timerTextView.setText(String.valueOf(DEFAULT_TIMER_VALUE));

    }

}