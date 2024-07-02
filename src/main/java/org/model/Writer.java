package org.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//TODO:
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Writer implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(Writer.class);

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
        logger.info("Создан новый Writer: {} {}", firstName, lastName);
    }

    public Writer() {
        logger.info("New empty Writer has been created");
    }


    public Status getStatus() {
        return writerStatus;
    }

    public void setStatus(Status status) {
        this.writerStatus = status;
        logger.debug("Статус Writer изменён на: {} ", status);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        logger.debug("Установлен ID Writer: {}", id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        logger.debug("Изменено имя Writer: {} ", firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        logger.debug("Изменена фамилия Writer: {} ",lastName);
    }

    public List<Post> getPosts() {
        return posts;
    }


    private void setPosts(List<Post> posts) {
        this.posts = posts;
        logger.debug("Изменены посты Writer");
    }
}
