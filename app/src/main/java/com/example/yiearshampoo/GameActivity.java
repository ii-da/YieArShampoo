package com.example.yiearshampoo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
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
    private ImageView tapButton;
    private int count = 0;
    private static final int DEFAULT_TIMER_VALUE = 10;
    private static final long TOTAL_TIME = DEFAULT_TIMER_VALUE * 1000;
    private static final long INTERVAL_TIME = 1000;


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
        tapButton = findViewById(R.id.tap_button);

        tapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countStr = String.valueOf(++count);
                counterTextView.setText(countStr);

            }
        });

        initTimer();
        timer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        timer = null;
    }

    private void initTimer() {
        timerTextView.setText(String.valueOf(DEFAULT_TIMER_VALUE));

        timer = new CountDownTimer(TOTAL_TIME, INTERVAL_TIME) {
            @Override
            public void onTick(long millisUntilFinished) {
                long second = millisUntilFinished / 1000;
                timerTextView.setText(String.valueOf(second));
            }

            @Override
            public void onFinish() {
                tapButton.setOnClickListener(null);
                String countStr = counterTextView.getText().toString();
                Intent intent = ClearActivity.newIntent(GameActivity.this, Integer.parseInt(countStr));
                startActivity(intent);
            }
        };

    }

}