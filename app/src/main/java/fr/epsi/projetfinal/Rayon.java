package fr.epsi.projetfinal;

import org.json.JSONObject;

public class Rayon {

    private final String category_id;
    private final String title;
    private final String products_url;

    public Rayon(JSONObject o){
        category_id=o.optString("category_id","");
        title=o.optString("title","");
        products_url=o.optString("products_url","");
    }

    public String getTitle() { return title; }

    public String getProducts_url() { return products_url; }

}
