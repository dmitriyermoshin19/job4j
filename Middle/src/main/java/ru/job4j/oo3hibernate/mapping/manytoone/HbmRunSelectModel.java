package ru.job4j.oo3hibernate.mapping.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class HbmRunSelectModel {
    public static void main(String[] args) {
        List<Marka> list = new ArrayList<>();
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction(); /*
            Marka marka = Marka.of("LADA");
            session.persist(marka);
            Model one = Model.of("2101", marka);
            session.persist(one);
            list = session.createQuery(
                    "select distinct m from Marka m join fetch m.models"
            ).list();*/
            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        System.out.println(list.size());
        for (Marka marka : list) {
            System.out.println(marka.getName());
            for (Model model : marka.getModels()) {
                System.out.println("\t" + model.getName());
            }
        }
    }
}
