package fr.labs.zwing.recyclerapp.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import fr.labs.zwing.recyclerapp.R;
import fr.labs.zwing.recyclerapp.data.FakeDataSource;
import fr.labs.zwing.recyclerapp.data.ListItem;
import fr.labs.zwing.recyclerapp.logic.Controller;

public class ListActivity extends AppCompatActivity implements ViewInterface{

    private static  final  String EXTRA_NAME = "EXTRA_NAME";
    private static  final  String EXTRA_BIOGRAPHY = "EXTRA_BIOGRAPHY";
    private static  final  String EXTRA_COLOR = "EXTRA_COLOR";

    private  List<ListItem> listOfData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private Toolbar toolbar;

    private Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recListActivity);
        layoutInflater = getLayoutInflater();

        toolbar = (Toolbar) findViewById(R.id.tlb_list_activity);

        toolbar.setTitle(R.string.title_list_activity);
        //toolbar.setLogo(R.drawable.ic_view_list_white_24dp);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            toolbar.setTitleMarginStart(72);
        }

        //This is Dependency Injection here
        controller = new Controller(this, new FakeDataSource());
    }

    @Override
    public void startDetailActivity(String name, String biography, int colorResource, View viewRoot) {
        Intent intent = new Intent(this, Detailsactivity.class);
        intent.putExtra(EXTRA_COLOR, colorResource);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_BIOGRAPHY, biography);

        getWindow().setEnterTransition(new Fade(Fade.IN));
        getWindow().setEnterTransition(new Fade(Fade.OUT));

        Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(
                viewRoot.findViewById(R.id.imvListCircle),
                getString(R.string.transition_img)
        );
        pairs[1] = new Pair<View, String>(
                viewRoot.findViewById(R.id.lblName),
                getString(R.string.transition_name)
        );
        pairs[2] = new Pair<View, String>(
                viewRoot.findViewById(R.id.lblBiography),
                getString(R.string.transition_bio)
        );
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                pairs
        );

        startActivity(intent, options.toBundle());
    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {
        this.listOfData = listOfData;
        //new GridLayoutManager or StaggeredGridLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);

    }

    private class CustomAdapter extends  RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(R.layout.item_data, parent, false);
            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
            ListItem currentItem = listOfData.get(position);

            holder.coloredCircle.setImageResource(
                    currentItem.getColorResource()
            );
            holder.name.setText(
                    currentItem.getName()
            );
            holder.biography.setText(
                    currentItem.getName()+currentItem.getBiography()
            );
        }

        @Override
        public int getItemCount() {
            return listOfData.size();
        }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private CircleImageView coloredCircle;
            private TextView name;
            private TextView biography;
            private ViewGroup container;

            public CustomViewHolder(View itemView) {
                super(itemView);

                this.coloredCircle = itemView.findViewById(R.id.imvListCircle);
                this.name = itemView.findViewById(R.id.lblName);
                this.biography = itemView.findViewById(R.id.lblBiography);
                this.container = itemView.findViewById(R.id.rootListItem);

                Pair[] pairs = new Pair[3];

                pairs[0] = new Pair<View, String>(name, "transColor");
                pairs[1] = new Pair<View, String>(name, "transName");
                pairs[2] = new Pair<View, String>(name, "transBio");

                this.container.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                ListItem listItem = listOfData.get(
                        this.getAdapterPosition()
                );

                controller.onListItemClick(
                        listItem,
                        v
                );
            }
        }
    }
}