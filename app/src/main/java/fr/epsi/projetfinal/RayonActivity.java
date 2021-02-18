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


public class RayonActivity extends ProjetActivity {

    String wsUrl="https://djemam.com/epsi/categories.json";
    ArrayList<Rayon> rayons;
    RayonAdapter rayonAdapter;
    RecyclerView recyclerView;
    public static void displayActivity(ProjetActivity activity){
        Intent intent = new Intent(activity, RayonActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rayon);
        setTitle("Rayons");
        showBack();
        recyclerView=findViewById(R.id.recyclerView);
        rayons = new ArrayList<>();
        rayonAdapter = new RayonAdapter(this, rayons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(rayonAdapter);
        WSCall wsCall= new WSCall(wsUrl, new WSCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject=new JSONObject(result);
                    JSONArray jsonItems=jsonObject.getJSONArray("items");
                    for (int i=0;i<jsonItems.length();i++){
                        Rayon rayon = null;
                        rayon = new Rayon(jsonItems.getJSONObject(i));
                        rayons.add(rayon);
                    }
                    rayonAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(RayonActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();
    }
}