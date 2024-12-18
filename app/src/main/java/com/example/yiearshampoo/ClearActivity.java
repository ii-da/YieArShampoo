package com.example.yiearshampoo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ClearActivity extends AppCompatActivity {

    private static final String KEY_TAP_COUNT = "key_tap_count";
    private ImageView backBtn;
    public static Intent newIntent(Context context, int count) {
        Intent intent = new Intent(context, ClearActivity.class);
        intent.putExtra(KEY_TAP_COUNT, count);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clear);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backBtn = findViewById(R.id.back_button);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent = MainActivity.newIntent(ClearActivity.this);
                //startActivity(intent);
            }
        });
        int tapCount = getIntent().getIntExtra(KEY_TAP_COUNT, -1);

        Log.d("tag", "tapcount = " + tapCount);
    }
}