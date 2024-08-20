package com.ulanzhasssanov.CrudAppWithHibernate.model;

import com.ulanzhasssanov.CrudAppWithHibernate.enums.Status;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "labels")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "labels", cascade = CascadeType.ALL)
    private List<Post> posts;

    public Label() {
    }

    public Label(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public Label(int id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Label(int id, String name, Status status, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
