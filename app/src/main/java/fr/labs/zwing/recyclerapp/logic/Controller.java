package fr.labs.zwing.recyclerapp.logic;

import android.view.View;

import fr.labs.zwing.recyclerapp.data.DataSourceInterface;
import fr.labs.zwing.recyclerapp.data.ListItem;
import fr.labs.zwing.recyclerapp.view.ViewInterface;

public class Controller {

    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource();
    }

    public void getListFromDataSource() {
        view.setUpAdapterAndView(
                dataSource.getListOfData()
        );

    }

    public void onListItemClick(ListItem testItem, View viewRoot) {
        view.startDetailActivity(
                testItem.getName(),
                testItem.getBiography(),
                testItem.getColorResource(),
                viewRoot

        );
    }


}
