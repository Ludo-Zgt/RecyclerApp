package fr.labs.zwing.recyclerapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import fr.labs.zwing.recyclerapp.R;

public class Detailsactivity extends AppCompatActivity {

    private static  final  String EXTRA_NAME = "EXTRA_NAME";
    private static  final  String EXTRA_BIOGRAPHY = "EXTRA_BIOGRAPHY";
    private static  final  String EXTRA_COLOR = "EXTRA_COLOR";

    private TextView tvName;
    private TextView tvBiography;
    private CircleImageView coloredBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsactivity);

        /*I wouldn't normally pass all this Data via Intent, so understand that this is just a quick
        implementation to get things working for the Demo. I'd normally pass just a Unique id as an
        extra, and then retrieve the appropriate Data from a Service.*/
        Intent i = getIntent();
        String name = i.getStringExtra(EXTRA_NAME);
        String biography = i.getStringExtra(EXTRA_BIOGRAPHY);
        int drawableResourceExtra = i.getIntExtra(EXTRA_COLOR, 0);

        tvName = findViewById(R.id.lblNameHeader);
        tvName.setText(name);

        tvBiography = findViewById(R.id.lblBiographyBody);
        tvBiography.setText(name+biography);

        coloredBackground = findViewById(R.id.imvColor);
        coloredBackground.setImageResource(
                drawableResourceExtra
        );



    }
}
