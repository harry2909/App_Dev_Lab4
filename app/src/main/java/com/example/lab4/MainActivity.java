package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // returns the simple name of the underlying class. defined to keep a log
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    // message string
    public static final String EXTRA_MESSAGE = "com.example.lab4.MainActivity.extra.MESSAGE";

    // defining the rest of the variables
    private EditText mMessageEditText;

    public static final int TEXT_REQUEST = 1;

    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    /**
     * OnCreate method is called when the activity starts.
     *
     * @param savedInstanceState is used to save the most recently supplied data to the app.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    /**
     * Method to launch second activity on button press. Logcat message is set.
     * Using intent to bundle the message from main activity "EXTRA_MESSAGE".
     * Start activityforresult is used because we expect a result back.
     *
     * @param view used for drawing and handling events.
     */
    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    /**
     * This method is used if result is registered. (Data is sent back). Check that the request
     * code is equal to the one defined.
     * Check that the result code also equals the same.
     * Then, using the intent from the result, get the message sent and set it into the
     * main activity's textview.
     *
     * @param requestCode used to check it aligns with the variable defined in mainactivity.
     * @param resultCode  used to check it aligns with the variable defined in mainactivity.
     * @param data        the intent data sent from secondactivity.
     */
    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

}