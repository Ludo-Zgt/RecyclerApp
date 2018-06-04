package fr.labs.zwing.recyclerapp.view;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.labs.zwing.recyclerapp.data.ListItem;

public interface ViewInterface {

    void startDetailActivity(String name, String biography, int colorResource, View viewRoot);

    void setUpAdapterAndView(List<ListItem> listOfData);
}
