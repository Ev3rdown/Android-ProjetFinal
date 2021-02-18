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
        holder.getRayonTitle().setText(rayon.getName());
        holder.getRayonCell().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ImageActivity.displayActivity(activity,rayon.getProducts_url(),rayon.getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return rayons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView rayonTitle;
        private final View rayonCell;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            rayonTitle = view.findViewById(R.id.rayonCellName);
            rayonCell = view.findViewById(R.id.rayonCell);
        }

        public View getRayonCell() {
            return rayonCell;
        }
        public TextView getRayonTitle() {
            return rayonTitle;
        }
    }

}
