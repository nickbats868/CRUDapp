package org.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Post {
    private Integer id;
    private PostStatus postStatus;
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labels;




    public Post(List<Label> labels) {
        this.postStatus = PostStatus.ACTIVE;
        this.created = new Date();
        this.labels = labels;
    }

    public void addContent(String content) {
        this.content = content;
    }

    public void setStatus(PostStatus status) {
        this.postStatus = status;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
