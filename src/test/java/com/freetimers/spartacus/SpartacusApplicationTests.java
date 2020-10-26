package com.freetimers.spartacus;

import com.freetimers.spartacus.gamebox.Gladiator;
import com.freetimers.spartacus.gamebox.Scheme;
import com.freetimers.spartacus.model.TestEntity;
import com.freetimers.spartacus.repository.GladiatorsRepo;
import com.freetimers.spartacus.repository.SchemeRepo;
import com.freetimers.spartacus.repository.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestExecution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
        "spring.mongodb.embedded.storage.databaseDir=${user.home}/Freetimers/spartacus/testDB"
})
class SpartacusApplicationTests {
    private static final Logger LOG = LoggerFactory.getLogger(SpartacusApplicationTests.class);

    @Autowired
    private TestRepository repository;

    @Autowired
    private GladiatorsRepo gladiatorsRepo;

    @Autowired
    private SchemeRepo schemeRepo;

    @Value("spring.mongodb.embedded.storage.databaseDir")
    private String testDbPath;

    @BeforeEach
    public void cleanUpDb() {
        repository.deleteAll();
        schemeRepo.deleteAll();
        gladiatorsRepo.deleteAll();
    }

    @AfterTestExecution
    public void cleanUp() throws IOException {
        LOG.info("Removing test db from {}", testDbPath);
        Path testDb = Paths.get(testDbPath);
        if (Files.deleteIfExists(testDb)) {
            LOG.info("Clean up success!");
        } else {
            LOG.info("Clean up failure!");
        }
    }

    @Test
    void mongoTest() {
        //given
        TestEntity testEntity1 = TestEntity.of();
        TestEntity testEntity2 = TestEntity.of();
        TestEntity testEntity3 = TestEntity.of();

        Gladiator syrianWarrior = new Gladiator(null, 2, "card.syrianWarrior.title", "card.startingGladiator");
        gladiatorsRepo.save(syrianWarrior);

        Scheme testOfTheBrotherhood = new Scheme(null, 1, 2, "Test of the brotherhood", "Target Dominus gains +1 influence foe every 2 gladiators they exhaust");
        schemeRepo.save(testOfTheBrotherhood);

        // when
        repository.save(testEntity1);
        repository.save(testEntity2);
        repository.save(testEntity3);

        // then
        assertEquals(3, repository.findAll().size());
        assertEquals(1, gladiatorsRepo.findAll().size());
        assertEquals(1, schemeRepo.findAll().size());
    }


}
