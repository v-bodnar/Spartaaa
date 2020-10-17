package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.Equip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EuqipmentsRepo extends MongoRepository<Equip, String> {
}
