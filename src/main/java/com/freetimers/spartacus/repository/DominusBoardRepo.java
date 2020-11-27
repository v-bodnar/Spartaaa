package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.DominusBoard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DominusBoardRepo extends MongoRepository<DominusBoard, String> {
}
