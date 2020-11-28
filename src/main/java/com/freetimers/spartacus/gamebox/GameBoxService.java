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
    private final ReactionCardsRepo reactionCardsRepo;
    private final SchemeCardsRepo schemeCardsRepo;
    private EquipmentCardsRepo equipmentCardsRepo;
    private final GladiatorCardsRepo gladiatorCardsRepo;
    private final SlaveCardsRepo slaveCardsRepo;
    private final Logger logger;
    private final DominusBoardRepo dominusBoardRepo;


    @Autowired
    public GameBoxService(Logger logger, ReactionCardsRepo reactionCardsRepo, SchemeCardsRepo schemeCardsRepo, EquipmentCardsRepo equipmentCardsRepo,
                          GladiatorCardsRepo gladiatorCardsRepo, SlaveCardsRepo slaveCardsRepo, DominusBoardRepo dominusBoardRepo) {
        this.logger = logger;
        this.reactionCardsRepo = reactionCardsRepo;
        this.schemeCardsRepo = schemeCardsRepo;
        this.equipmentCardsRepo = equipmentCardsRepo;
        this.gladiatorCardsRepo = gladiatorCardsRepo;
        this.slaveCardsRepo = slaveCardsRepo;
        this.dominusBoardRepo = dominusBoardRepo;
    }

    @PostConstruct
    public void setUp() {
        cleanUpRepos(); //todo, remove after all cards are implemented
        if (schemeCardsRepo.findAll().size() != 100) {

            /////////////////////////////Dominus/////////////////////////////
            //todo use keys instead of localized strings
//            DominusBoard Batiatus = DominusBoard.of("BATIATUS", "Exhibition match: Exhaust 2 Gladiators " +
//                    "to gain 2 gold." + "Fodder for the primus: Discard 3 Gladiators to gain +1 Influence.", 10,
//                    3, 1, 2);
//            dominusBoardRepo.save(Batiatus);
//
//            DominusBoard Glaber = DominusBoard.of("GLABER", "Legionnaire patrol: Exhaust 3 Guards, draw" +
//                            "1 Intrigue card." + "Dispatch to Rome: Discard 3 Guards to gain + 1 Influence.", 10,
//                    1, 2, 3);
//            dominusBoardRepo.save(Glaber);
//
//            DominusBoard Tullius = DominusBoard.of("TULLIUS", "Duplicitous dealings: Exhaust 3 Slaves," +
//                            "discard up to 3 cards, replace with new cards." + "To the mines: Discard 3 Slaves to gain +1" +
//                            "Influence.", 9,2, 3, 1);
//            dominusBoardRepo.save(Tullius);
//
//            DominusBoard Solonius = DominusBoard.of("SOLONIUS", "Bribes and pandering: Pay X gold to reduce" +
//                            "any Scheme`s required Influence by X." + "A finger in every  pie: Discard 1 Gladiator, 1 Slave " +
//                            "and 1 Guard to gain +1 Influence", 12,2, 2, 1);
//            dominusBoardRepo.save(Solonius);

            /////////////////////////////SCHEME/////////////////////////////
//todo add action
//todo use keys instead of localized strings
//            SchemeCard testOfTheBrotherhood = SchemeCard.of("Test of the brotherhood.", "Target Dominus gains " +
//                    "+1 influence for every 2 gladiators they exhaust.", 2, 1);
//            schemeRepo.save(testOfTheBrotherhood);
//            SchemeCard setHandToPurpose = SchemeCard.of("card.schemeCard.setHandToPurpose.title", "card.schemeCard.setHandToPurpose.description"
//                    , 2, 4);
//            schemeRepo.save(setHandToPurpose);
//            SchemeCard epicSpecctacle = SchemeCard.of("Epic spectacle.", "+2 influence to target Dominus with" +
//                    " at least 5 ready Gladiators.", 2, 0);
//            schemeRepo.save(epicSpecctacle);
//            SchemeCard partyFavors = SchemeCard.of("Party favors", "Target Dominus may discard", 1, 4);
//            schemeRepo.save(partyFavors);
        }
        if (reactionCardsRepo.findAll().size() != 100) {
            /////////////////////////////REACTION/////////////////////////////
            ReactionCard supportFromRome = ReactionCard.of("card.reactionCard.supportFromRome.title",
                    "card.reactionCard.supportFromRome.description", 3, 8,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, Collections.singletonList(FailSchemeAction.getinstance()));
            reactionCardsRepo.save(supportFromRome);

            ReactionCard riggingTheMatch = ReactionCard.of("card.reactionCard.riggingTheMatch.title",
                    "card.reactionCard.riggingTheMatch.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, Collections.singletonList(SwitchGladiatorAction.getInstance()));
            reactionCardsRepo.save(riggingTheMatch);

            ReactionCard aShamefulLudus = ReactionCard.of("card.reactionCard.aShamefulLudus.title",
                    "card.reactionCard.aShamefulLudus.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, Collections.singletonList(DecreaseInInfluenceAction.getInstance()));
            reactionCardsRepo.save(aShamefulLudus);
        }
        if (gladiatorCardsRepo.findAll().size() != 100) {
            /////////////////////////////GLADIATOR/////////////////////////////
            GladiatorCard syrianWarrior = GladiatorCard.of("card.gladiatorCard.syrianWarrior.title",
                    "card.gladiatorCard.syrianWarrior.description",
                    2, 2, 2, 3,  Condition.READY);
            gladiatorCardsRepo.save(syrianWarrior);

            GladiatorCard thracianWarrior = GladiatorCard.of("card.gladiatorCard.thracianWarrior.title",
                    "card.gladiatorCard.thracianWarrior.description",
                    2, 3, 2, 2, Condition.READY);
            gladiatorCardsRepo.save(thracianWarrior);

            GladiatorCard numidianWarrior = GladiatorCard.of("card.gladiatorCard.numidianWarrior.title",
                    "card.gladiatorCard.numidianWarrior.description",
                    2, 3, 1, 3, Condition.READY);
            gladiatorCardsRepo.save(numidianWarrior);
        }
        if (slaveCardsRepo.findAll().size() != 100) {
            /////////////////////////////SLAVE/////////////////////////////
//todo add action
//            SlaveCard debtor = SlaveCard.of("card.slaveCard.debtor.title", "card.slaveCard.debtor.description",
//                    2, 1, 1, 1, Condition.READY);
//            slaveRepo.save(debtor);
//            SlaveCard attendant = SlaveCard.of("card.slaveCard.attendant.title", "card.slaveCard.attendant.description",
//                    2, 1, 1, 1, Condition.READY);
//            slaveRepo.save(attendant);
//            SlaveCard convict = SlaveCard.of("card.slaveCard.convict.title", "card.slaveCard.convict.description",
//                    2, 1, 1, 1, Condition.READY);
//            slaveRepo.save(convict);
        }
        if (equipmentCardsRepo.findAll().size() != 100) {
            /////////////////////////////EQUIP/////////////////////////////
            EquipmentCard shield = EquipmentCard.of("card.equipmentCard.shield.title", "card.equipmentCard.armor",
                    1, EquipType.ARMOR, Condition.READY);
            equipmentCardsRepo.save(shield);
            EquipmentCard ax = EquipmentCard.of("card.equipmentCard.ax.title", "card.equipmentCard.weapon.title",
                    1, EquipType.WEAPON, Condition.READY);
            equipmentCardsRepo.save(ax);
            EquipmentCard net = EquipmentCard.of("card.equipmentCard.net.title", "card.equipmentCard.special.title",
                    1, EquipType.SPECIAL, Condition.READY);
            equipmentCardsRepo.save(net);
        }

    }

    public void cleanUpRepos(){
        this.reactionCardsRepo.deleteAll();
        this.gladiatorCardsRepo.deleteAll();
        this.schemeCardsRepo.deleteAll();
        this.slaveCardsRepo.deleteAll();
        this.equipmentCardsRepo.deleteAll();
        this.dominusBoardRepo.deleteAll();
    }
}
