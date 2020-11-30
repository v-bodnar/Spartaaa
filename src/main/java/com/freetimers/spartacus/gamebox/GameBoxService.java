package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.gamebox.action.*;
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
            DominusBoard Batiatus = DominusBoard.of("card.dominusBoard.batiatus.title",
                    "card.dominusBoard.batiatus.description", 10,
                    3, 1, 2);
            dominusBoardRepo.save(Batiatus);

            DominusBoard Glaber = DominusBoard.of("card.dominusBoard.glaber.title",
                    "card.dominusBoard.glaber.description", 10,
                    1, 2, 3);
            dominusBoardRepo.save(Glaber);

            DominusBoard Tullius = DominusBoard.of("card.dominusBoard.tullius.title",
                    "card.dominusBoard.tullius.description",
                    9,2, 3, 1);
            dominusBoardRepo.save(Tullius);

            DominusBoard Solonius = DominusBoard.of("card.dominusBoard.solonius.title",
                    "card.dominusBoard.solonius.description",
                    12,2, 2, 1);
            dominusBoardRepo.save(Solonius);

            /////////////////////////////SCHEME/////////////////////////////
            SchemeCard testOfTheBrotherhood = SchemeCard.of("card.schemeCard.testOfTheBrotherhood.title",
                    "card.schemeCard.testOfTheBrotherhood.description", 2, 1,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    Collections.singletonList(InfluenceForExhaustGladAction.getinstance()));
            schemeCardsRepo.save(testOfTheBrotherhood);

            SchemeCard setHandToPurpose = SchemeCard.of("card.schemeCard.setHandToPurpose.title",
                    "card.schemeCard.setHandToPurpose.description", 2, 4,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    Collections.singletonList(InfluenceForPeoplesAction.getInstance()));
            schemeCardsRepo.save(setHandToPurpose);

            SchemeCard epicSpectacle = SchemeCard.of("card.schemeCard.epicSpectacle.title",
                    "card.schemeCard.epicSpectacle.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    Collections.singletonList(InfluenceForReadyGladAction.getInstance()));
            schemeCardsRepo.save(epicSpectacle);

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
                    2, 2, 2, 3, true, Collections.singletonList(StartingGladiators.getInstance()));
            gladiatorCardsRepo.save(syrianWarrior);

            GladiatorCard thracianWarrior = GladiatorCard.of("card.gladiatorCard.thracianWarrior.title",
                    "card.gladiatorCard.thracianWarrior.description",
                    2, 3, 2, 2, true, Collections.singletonList(StartingGladiators.getInstance()));
            gladiatorCardsRepo.save(thracianWarrior);

            GladiatorCard numidianWarrior = GladiatorCard.of("card.gladiatorCard.numidianWarrior.title",
                    "card.gladiatorCard.numidianWarrior.description",
                    2, 3, 1, 3, true,  Collections.singletonList(StartingGladiators.getInstance()));
            gladiatorCardsRepo.save(numidianWarrior);
        }
        if (slaveCardsRepo.findAll().size() != 100) {
            /////////////////////////////SLAVE/////////////////////////////
            SlaveCard debtor = SlaveCard.of("card.slaveCard.debtor.title", "card.slaveCard.debtor.description",
                    2, 1, 1, 1, true, Collections.singletonList(StartingSlave.getInstance()));
            slaveCardsRepo.save(debtor);

            SlaveCard attendant = SlaveCard.of("card.slaveCard.attendant.title", "card.slaveCard.attendant.description",
                    2, 1, 1, 1, true, Collections.singletonList(StartingSlave.getInstance()));
            slaveCardsRepo.save(attendant);

            SlaveCard convict = SlaveCard.of("card.slaveCard.convict.title", "card.slaveCard.convict.description",
                    2, 1, 1, 1, true,Collections.singletonList(StartingSlave.getInstance()));
            slaveCardsRepo.save(convict);
        }
        if (equipmentCardsRepo.findAll().size() != 100) {
            /////////////////////////////EQUIP/////////////////////////////
            EquipmentCard shield = EquipmentCard.of("card.equipmentCard.armor.shield.title",
                    "card.equipmentCard.armor.shield.description",1, EquipType.ARMOR);
            equipmentCardsRepo.save(shield);

            EquipmentCard axe = EquipmentCard.of("card.equipmentCard.axe.weapon.title",
                    "card.equipmentCard.axe.weapon.description",1, EquipType.WEAPON);
            equipmentCardsRepo.save(axe);

            EquipmentCard net = EquipmentCard.of("card.equipmentCard.net.special.title",
                    "card.equipmentCard.net.special.description",1, EquipType.SPECIAL);
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
