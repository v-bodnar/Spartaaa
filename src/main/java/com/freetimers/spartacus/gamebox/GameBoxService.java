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
            Scheme testOfTheBrotherhood = Scheme.of("Test of the brotherhood","Target Dominus gains " +
                    "+1 influence foe every 2 gladiators they exhaust",2, 1);
            schemeRepo.save(testOfTheBrotherhood);
            Scheme setHandToPurpose = Scheme.of("card.scheme.setHandToPurpose.title","card.scheme.setHandToPurpose.description"
                    ,2,4);
            schemeRepo.save(setHandToPurpose);
            Scheme epicSpecctacle =Scheme.of("Epic spectacle","+2 influence to target Dominus with" +
                    " at least 5 ready Gladiators",2,0);
            schemeRepo.save(epicSpecctacle);
            Scheme partyFavors = Scheme.of("Party favors","Target Dominus may discard",1,4);
            Gladiator syrianWarrior = Gladiator.of( "card.gladiator.syrianWarrior.title", "card.gladiator.startingGladiator",
                    2, 2,2,3);
            gladiatorsRepo.save(syrianWarrior);
            getTitle(syrianWarrior);

        }

    }

    public String getTitle(Card card) {
        logger.debug("get called");
        if (card == null)
            return "";
        return card.getTitleKey();
    }


}
