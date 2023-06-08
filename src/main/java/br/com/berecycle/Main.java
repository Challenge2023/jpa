package br.com.berecycle;


import br.com.berecycle.post.model.Post;
import br.com.berecycle.type.model.Type;
import br.com.berecycle.user.model.User;
import jakarta.persistence.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager entityManager = factory.createEntityManager();

        User user = new User();
        user.setName("Rafal Mafort");
        user.setCep("05468080");
        user.setPhone("11966552004");
        user.setEmail("rafael@gmail.com");
        user.setPass("123456");
        user.setActive(1);
        user.setType(Type.DOADOR);

        User user2 = new User();
        user2.setName("Lucas Amadeu");
        user2.setCep("09878676");
        user2.setPhone("11788665776");
        user2.setEmail("lucas@gmail.com");
        user2.setPass("77700");
        user2.setActive(1);
        user2.setCnh("1421421312");
        user2.setVehicle("HB20");
        user2.setType(Type.TRANSPORTADOR);

        Post post = new Post();
        post.setName("Cesta basica na Republica");
        post.setPhone("11966552004");
        post.setEmail("rafael@gmail.com");
        post.setLocal("Republica - SP");
        post.setDescription("Doando cesta basica na repuplica as 18h");
        post.setActive(1);
        post.setType(Type.DOADOR);

        user.addPost(post);

        entityManager.getTransaction().begin();

        entityManager.persist(post);
        entityManager.persist(user);
        entityManager.persist(user2);

        entityManager.getTransaction().commit();


        User userConsultado  = consultarUserPorId(entityManager, "1");
        System.out.println("User consultado pelo id: " + userConsultado);

        Type tipo = consultarTipoUsuarioPorEmail(entityManager, "rafael@gmail.com");
        System.out.println("Tipo do usuário: " + (tipo != null ? tipo.toString() : "N/A"));


        User alterarUser = atualizarUserPorId(entityManager, "1");
        System.out.println("Email atualizado " + alterarUser);

        deletarUserPorId(entityManager,"1");

        List<User> todosUsers = consultarTodosUsers(entityManager);
        System.out.println("Consultar todos os Users: " + todosUsers);

        entityManager.close();
    }

    public static User consultarUserPorId(EntityManager entityManager, String id) {
        return entityManager.find(User.class, id);
    }

    public static Type consultarTipoUsuarioPorEmail(EntityManager entityManager, String email) {
        TypedQuery<Type> query = entityManager.createQuery(
                "SELECT u.type FROM User u WHERE u.email = :email",
                Type.class
        );
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Nenhum usuário encontrado com o email: " + email);
            return null;
        }
    }


    public static User atualizarUserPorId(EntityManager entityManager, String id) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.id = :id",
                User.class
        );
        query.setParameter("id", id);
        User user = query.getSingleResult();

        if (user != null) {
            user.setEmail("rafaelmafort@gmail.com");
        }
        return user;
    }

    public static void deletarUserPorId(EntityManager entityManager, String id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
            System.out.println("User deletado: " + user.getName());
        } else {
            System.out.println("User não encontrado para o id: " + id);
        }
    }

    public static List<User> consultarTodosUsers(EntityManager entityManager) {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }
}
