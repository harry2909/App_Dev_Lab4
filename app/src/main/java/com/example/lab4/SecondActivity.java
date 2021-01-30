package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    // Reply message
    public static final String EXTRA_REPLY = "com.example.lab4.MainActivity.extra.REPLY";

    // Edit text field
    private EditText mReply;

    /**
     * OnCreate method is called when the activity starts.
     * Get Intent from MainActivity and then put the message from reply back into it.
     *
     * @param savedInstanceState is used to save the most recently supplied data to the app.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply = findViewById(R.id.editText_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }

    /**
     * Get reply text from the edit text field.
     * Define new intent, put the reply back as the "EXTRA_REPLY" message.
     *
     * @param view used for drawing and event handling.
     */
    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}