package fr.labs.zwing.recyclerapp.view;

import java.util.List;

import fr.labs.zwing.recyclerapp.data.ListItem;

public interface ViewInterface {

    void startDetailActivity(String name, String biography, int colorResource);

    void setUpAdapterAndView(List<ListItem> listOfData);
}
