package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.aop.Translate;
import com.freetimers.spartacus.repository.*;
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


    @Autowired
    public GameBoxService(ReactionRepo reactionRepo, SchemeRepo schemeRepo, EuqipmentsRepo euqipmentsRepo, GladiatorsRepo gladiatorsRepo, SlavesRepo slavesRepo) {
        this.reactionRepo = reactionRepo;
        this.schemeRepo = schemeRepo;
        this.euqipmentsRepo = euqipmentsRepo;
        this.gladiatorsRepo = gladiatorsRepo;
        this.slavesRepo = slavesRepo;
    }

    @PostConstruct
    public void setUp() {
        if (schemeRepo.findAll().size() != 100) {
            Scheme testOfTheBrotherhood = new Scheme(1, 2, "Test of the brotherhood", "Target Dominus gains +1 influence foe every 2 gladiators they exhaust");
            schemeRepo.save(testOfTheBrotherhood);
            Scheme setHandToPurpose = new Scheme(4, 2, "card.setHandToPurpose.title", "Target Dominus may exhaust any 3 of their slaves, gladiators or guards to gain 1 influence");
            schemeRepo.save(setHandToPurpose);
            Scheme epicSpecctacle = new Scheme(0, 2, "Epic spectacle", "+2 influence to target Dominus with at least 5 ready Gladiators");
            schemeRepo.save(epicSpecctacle);
            //Scheme partyFavors = new Scheme(4,1, "Party favors", "Target Dominus may discard");
            Gladiator syrianWarrior = new Gladiator(2, "card.syrianWarrior.title", "card.startingGladiator");
            gladiatorsRepo.save(syrianWarrior);
            getTitle(syrianWarrior);

        }

    }
    @Translate
    public String getTitle(Card card){
        return card.getTitle();
    }


}
