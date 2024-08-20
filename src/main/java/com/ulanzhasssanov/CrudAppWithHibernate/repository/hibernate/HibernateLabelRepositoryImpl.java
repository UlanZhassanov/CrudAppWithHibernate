package com.ulanzhasssanov.CrudAppWithHibernate.repository.hibernate;

import com.ulanzhasssanov.CrudAppWithHibernate.enums.Status;
import com.ulanzhasssanov.CrudAppWithHibernate.model.Label;
import com.ulanzhasssanov.CrudAppWithHibernate.repository.LabelRepository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class HibernateLabelRepositoryImpl implements LabelRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pubmentorPostsPU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public Label getById(Integer id) {
        return entityManager.find(Label.class, id);
    }


    @Override
    public List<Label> getAll() {
        return entityManager. createQuery("FROM Label WHERE status <> 'DELETED'", Label.class).getResultList();
    }

    @Override
    public Label save(Label label) {
        label.setStatus(Status.ACTIVE);
        entityManager.getTransaction().begin();
        entityManager.persist(label);
        entityManager.getTransaction().commit();

        return entityManager.find(Label.class, label.getId());
    }

    @Override
    public Label update(Label label) {
        entityManager.getTransaction().begin();
        entityManager.merge(label);
        entityManager.getTransaction().commit();

        return entityManager.find(Label.class, label.getId());
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.getTransaction().begin();
        Label label = getById(id);

        if (label != null){
            label.setStatus(Status.DELETED);
            entityManager.merge(label);
        } else {
            System.out.println("Label with ID "+ id + " not found.");
        }

        entityManager.getTransaction().commit();
    }

}
