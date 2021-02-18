package fr.epsi.projetfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ProduitDetail extends ProjetActivity {

    public static void displayActivity(ProjetActivity activity,String produitImage,String produitNom,String produitDescription){
        Intent intent = new Intent(activity, ProduitActivity.class);
        intent.putExtra("produitImage",produitImage);
        intent.putExtra("produitNom",produitNom);
        intent.putExtra("produitDescription",produitDescription);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit_detail);
        String nom = getIntent().getExtras().getString("produitNom");
        String description = getIntent().getExtras().getString("produitDescription");
        String imageUrl = getIntent().getExtras().getString("produitImage");
        showBack();
        setTitle(nom);

    }
}