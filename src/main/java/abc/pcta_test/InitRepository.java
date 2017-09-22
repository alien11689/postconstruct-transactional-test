package abc.pcta_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class InitRepository {
    private static final Logger LOG = LoggerFactory.getLogger(TestBean.class);

    @PersistenceContext(unitName="pcta-test")
    private EntityManager em;

    public void init(){
        em.persist(new abc.pcta_test.TestEntity("Smasher"));
        List l = em.createQuery("from TestEntity").getResultList();
        for (Object o : l) {
            LOG.info("Obtained " + ((abc.pcta_test.TestEntity)o).toString());
        }
    }
}