package com.example.flo.tp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActiviteSuivante extends Activity {
    /** Called when the activity is first created. */
    Activity lecontext;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);
        lecontext = this;
        lecontext.setTitle("Fenetre 2");
        final int codeRetour = 0;

        Button btaction =(Button) findViewById(R.id.button);

        // Récupération du texte dans le champ de saisie
        final EditText textchampsaisie = (EditText)findViewById(R.id.editText);
        Bundle objetBundle = this.getIntent().getExtras();

        // Récupération de la valeur
        String InfoPasse = objetBundle.getString("passInfo");

        // On affiche l'information dans l'editText
        textchampsaisie.setText(InfoPasse);

        // Action sur le bouton click appelle de la nouvelle activité
        btaction.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                // Creation de notre item
                Intent defineIntent2 = lecontext.getIntent();
                // Objet qui va nous permettre de passe des variables ici la variable passInfo
                Bundle objetBundle2 = new Bundle();
                objetBundle2.putString("passInfo2",textchampsaisie.getText().toString());
                // On passe notre objet à notre activité
                defineIntent2.putExtras(objetBundle2);
                // Envoie le résultat suivant l’intent déﬁni
                setResult(codeRetour, defineIntent2);
                // Demande la destruction de la fenêtre courante
                finish();

            }
        });

    }
}
