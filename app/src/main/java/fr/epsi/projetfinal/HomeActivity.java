package fr.epsi.projetfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends ProjetActivity implements View.OnClickListener {

    public static void displayActivity(ProjetActivity activity){
        Intent intent = new Intent(activity,HomeActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.buttonEtudiants).setOnClickListener(this);
        findViewById(R.id.buttonProduit).setOnClickListener(this);
        setTitle("Home");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonEtudiants:
                EtudiantListeActivity.displayActivity(this);
                break;
            case R.id.buttonProduit:
                ListeRayonActivity.displayActivity(this);
                break;
        }
    }
}