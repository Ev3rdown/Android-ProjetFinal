package fr.epsi.projetfinal;

import org.json.JSONObject;

public class ListeRayon {

    private String category_id;
    private String title;
    private String products_url;

    public ListeRayon(JSONObject o){
        category_id=o.optString("category_id","");
        title=o.optString("title","");
        products_url=o.optString("products_url","");
    }

    public String getTitle() { return title; }

    public String getCategory_id() { return category_id; }

    public String getProducts_url() { return products_url; }

    public void setCategory_id(String category_id) { this.category_id = category_id; }

    public void setProducts_url(String products_url) { this.products_url = products_url; }

    public void setTitle(String title) { this.title = title; }
}
