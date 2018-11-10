package fr.prepavenir.itent.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fr.prepavenir.itent.R;
import fr.prepavenir.itent.ui.second.SecondActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showActivity(View view) {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);


        //startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }


    public void showOtherApp(View view) {
    }

    public void showForm(View view) {
    }

    public void CreateService(View view) {
    }

    public void DestroyService(View view) {
    }
}
