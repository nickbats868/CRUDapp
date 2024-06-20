package org.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Post {
    private PostStatus postStatus;
    private String id;
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labels;




    public Post(List<Label> labels) {
        this.postStatus = PostStatus.ACTIVE; //Инициализация поля объекта класса Post значением Active
        this.id = UUID.randomUUID().toString();//Генерация уникального идентификатора,
        // преобразование его в строковое представление и присваивание его полю id
        this.created = new Date(); //Установка текущего времени при создании объекта
        this.labels = labels;
    }

    public void addContent(String content) { //Метод ИЗМЕНЯЕТ состояние объекта
        //класса Post, поэтому он должен быть частью класса Post,
        //который является частью слоя модели
        this.content = content;
    }

    public void setStatus(PostStatus status) {
        this.postStatus = status;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }
}
