package fr.epsi.projetfinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ListeRayonActivity extends ProjetActivity {

    String wsUrl="https://djemam.com/epsi/categories.json";
    ArrayList<ListeRayon> listeRayons;
    ListeRayonAdapter listeRayonAdapter;
    RecyclerView recyclerView;
    public static void displayActivity(ProjetActivity activity){
        Intent intent = new Intent(activity, ListeRayonActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rayon);
        setTitle("Rayons");
        showBack();
        recyclerView=findViewById(R.id.recyclerView);
        listeRayons = new ArrayList<>();
        listeRayonAdapter = new ListeRayonAdapter(this, listeRayons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listeRayonAdapter);
        WSCall wsCall= new WSCall(wsUrl, new WSCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject=new JSONObject(result);
                    JSONArray jsonItems=jsonObject.getJSONArray("items");
                    for (int i=0;i<jsonItems.length();i++){
                        ListeRayon listeRayon = null;
                        listeRayon = new ListeRayon(jsonItems.getJSONObject(i));
                        listeRayons.add(listeRayon);
                    }
                    listeRayonAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(ListeRayonActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();
    }
}