package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.gamebox.action.DecreaseInInfluenceAction;
import com.freetimers.spartacus.gamebox.action.FailSchemeAction;
import com.freetimers.spartacus.gamebox.action.SwitchGladiatorAction;
import com.freetimers.spartacus.repository.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;


@Service
public class GameBoxService {
    private final ReactionRepo reactionRepo;
    private final SchemeRepo schemeRepo;
    private EquipmentRepo equipmentRepo;
    private final GladiatorRepo gladiatorRepo;
    private final SlaveRepo slaveRepo;
    private final Logger logger;
    private final DominusBoardRepo dominusBoardRepo;


    @Autowired
    public GameBoxService(Logger logger, ReactionRepo reactionRepo, SchemeRepo schemeRepo, EquipmentRepo equipmentRepo,
                          GladiatorRepo gladiatorRepo, SlaveRepo slaveRepo, DominusBoardRepo dominusBoardRepo) {
        this.logger = logger;
        this.reactionRepo = reactionRepo;
        this.schemeRepo = schemeRepo;
        this.equipmentRepo = equipmentRepo;
        this.gladiatorRepo = gladiatorRepo;
        this.slaveRepo = slaveRepo;
        this.dominusBoardRepo = dominusBoardRepo;
    }

    @PostConstruct
    public void setUp() {
        cleanUpRepos(); //todo, remove after all cards are implemented
        if (schemeRepo.findAll().size() != 100) {

            /////////////////////////////Dominus/////////////////////////////
            DominusBoard Batiatus = DominusBoard.of("BATIATUS", "Exhibition match: Exhaust 2 Gladiators " +
                    "to gain 2 gold." + "Fodder for the primus: Discard 3 Gladiators to gain +1 Influence.", 10,
                    3, 1, 2);
            dominusBoardRepo.save(Batiatus);

            DominusBoard Glaber = DominusBoard.of("GLABER", "Legionnaire patrol: Exhaust 3 Guards, draw" +
                            "1 Intrigue card." + "Dispatch to Rome: Discard 3 Guards to gain + 1 Influence.", 10,
                    1, 2, 3);
            dominusBoardRepo.save(Glaber);

            DominusBoard Tullius = DominusBoard.of("TULLIUS", "Duplicitous dealings: Exhaust 3 Slaves," +
                            "discard up to 3 cards, replace with new cards." + "To the mines: Discard 3 Slaves to gain +1" +
                            "Influence.", 9,2, 3, 1);
            dominusBoardRepo.save(Tullius);

            DominusBoard Solonius = DominusBoard.of("SOLONIUS", "Bribes and pandering: Pay X gold to reduce" +
                            "any Scheme`s required Influence by X." + "A finger in every  pie: Discard 1 Gladiator, 1 Slave " +
                            "and 1 Guard to gain +1 Influence", 12,2, 2, 1);
            dominusBoardRepo.save(Solonius);

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
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, Collections.singletonList(FailSchemeAction.getINSTANCE()));
            reactionRepo.save(supportFromRome);
            getTitle(supportFromRome);

            Reaction riggingTheMatch = Reaction.of("card.reaction.riggingTheMatch.title",
                    "card.reaction.riggingTheMatch.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, Collections.singletonList(SwitchGladiatorAction.getInstance()));
            reactionRepo.save(riggingTheMatch);
            getTitle(riggingTheMatch);

            Reaction aShamefulLudus = Reaction.of("card.reaction.aShamefulLudus.title",
                    "card.reaction.aShamefulLudus.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, Collections.singletonList(DecreaseInInfluenceAction.getINSTANCE()));
            reactionRepo.save(aShamefulLudus);
            getTitle(aShamefulLudus);
        }
        if (gladiatorRepo.findAll().size() != 100) {
            /////////////////////////////GLADIATOR/////////////////////////////
            Gladiator syrianWarrior = Gladiator.of("card.gladiator.syrianWarrior.title",
                    "card.gladiator.syrianWarrior.description",
                    2, 2, 2, 3,  Condition.READY);
            gladiatorRepo.save(syrianWarrior);
            getTitle(syrianWarrior);

            Gladiator thracianWarrior = Gladiator.of("card.gladiator.thracianWarrior.title",
                    "card.gladiator.thracianWarrior.description",
                    2, 3, 2, 2, Condition.READY);
            gladiatorRepo.save(thracianWarrior);
            getTitle(thracianWarrior);

            Gladiator numidianWarrior = Gladiator.of("card.gladiator.numidianWarrior.title",
                    "card.gladiator.numidianWarrior.description",
                    2, 3, 1, 3, Condition.READY);
            gladiatorRepo.save(numidianWarrior);
            getTitle(numidianWarrior);
        }
        if (slaveRepo.findAll().size() != 100) {
            /////////////////////////////SLAVE/////////////////////////////
            Slave debtor = Slave.of("card.slave.debtor.title", "card.slave.debtor.description",
                    2, 1, 1, 1, Condition.READY);
            slaveRepo.save(debtor);
            getTitle(debtor);
            Slave attendant = Slave.of("card.slave.attendant.title", "card.slave.attendant.description",
                    2, 1, 1, 1, Condition.READY);
            slaveRepo.save(attendant);
            getTitle(attendant);
            Slave convict = Slave.of("card.slave.convict.title", "card.slave.convict.description",
                    2, 1, 1, 1, Condition.READY);
            slaveRepo.save(convict);
            getTitle(convict);
        }
        if (equipmentRepo.findAll().size() != 100) {
            /////////////////////////////EQUIP/////////////////////////////
            EquipmentCard shield = EquipmentCard.of("card.equip.shield.title", "card.equip.armor",
                    1, EquipType.ARMOR, Condition.READY);
            equipmentRepo.save(shield);
            getTitle(shield);
            EquipmentCard ax = EquipmentCard.of("card.equip.ax.title", "card.equip.weapon.title",
                    1, EquipType.WEAPON, Condition.READY);
            equipmentRepo.save(ax);
            getTitle(ax);
            EquipmentCard net = EquipmentCard.of("card.equip.net.title", "card.equip.special.title",
                    1, EquipType.SPECIAL, Condition.READY);
            equipmentRepo.save(net);
            getTitle(net);
        }

    }

    public void cleanUpRepos(){
        this.reactionRepo.deleteAll();
        this.gladiatorRepo.deleteAll();
        this.schemeRepo.deleteAll();
        this.slaveRepo.deleteAll();
        this.equipmentRepo.deleteAll();
        this.dominusBoardRepo.deleteAll();
    }

    public String getTitle(Card card) {
        logger.debug("get called");
        if (card == null)
            return "";
        return card.getTitleKey();
    }


}
