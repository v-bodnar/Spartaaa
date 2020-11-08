package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.repository.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


//@Service
public class GameBoxService {
    private final ReactionRepo reactionRepo;
    private final SchemeRepo schemeRepo;
    private EquipmentRepo equipmentRepo;
    private final GladiatorRepo gladiatorRepo;
    private final SlaveRepo slaveRepo;
    private final Logger logger;


    @Autowired
    public GameBoxService(Logger logger, ReactionRepo reactionRepo, SchemeRepo schemeRepo, EquipmentRepo euqipmentsRepo, GladiatorRepo gladiatorRepo, SlaveRepo slaveRepo) {
        this.logger = logger;
        this.reactionRepo = reactionRepo;
        this.schemeRepo = schemeRepo;
        this.equipmentRepo = equipmentRepo;
        this.gladiatorRepo = gladiatorRepo;
        this.slaveRepo = slaveRepo;
    }

    @PostConstruct
    public void setUp() {
        if (schemeRepo.findAll().size() != 100) {
            /////////////////////////////SCHEME/////////////////////////////
            Scheme testOfTheBrotherhood = Scheme.of("Test of the brotherhood.", "Target Dominus gains " +
                    "+1 influence for every 2 gladiators they exhaust.", 2, 1);
            schemeRepo.save(testOfTheBrotherhood);
            Scheme setHandToPurpose = Scheme.of("card.scheme.setHandToPurpose.title", "card.scheme.setHandToPurpose.description"
                    , 2, 4);
            schemeRepo.save(setHandToPurpose);
            Scheme epicSpecctacle = Scheme.of("Epic spectacle.", "+2 influence to target Dominus with" +
                    " at least 5 ready Gladiators.", 2, 0);
            schemeRepo.save(epicSpecctacle);
            Scheme partyFavors = Scheme.of("Party favors", "Target Dominus may discard", 1, 4);
            schemeRepo.save(partyFavors);
        }
        if (reactionRepo.findAll().size() != 100) {
            /////////////////////////////REACTION/////////////////////////////
            Reaction supportFromRome = Reaction.of("card.reaction.supportFromRome.title",
                    "card.reaction.supportFromRome.description", 3, 8,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL);
            reactionRepo.save(supportFromRome);
            getTitle(supportFromRome);
            Reaction riggingTheMatch = Reaction.of("card.reaction.riggingTheMatch.title",
                    "card.reaction.riggingTheMatch.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL);
            reactionRepo.save(riggingTheMatch);
            getTitle(riggingTheMatch);
            Reaction aShamefulLudus = Reaction.of("card.reaction.aShamefulLudus.title",
                    "card.reaction.aShamefulLudus.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL);
            reactionRepo.save(aShamefulLudus);
            getTitle(aShamefulLudus);
        }
        if (gladiatorRepo.findAll().size() != 100) {
            /////////////////////////////GLADIATOR/////////////////////////////
            Gladiator syrianWarrior = Gladiator.of("card.gladiator.syrianWarrior.title",
                    "card.gladiator.syrianWarrior.description",
                    2, 2, 2, 3);
            gladiatorRepo.save(syrianWarrior);
            getTitle(syrianWarrior);
            Gladiator thracianWarrior = Gladiator.of("card.gladiator.thracianWarrior.title",
                    "card.gladiator.thracianWarrior.description",
                    2, 3, 2, 2);
            gladiatorRepo.save(thracianWarrior);
            getTitle(thracianWarrior);
            Gladiator numidianWarrior = Gladiator.of("card.gladiator.numidianWarrior.title",
                    "card.gladiator.numidianWarrior.description",
                    2, 3, 1, 3);
            gladiatorRepo.save(numidianWarrior);
            getTitle(numidianWarrior);
        }
        if (slaveRepo.findAll().size() != 100) {
            /////////////////////////////SLAVE/////////////////////////////
            Slave debtor = Slave.of("card.slave.debtor.title", "card.slave.debtor.description",
                    2, 1, 1, 1);
            slaveRepo.save(debtor);
            getTitle(debtor);
            Slave attendant = Slave.of("card.slave.attendant.title", "card.slave.attendant.description",
                    2, 1, 1, 1);
            slaveRepo.save(attendant);
            getTitle(attendant);
            Slave convict = Slave.of("card.slave.convict.title", "card.slave.convict.description",
                    2, 1, 1, 1);
            slaveRepo.save(convict);
            getTitle(convict);
        }
        if (equipmentRepo.findAll().size() != 100) {
            /////////////////////////////EQUIP/////////////////////////////
            Equip shield = Equip.of("card.equip.shield.title", "card.equip.armor", 1, EquipType.ARMOR);
            equipmentRepo.save(shield);
            getTitle(shield);
            Equip ax = Equip.of("card.equip.ax.title", "card.equip.weapon.title", 1, EquipType.WEAPON);
            equipmentRepo.save(ax);
            getTitle(ax);
            Equip net = Equip.of("card.equip.net.title", "card.equip.special.title", 1, EquipType.SPECIAL);
            equipmentRepo.save(net);
            getTitle(net);
        }

    }

    public String getTitle(Card card) {
        logger.debug("get called");
        if (card == null)
            return "";
        return card.getTitleKey();
    }


}
