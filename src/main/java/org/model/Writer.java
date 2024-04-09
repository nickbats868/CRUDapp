package org.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Пользователь в консоли должен иметь возможность
//  получения и редактирования (get/set-методы в каждом классе слоя model)
//  и создания, удаления данных (
public class Writer implements Serializable {

    private String uniqueID;
    private Status status;
    private String firstName;
    private String lastName;
    private List<Post> posts;

    //возможность создания
    //два конструктора - использована перегрузка методов (конструкторов)
    public Writer(String firstName, String lastName) {
        this.status = Status.ACTIVE;
        this.uniqueID = UUID.randomUUID().toString(); //определение уникального ID при создании объекта
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = new ArrayList<Post>();
    }

    public Writer(String firstName, String lastName, List<Post> posts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
    }

    //get - получение, set - назначение
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
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

//    public void addPost(Post post) {
//        posts.add(post);
//    }

    private void setPosts(List<Post> posts) {
        this.posts = posts;
    }

//    //возможность удаления данных
//    private void deletePost(Post post){
//        post.setStatus(PostStatus.DELETED);
//    }

//    //метод для удаления объекта Писатель по его uID
//    private void deleteWriter(String uniqueID){
//        //сначала нужно найти объект по полученному в параметрах метода uniqueID
//        Writer writerToDelete = null;
//    }
}
