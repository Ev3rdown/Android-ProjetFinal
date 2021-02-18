package fr.epsi.projetfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ListeRayonAdapter extends RecyclerView.Adapter<ListeRayonAdapter.ViewHolder>{

    private ArrayList<ListeRayon> listeRayons;
    private ProjetActivity activity;

    public ListeRayonAdapter(ProjetActivity activity, ArrayList<ListeRayon> listeRayons){
        this.activity=activity;
        this.listeRayons = listeRayons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_liste_rayon, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListeRayon listeRayon = listeRayons.get(position);
        holder.getListeRayonTitle().setText(listeRayon.getTitle());
        holder.getListeRayonCell().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RayonActivity.displayActivity(activity,listeRayon.getProducts_url(),listeRayon.getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listeRayons.size();
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
