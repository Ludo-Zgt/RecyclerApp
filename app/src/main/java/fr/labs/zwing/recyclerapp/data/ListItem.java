package fr.labs.zwing.recyclerapp.data;

public class ListItem {

    private String name;
    private String biography;
    private int colorResource;

    public ListItem(String name, String biography, int colorResource) {
        this.name = name;
        this.biography = biography;
        this.colorResource = colorResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String message) {
        this.biography = message;
    }

    public int getColorResource() {
        return colorResource;
    }

    public void setColorResource(int colorResource) {
        this.colorResource = colorResource;
    }
}
