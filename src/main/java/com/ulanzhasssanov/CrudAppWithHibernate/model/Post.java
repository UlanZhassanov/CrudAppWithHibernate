package com.ulanzhasssanov.CrudAppWithHibernate.model;

import com.ulanzhasssanov.CrudAppWithHibernate.enums.PostStatus;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "content")
    private String content;
    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "updated")
    private LocalDateTime  updated;
    @ManyToMany
    @JoinTable(
            name = "post_label",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id")
    )
    private List<Label> labels;
    @Column(name = "writer_id")
    private Integer writerId;
    @Column(name = "status")
    private PostStatus status;

    public Post() {
    }

    public Post(String content, List<Label> labels, Integer writerId) {
        this.content = content;
        this.labels = labels;
        this.writerId = writerId;
    }

    public Post(int id, String content, LocalDateTime  created, LocalDateTime  updated, List<Label> labels, Integer writerId, PostStatus status) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
        this.writerId = writerId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime  getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime  created) {
        this.created = created;
    }

    public LocalDateTime  getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime  updated) {
        this.updated = updated;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public Integer getWriterId() {
        return writerId;
    }

    public void setWriterId(Integer writerId) {
        this.writerId = writerId;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", labels=" + labels +
                ", writerId=" + writerId +
                ", status=" + status +
                '}';
    }
}
