package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.Slave;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SlaveRepo extends MongoRepository<Slave, String> {
    Optional<Slave> findFirstByTitle(String title);
}
