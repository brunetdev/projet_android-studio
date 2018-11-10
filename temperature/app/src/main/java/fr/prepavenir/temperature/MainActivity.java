package fr.prepavenir.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main";
    private EditText editTextCelsius;
    private EditText editTextFahrenheit;
    private ListView listeViewTemperature;
    private Button buttonSave;

    // private String[] items = {"france", "belgique", "Suisse", "Angleterre", "Espagne", "Canada"};

    //création d'une liste en ne pas oublier de l'instancier avec le new
    private List<String> stringList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    //affichage du menu
    @Override
    public boolean onCreateOptionsMenu(Menu zoneMenu) {

        //inclusion du fichier xml menu
        getMenuInflater().inflate(R.menu.menu, zoneMenu);

        return super.onCreateOptionsMenu(zoneMenu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_delete:
                // TODO: effacer les élément dela liste
                stringList.clear();
                adapter.notifyDataSetChanged();

                // TODO: effacer les données dds 2 champs
                editTextCelsius.setText("");
                editTextFahrenheit.getText().clear();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelsius = (EditText) findViewById(R.id.editTextCelsius);
        editTextFahrenheit = (EditText) findViewById(R.id.editTextFahrenheit);
        listeViewTemperature = (ListView) findViewById(R.id.listViewTemperature);
        buttonSave = (Button) findViewById(R.id.buttonSave);

        editTextCelsius.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String valeurSaisie = editable.toString(); //pour recuperer la valeur sous forme de chaine

                if (editTextCelsius.hasFocus() && valeurSaisie.length() > 0 && TemperatureConverter.isNumeric(valeurSaisie)) {
                    double valeurDouble = Double.valueOf(valeurSaisie);

                    editTextFahrenheit.setText(TemperatureConverter.fahrenheitFromCelcius(valeurDouble));

                }
            }
        });

        editTextFahrenheit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String valeurSaisie = editable.toString(); //pour recuperer la valeur sous forme de chaine

                if (editTextFahrenheit.hasFocus() && valeurSaisie.length() > 0 && TemperatureConverter.isNumeric(valeurSaisie)) {
                    double valeurDouble = Double.valueOf(valeurSaisie);

                    editTextCelsius.setText(TemperatureConverter.celsiusFromFahrenheit(valeurDouble));

                }
            }
        });

        //gestion de la sauvegarde
        //mise a jour de la liste
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, stringList);
        listeViewTemperature.setAdapter(adapter);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : Enregistrer la temperature dans la liste

                Log.e(TAG, "celsius: " + editTextCelsius.getText().toString());
                Log.e(TAG, "farenheit: " + editTextFahrenheit.getText().toString());

                //ajouter les données a la liste sous forme de chaine de caractere
                //stringList.add(editTextCelsius.getText().toString() + "°C est egale à" + editTextFahrenheit.getText().toString() + "°F");

                //x°c est egal à y°F
                stringList.add(String.format(getString(R.string.main_text_list),
                        editTextCelsius.getText().toString(),
                        editTextFahrenheit.getText().toString()));

                //rafraichissement de la liste
                adapter.notifyDataSetChanged();
            }
        });

        //effacement d'un element de liste
        listeViewTemperature.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                stringList.remove(i);//efacement de l'élément

                //rafraichissement de la liste
                adapter.notifyDataSetChanged();

                return false;
            }
        });


    }
}
