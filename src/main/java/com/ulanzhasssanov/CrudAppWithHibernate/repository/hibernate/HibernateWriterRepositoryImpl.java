package com.ulanzhasssanov.CrudAppWithHibernate.repository.hibernate;

import com.ulanzhasssanov.CrudAppWithHibernate.enums.Status;
import com.ulanzhasssanov.CrudAppWithHibernate.model.Writer;
import com.ulanzhasssanov.CrudAppWithHibernate.repository.WriterRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class HibernateWriterRepositoryImpl implements WriterRepository {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pubmentorPostsPU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public Writer getById(Integer id) {
        return entityManager.find(Writer.class, id);
    }

    @Override
    public List<Writer> getAll() {
        return entityManager.createQuery("FROM Writer", Writer.class).getResultList();
    }

    @Override
    public Writer save(Writer writer) {
        writer.setStatus(Status.ACTIVE);
        entityManager.getTransaction().begin();
        entityManager.persist(writer);
        entityManager.getTransaction().commit();

        return getById(writer.getId());
    }

    @Override
    public Writer update(Writer writer) {
        entityManager.getTransaction().begin();
        entityManager.merge(writer);
        entityManager.getTransaction().commit();

        return getById(writer.getId());
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.getTransaction().begin();
        Writer writer = getById(id);

        if (writer != null){
            writer.setStatus(Status.DELETED);
            entityManager.merge(writer);
        } else {
            System.out.println("Post with ID "+ id + " not found.");
        }

        entityManager.getTransaction().commit();
    }

}
