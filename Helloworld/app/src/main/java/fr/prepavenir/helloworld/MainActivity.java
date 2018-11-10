package fr.prepavenir.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.e(TAG, "Passage dans la methode on create");

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG, "passage on start");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e(TAG, "passage onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e(TAG, "passage onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.e(TAG, "passage onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.e(TAG, "passage onDestroy");
    }
}
