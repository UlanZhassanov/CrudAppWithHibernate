package com.ulanzhasssanov.CrudAppWithHibernate.repository.hibernate;

import com.ulanzhasssanov.CrudAppWithHibernate.enums.PostStatus;
import com.ulanzhasssanov.CrudAppWithHibernate.enums.Status;
import com.ulanzhasssanov.CrudAppWithHibernate.model.Label;
import com.ulanzhasssanov.CrudAppWithHibernate.model.Post;
import com.ulanzhasssanov.CrudAppWithHibernate.repository.PostRepository;
import com.ulanzhasssanov.CrudAppWithHibernate.repository.jdbc.JdbcConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HibernatePostRepositoryImpl implements PostRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pubmentorPostsPU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public Post getById(Integer id) {
        return entityManager.find(Post.class, id);
    }

    @Override
    public List<Post> getAll() {
        return entityManager.createQuery("FROM Post WHERE status <> 'DELETED'", Post.class).getResultList();
    }

    @Override
    public Post save(Post post) {
        LocalDateTime localDateTime = LocalDateTime.now();
        post.setCreated(localDateTime);
        post.setUpdated(localDateTime);
        post.setStatus(PostStatus.ACTIVE);
        entityManager.getTransaction().begin();
        entityManager.persist(post);
        entityManager.getTransaction().commit();

        return getById(post.getId());
    }

    @Override
    public Post update(Post post) {
        LocalDateTime localDateTime = LocalDateTime.now();
        post.setUpdated(localDateTime);
        entityManager.getTransaction().begin();
        entityManager.merge(post);
        entityManager.getTransaction().commit();

        return getById(post.getId());
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.getTransaction().begin();
        Post post = getById(id);

        if (post != null){
            post.setStatus(PostStatus.DELETED);
            entityManager.merge(post);
        } else {
            System.out.println("Post with ID "+ id + " not found.");
        }

        entityManager.getTransaction().commit();
    }


}
