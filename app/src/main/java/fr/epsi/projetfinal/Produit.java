package fr.epsi.projetfinal;

import org.json.JSONObject;

public class Produit {

    private final String name;
    private final String description;
    private final String picture_url;

    public Produit(JSONObject o){
        name=o.optString("name","");
        description=o.optString("description","");
        picture_url=o.optString("picture_url","");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture_url() {
        return picture_url;
    }
}
