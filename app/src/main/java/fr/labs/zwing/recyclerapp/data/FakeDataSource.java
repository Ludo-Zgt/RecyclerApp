package fr.labs.zwing.recyclerapp.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.labs.zwing.recyclerapp.R;

public class FakeDataSource implements DataSourceInterface{

    private static final int SIZE_OF_COLLECTION = 12;
    private Random random;

    private final String[] firstnames = {
            "Bat",
            "Dark",
            "Naruto",
            "Gon",
    };

    private final String[] lastnames = {
            " Man",
            " Vador",
            " Uzumaki",
            " Freecss",
    };

    private final String[] biographies = {
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
            ", est un personnage de fiction," +
                    " successivement chevalier Jedi et seigneur Sith, et le personnage central des " +
                    "deux premières trilogies de la saga cinématographique Star Wars conçue par George Lucas.",
            " est le personnage principal du manga Naruto inventé par Masashi Kishimoto.\n" +
                    "\n" +
                    "Dans l'univers de la série, Naruto est un jeune ninja du village de Konoha." +
                    " Hôte du démon renard à neuf queues, une créature qui a attaqué le village par " +
                    "le passé, il est rejeté par les autres villageois. Son ambition est de devenir " +
                    "Hokage, le chef du village, afin de gagner le respect des habitants. " +
                    "De caractère joyeux et déterminé, il parvient au fil de la série à se lier " +
                    "d'amitié avec plusieurs ninjas du village et tout particulièrement avec Sasuke " +
                    "Uchiwa, qu'il considère comme son frère et rival. Au fur et à mesure de sa " +
                    "progression dans la série, il parvient à se faire accepter par les habitants " +
                    "du village, jusqu’à devenir un héros pour eux après les avoir protégés.",
            " est, avec Kirua Zoldik, le héros de Hunter X Hunter. Il est le fils du " +
                    "légendaire Ging Freecs. Il a été élevé par sa tante Mito (la cousine de Ging)," +
                    " qu'il considère comme sa vraie mère. Mito lui fait longtemps croire que son " +
                    "père était mort, mais elle lui avoueras plus tard qu'il est vivant, et qu'elle " +
                    "a obtenu la garde au tribunal. Il possède une personnalité proche de tout " +
                    "héros de manga nekketsu, bien qu'elle soit clairement plus recherchée et profonde."
    };

    private final int[] colors = {
            R.drawable.batman,
            R.drawable.vador,
            R.drawable.naruto,
            R.drawable.gon_freecss

    };

    public FakeDataSource(){

    }


    @Override
    public List<ListItem> getListOfData() {
        ArrayList<ListItem> listOfData = new ArrayList<>();

        random = new Random();
        for (int i = 0; i < 12; i++){

            int randOne = random.nextInt(4);
            int randTwo = random.nextInt(4);
            int randThree = random.nextInt(4);
            int randFour = random.nextInt(4);

            ListItem listItem = new ListItem(
                    firstnames[randOne]+lastnames[randTwo],
                    biographies[randThree],
                    colors[randFour]
            );
            listOfData.add(listItem);
        }
        return listOfData;
    }
}
