package fr.epsi.projetfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProduitAdapter extends RecyclerView.Adapter<ProduitAdapter.ViewHolder>{

    private ArrayList<Produit> produits;
    private ProjetActivity activity;

    public ProduitAdapter(ProjetActivity activity, ArrayList<Produit> produits){
        this.activity=activity;
        this.produits = produits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_produit, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produit produit = produits.get(position);
        holder.getProduitName().setText(produit.getName());
        holder.getProduitDescription().setText(produit.getDescription());
        Picasso.get().load(produit.getPicture_url()).into(holder.getProduitImage());

        holder.getRayonCell().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ImageActivity.displayActivity(activity,rayon.getProducts_url(),rayon.getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return produits.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView produitName;
        private final TextView produitDescription;
        private final ImageView produitImage;
        private final View rayonCell;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            produitName = view.findViewById(R.id.produitName);
            produitDescription = view.findViewById(R.id.produitDescription);
            produitImage = view.findViewById(R.id.produitImage);
            rayonCell = view.findViewById(R.id.rayonCell);
        }

        public View getRayonCell() {
            return rayonCell;
        }
        public TextView getProduitName() {
            return produitName;
        }
        public TextView getProduitDescription() {
            return produitDescription;
        }
        public ImageView getProduitImage() {
            return produitImage;
        }
    }

}
