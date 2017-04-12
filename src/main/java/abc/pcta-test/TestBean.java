package abc.pcta_test;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ops4j.pax.cdi.api.OsgiServiceProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Transactional
@OsgiServiceProvider(classes = TestService.class)
public class TestBean implements TestService {
    
    private static final Logger LOG = LoggerFactory.getLogger(TestBean.class);
    
    @PersistenceContext(unitName="pcta-test")
    private EntityManager em;
    
    @PostConstruct
    public void init() {
        em.persist(new TestEntity("Smasher"));
        List l = em.createQuery("select T from TestEntity").getResultList();
        for (Object o : l) {
            LOG.info("Obtained " + ((TestEntity)o).toString());
        }
    }
}