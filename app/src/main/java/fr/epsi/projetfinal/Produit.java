package fr.epsi.projetfinal;

import org.json.JSONObject;

public class Produit {

    private String name;
    private String description;
    private String picture_url;

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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }
}
