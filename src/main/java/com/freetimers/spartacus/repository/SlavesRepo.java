package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.Slave;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlavesRepo extends MongoRepository<Slave, String> {
}
