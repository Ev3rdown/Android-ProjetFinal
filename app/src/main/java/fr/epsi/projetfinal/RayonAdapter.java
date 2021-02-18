package fr.epsi.projetfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class RayonAdapter extends RecyclerView.Adapter<RayonAdapter.ViewHolder>{

    private ArrayList<Rayon> rayons;
    private ProjetActivity activity;

    public RayonAdapter(ProjetActivity activity, ArrayList<Rayon> rayons){
        this.activity=activity;
        this.rayons = rayons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_rayon, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Rayon rayon = rayons.get(position);
        holder.getListeRayonTitle().setText(rayon.getTitle());
        holder.getListeRayonCell().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProduitActivity.displayActivity(activity, rayon.getProducts_url(), rayon.getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return rayons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView listeRayonCellTitle;
        private final View listeRayonCell;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            listeRayonCellTitle = view.findViewById(R.id.listeRayonCellTitle);
            listeRayonCell = view.findViewById(R.id.listeRayonCell);
        }

        public View getListeRayonCell() {
            return listeRayonCell;
        }
        public TextView getListeRayonTitle() {
            return listeRayonCellTitle;
        }
    }

}
