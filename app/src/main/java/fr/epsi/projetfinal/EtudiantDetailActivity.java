package fr.epsi.projetfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class EtudiantDetailActivity extends ProjetActivity {
    public static void displayActivity(ProjetActivity activity,String etudiant){

        try {
            JSONObject student = new JSONObject(StudentsData.students).getJSONObject(etudiant);
            Intent intent = new Intent(activity,EtudiantDetailActivity.class);
            intent.putExtra("nom",student.optString("nom"));
            intent.putExtra("prenom",student.optString("prenom"));
            intent.putExtra("mail",student.optString("mail"));
            intent.putExtra("group",student.optString("group"));
            intent.putExtra("img",student.optString("img"));
            activity.startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant_detail);
        String prenomNom = getIntent().getExtras().getString("prenom","")+" "+getIntent().getExtras().getString("nom","");
        setTitle(prenomNom);
        showBack();

        TextView nom = findViewById(R.id.studentName);
        TextView mail = findViewById(R.id.studentMail);
        TextView group = findViewById(R.id.studentGroup);
        ImageView pp = findViewById(R.id.studentImage);

        nom.setText(prenomNom);
        mail.setText(getIntent().getExtras().getString("mail",""));
        group.setText(getIntent().getExtras().getString("group",""));
        Context context = pp.getContext();
        int id = context.getResources().getIdentifier(getIntent().getExtras().getString("img",""), "drawable", context.getPackageName());
        pp.setImageResource(id);
    }
}