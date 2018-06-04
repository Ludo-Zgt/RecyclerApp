package fr.labs.zwing.recyclerapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import fr.labs.zwing.recyclerapp.data.DataSourceInterface;
import fr.labs.zwing.recyclerapp.data.ListItem;
import fr.labs.zwing.recyclerapp.logic.Controller;
import fr.labs.zwing.recyclerapp.view.ViewInterface;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {

    @Mock
    DataSourceInterface dataSource;

    @Mock
    ViewInterface view;

    Controller controller;

    private static final ListItem TEST_ITEM = new ListItem(
            "Bat Man",
            " est un personnage de fiction appartenant à l'univers de DC Comics. Créé par le " +
                    "dessinateur Bob Kane et le scénariste Bill Finger, il apparaît pour la première " +
                    "fois dans le comic book Detective Comics no 27 (date de couverture : mai 1939 mais " +
                    "la date réelle de parution est le 30 mars 1939) avec le nom de The Bat-Man. " +
                    "Bien que ce soit le succès de Superman qui ait amené sa création, il se détache" +
                    " de ce modèle puisqu'il n'a aucun pouvoir surhumain. Batman n'est qu'un simple " +
                    "humain qui a décidé de lutter contre le crime après avoir vu ses parents se faire " +
                    "abattre par un voleur dans une ruelle de Gotham City, la ville où se déroulent la " +
                    "plupart de ses aventures. Malgré sa réputation de héros solitaire, il sait " +
                    "s'entourer d'alliés, comme Robin, son majordome Alfred Pennyworth ou encore le " +
                    "commissaire de police James Gordon.",
            R.color.RED
    );

    @Before
    public void setUpTest(){
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view, dataSource);
    }

    @Test
    public void onGetListDataSuccessful() {
        //Set up any data we need for the test
        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(TEST_ITEM);

        //Set up our Mocks to return the Data we want
        Mockito.when(dataSource.getListOfData())
                .thenReturn(listOfData);

        //Call the method(Unit) we are testing
        controller.getListFromDataSource();

        //Check how the Tested Class responds to the data it receives
        //or test it's behaviour
        Mockito.verify(view).setUpAdapterAndView(listOfData);

    }

    @Test
    public void onListItemClicked() {
        controller.onListItemClick(TEST_ITEM);

        Mockito.verify(view).startDetailActivity(
                TEST_ITEM.getName(),
                TEST_ITEM.getBiography(),
                TEST_ITEM.getColorResource());
    }
}