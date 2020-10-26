package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.repository.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class GameBoxService {
    private final ReactionRepo reactionRepo;
    private final SchemeRepo schemeRepo;
    private final EuqipmentsRepo euqipmentsRepo;
    private final GladiatorsRepo gladiatorsRepo;
    private final SlavesRepo slavesRepo;
    private final Logger logger;


    @Autowired
    public GameBoxService(Logger logger, ReactionRepo reactionRepo, SchemeRepo schemeRepo, EuqipmentsRepo euqipmentsRepo, GladiatorsRepo gladiatorsRepo, SlavesRepo slavesRepo) {
        this.logger = logger;
        this.reactionRepo = reactionRepo;
        this.schemeRepo = schemeRepo;
        this.euqipmentsRepo = euqipmentsRepo;
        this.gladiatorsRepo = gladiatorsRepo;
        this.slavesRepo = slavesRepo;
    }

    @PostConstruct
    public void setUp() {
        if (schemeRepo.findAll().size() != 100) {
            Scheme testOfTheBrotherhood = new Scheme(null,1, 2, "Test of the brotherhood", "Target Dominus gains +1 influence foe every 2 gladiators they exhaust");
            schemeRepo.save(testOfTheBrotherhood);
            Scheme setHandToPurpose = new Scheme(null,4, 2, "card.setHandToPurpose.title", "Target Dominus may exhaust any 3 of their slaves, gladiators or guards to gain 1 influence");
            schemeRepo.save(setHandToPurpose);
            Scheme epicSpecctacle = new Scheme(null,0, 2, "Epic spectacle", "+2 influence to target Dominus with at least 5 ready Gladiators");
            schemeRepo.save(epicSpecctacle);
            //Scheme partyFavors = new Scheme(4,1, "Party favors", "Target Dominus may discard");
            Gladiator syrianWarrior = new Gladiator(null,2, "card.syrianWarrior.title", "card.startingGladiator");
            gladiatorsRepo.save(syrianWarrior);
            getTitle(syrianWarrior);

        }

    }

    public String getTitle(Card card) {
        logger.debug("get called");
        if (card == null)
            return "";
        return card.getTitle();
    }


}
