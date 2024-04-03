package be.thomasmore.gunranch.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AuthorityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertRecord(String username, String authority) {
        entityManager.createNativeQuery("INSERT INTO authorities (username, authority) VALUES (?,?)")
                .setParameter(1, username)
                .setParameter(2, authority)
                .executeUpdate();
    }
}

