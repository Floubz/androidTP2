package com.example.flo.tp1;

import android.app.Activity;
import android.app.SearchManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    Activity lecontext;
    int activiteSuivanteID = 1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lecontext = this;

        // Récupération du text dans le champ de saisie
        final EditText textchampsaisie = (EditText) findViewById(R.id.editText);

        Button btaction = (Button) findViewById(R.id.button);

        // Action sur le bouton click appelle de la nouvelle activité
        btaction.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                // Creation de notre item
                Intent defineIntent = new Intent(lecontext, ActiviteSuivante.class);
                // Objet qui va nous permettre de passe des variables ici la variable passInfo
                Bundle objetBundle = new Bundle();

                objetBundle.putString("passInfo", textchampsaisie.getText().toString());
                // On passe notre objet à notre activité
                defineIntent.putExtras(objetBundle);
                // On appelle notre activité
                //lecontext.startActivity(defineIntent);
                lecontext.startActivityForResult(defineIntent, activiteSuivanteID);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Si le résultat provient d’une demande de la fenêtre1
        if (requestCode == 1) {
            // le code retour est bon
            if (resultCode == 0) {
                //récupérer les informations
                // Récupération de la valeur
                Bundle objetBundle2 = data.getExtras();
                String InfoPasse2 = objetBundle2.getString("passInfo2");
                // On affiche l'information dans l'editText
                EditText textchampsaisie2 = (EditText)findViewById(R.id.editText);
                textchampsaisie2.setText(InfoPasse2);
                Log.e("message ", "message");
            }
        }
    }

}

