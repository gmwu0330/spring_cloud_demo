package demo.repository.sql.impl;

import demo.repository.sql.GoodsNativeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsNativeRepositoryImpl implements GoodsNativeRepository {

    @PersistenceContext(unitName = "entityManagerFactoryDemo")
    private EntityManager entityManager;

}
