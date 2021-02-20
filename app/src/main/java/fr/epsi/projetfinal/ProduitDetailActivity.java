package fr.epsi.projetfinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProduitDetailActivity extends ProjetActivity {

    public static void displayActivity(ProjetActivity activity,String produitImage,String produitNom,String produitDescription){
        Intent intent = new Intent(activity, ProduitDetailActivity.class);
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
        ImageView imageView = findViewById(R.id.productDetailImage);
        TextView descriptionView = findViewById(R.id.productDetailDescription);
        Picasso.get().load(imageUrl).into(imageView);
        descriptionView.setText(description);

    }
}