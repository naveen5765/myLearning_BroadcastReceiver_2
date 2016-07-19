package com.learning.naveen.broadcastreceivers_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Intent in New App Detected.", Toast.LENGTH_LONG).show();
            Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(500);
            updateTextView("Broadcast Received from Main Application");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Register mMessageReceiver to receive messages.
        registerReceiver(mMessageReceiver, new IntentFilter("com.learning.naveen.CUSTOMINTENT2"));
    }

    public void updateTextView(final String t){
        TextView tv = (TextView) findViewById(R.id.textview1);
        tv.setText(t);
    }
}
