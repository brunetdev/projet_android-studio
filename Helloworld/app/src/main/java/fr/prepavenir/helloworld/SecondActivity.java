package fr.prepavenir.helloworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by brune on 21/08/2017.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //affichage du layout avec le chemin mentionner en argument R=ressources
        setContentView(R.layout.activity_second);
    }
}
