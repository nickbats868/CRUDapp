package org.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Writer implements Serializable {

    private Integer id;
    private Status writerStatus;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private PostStatus status;

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", writerStatus=" + writerStatus +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", posts=" + posts +
                '}';
    }


    public Writer(String firstName, String lastName) {
        this.writerStatus = Status.ACTIVE;
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = new ArrayList<Post>();
    }

    public Writer() {

    }


    public Status getStatus() {
        return writerStatus;
    }

    public void setStatus(Status status) {
        this.writerStatus = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }


    private void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
