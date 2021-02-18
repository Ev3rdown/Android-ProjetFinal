package fr.epsi.projetfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EtudiantListeActivity extends ProjetActivity implements View.OnClickListener {

    public static void displayActivity(ProjetActivity activity){
        Intent intent = new Intent(activity,EtudiantListeActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant_liste);
        showBack();
        setTitle("Liste des étudiants");
        findViewById(R.id.buttonYoann).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonYoann:
                EtudiantDetailActivity.displayActivity(this,"yoann");
                break;
        }
    }
}