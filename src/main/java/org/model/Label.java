package org.model;
//label == метка

public class Label {
    private String id;
    private String name;
    private PostStatus status;

    public Label(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        //override the method for convenient output of information
        // about the label as a string
        return "Label{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
