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

    private final InitRepository initRepository;

    public TestBean(InitRepository initRepository) {
        this.initRepository = initRepository;
    }

    @PostConstruct
    public void init() {
        initRepository.init();
    }
}