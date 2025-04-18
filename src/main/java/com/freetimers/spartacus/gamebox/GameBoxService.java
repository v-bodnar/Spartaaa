package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.gamebox.action.ActionFactory;
import com.freetimers.spartacus.repository.*;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.freetimers.spartacus.gamebox.action.ActionFactory.*;


@Service
public class GameBoxService {
    private final ReactionCardsRepo reactionCardsRepo;
    private final SchemeCardsRepo schemeCardsRepo;
    private final EquipmentCardsRepo equipmentCardsRepo;
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
        addDominusCards();
        addReactionCards();
        addSchemeCards();
        addGladiatorCards();
        addSlaveCards();
        addEquipmentCards();
        printGameBoxContent();
    }

    private void addEquipmentCards() {
        /////////////////////////////EQUIP/////////////////////////////
        if (equipmentCardsRepo.findAll().size() != 100) {
            logger.info("Adding equipment cards");
            EquipmentCard shield = EquipmentCard.of("card.equipmentCard.shield.title",
                    "card.equipmentCard.shield.description", 1, EquipType.ARMOR);
            equipmentCardsRepo.save(shield);

            EquipmentCard axe = EquipmentCard.of("card.equipmentCard.axe.title",
                    "card.equipmentCard.axe.description", 1, EquipType.WEAPON);
            equipmentCardsRepo.save(axe);

            EquipmentCard net = EquipmentCard.of("card.equipmentCard.net.title",
                    "card.equipmentCard.net.description", 1, EquipType.SPECIAL);
            equipmentCardsRepo.save(net);
        }
    }

    private void addSlaveCards() {
        /////////////////////////////SLAVE/////////////////////////////
        if (slaveCardsRepo.findAll().size() != 19) {
            logger.info("Adding slave cards");
            SlaveCard debtor = SlaveCard.of("card.slaveCard.debtor.title", "card.slaveCard.debtor.description",
                    2, 1, 1, 1, true, Collections.emptyList());
            slaveCardsRepo.save(debtor);

            SlaveCard attendant = SlaveCard.of("card.slaveCard.attendant.title", "card.slaveCard.attendant.description",
                    2, 1, 1, 1, true, Collections.emptyList());
            slaveCardsRepo.save(attendant);

            SlaveCard attendant2 = SlaveCard.of("card.slaveCard.attendant.title", "card.slaveCard.attendant.description",
                    2, 1, 1, 1, true, Collections.emptyList());
            slaveCardsRepo.save(attendant2);

            SlaveCard deserter = SlaveCard.of("card.slaveCard.deserter.title", "card.slaveCard.deserter.description",
                    2, 1, 1, 1, true, Collections.emptyList());
            slaveCardsRepo.save(deserter);

            SlaveCard convict = SlaveCard.of("card.slaveCard.convict.title", "card.slaveCard.convict.description",
                    2, 1, 1, 1, true, Collections.emptyList());
            slaveCardsRepo.save(convict);

            SlaveCard cook = SlaveCard.of("card.slaveCard.cook.title", "card.slaveCard.cook.description",
                    2, 1, 1, 1, true, Collections.emptyList());
            slaveCardsRepo.save(cook);

            SlaveCard apothecary = SlaveCard.of("card.slaveCard.apothecary.title", "card.slaveCard.apothecary.description",
                    2, 1, 1, 1, false, List.of(ActionFactory.HEALER_REROLL));
            slaveCardsRepo.save(apothecary);

            SlaveCard isidus = SlaveCard.of("card.slaveCard.isidus.title", "card.slaveCard.isidus.description",
                    2, 1, 1, 1, false, List.of(ActionFactory.SPY_LOOK_RANDOM_CARD));
            slaveCardsRepo.save(isidus);

            SlaveCard medicus = SlaveCard.of("card.slaveCard.medicus.title", "card.slaveCard.medicus.description",
                    2, 1, 1, 1, false, List.of(ActionFactory.HEALER_REROLL));
            slaveCardsRepo.save(medicus);

            SlaveCard camila = SlaveCard.of("card.slaveCard.camila.title", "card.slaveCard.camila.description",
                    2, 1, 1, 1, false, List.of(ActionFactory.INFORMANT_LOOK_CARD));
            slaveCardsRepo.save(camila);

            SlaveCard maskedCourtesan = SlaveCard.of("card.slaveCard.maskedCourtesan.title", "card.slaveCard.maskedCourtesan.description",
                    2, 1, 1, 1, false, List.of(ActionFactory.SKILLED_GAIN_GOLD));
            slaveCardsRepo.save(maskedCourtesan);

            SlaveCard diona = SlaveCard.of("card.slaveCard.diona.title", "card.slaveCard.diona.description",
                    3, 1, 1, 1, false, List.of(ActionFactory.HANDMAID_DISCARD_AND_DRAW));
            slaveCardsRepo.save(diona);

            SlaveCard melitta = SlaveCard.of("card.slaveCard.melitta.title", "card.slaveCard.melitta.description",
                    3, 1, 1, 1, false, List.of(ActionFactory.SKILLED_GAIN_GOLD));
            slaveCardsRepo.save(melitta);

            SlaveCard raxos = SlaveCard.of("card.slaveCard.raxos.title", "card.slaveCard.raxos.description",
                    3, 2, 2, 1, false, List.of(ActionFactory.BODYGUARD_REROLL_GUARD_ATTEMPT));
            slaveCardsRepo.save(raxos);

            SlaveCard prisca = SlaveCard.of("card.slaveCard.prisca.title", "card.slaveCard.prisca.description",
                    3, 1, 1, 1, false, List.of(ActionFactory.SKILLED_GAIN_GOLD));
            slaveCardsRepo.save(prisca);

            SlaveCard aurelia = SlaveCard.of("card.slaveCard.aurelia.title", "card.slaveCard.aurelia.description",
                    2, 1, 1, 1, false, List.of(ActionFactory.HANDMAID_DISCARD_AND_DRAW));
            slaveCardsRepo.save(aurelia);

            SlaveCard mira = SlaveCard.of("card.slaveCard.mira.title", "card.slaveCard.mira.description",
                    3, 1, 1, 1, false, List.of(ActionFactory.EXCEPTIONAL_GAIN_GOLD));
            slaveCardsRepo.save(mira);

            SlaveCard pietros = SlaveCard.of("card.slaveCard.pietros.title", "card.slaveCard.pietros.description",
                    3, 1, 1, 1, false, List.of(ActionFactory.SKILLED_GAIN_GOLD));
            slaveCardsRepo.save(pietros);

            SlaveCard ashur = SlaveCard.of("card.slaveCard.ashur.title", "card.slaveCard.ashur.description",
                    2, 1, 1, 1, false, List.of(ActionFactory.INFORMANT_LOOK_CARD));
            slaveCardsRepo.save(ashur);

            SlaveCard marius = SlaveCard.of("card.slaveCard.marius.title", "card.slaveCard.marius.description",
                    3, 2, 2, 1, false, List.of(ActionFactory.BODYGUARD_REROLL_GUARD_ATTEMPT));
            slaveCardsRepo.save(marius);

            SlaveCard naevia = SlaveCard.of("card.slaveCard.naevia.title", "card.slaveCard.naevia.description",
                    4, 1, 1, 1, false, List.of(ActionFactory.CHASTE_TWO_SLAVES));
            slaveCardsRepo.save(naevia);



        }
    }

    private void addGladiatorCards() {
        /////////////////////////////GLADIATOR/////////////////////////////
        if (gladiatorCardsRepo.findAll().size() != 25) {
            logger.info("Adding gladiator cards");
            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.syrianWarrior.title",
                    "card.gladiatorCard.syrianWarrior.description",
                    2, 2, 2, 3, true, Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.thracianWarrior.title",
                    "card.gladiatorCard.thracianWarrior.description",
                    2, 3, 2, 2, true, Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.numidianWarrior.title",
                    "card.gladiatorCard.numidianWarrior.description",
                    2, 3, 1, 3, true, Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.gannicus.title",
                    "card.gladiatorCard.gannicus.description", 4, 3, 4, 5, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.pluto.title",
                    "card.gladiatorCard.pluto.description", 3, 2, 2, 3, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.varro.title",
                    "card.gladiatorCard.varro.description", 3, 4, 2, 4, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.onymaeus.title",
                    "card.gladiatorCard.onymaeus.description", 4, 3, 4, 4, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.theokoles.title",
                    "card.gladiatorCard.theokoles.description", 5, 5, 2, 4, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.batiatus.title",
                    "card.gladiatorCard.batiatus.description", 4, 3, 3, 4, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.doctore.title",
                    "card.gladiatorCard.doctore.description", 3, 4, 3, 3, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.barca.title",
                    "card.gladiatorCard.barca.description", 3, 3, 4, 4, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.vibro.title",
                    "card.gladiatorCard.vibro.description", 3, 3, 3, 4, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.kriza.title",
                    "card.gladiatorCard.kriza.description", 3, 2, 2, 4, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.spartacus.title",
                    "card.gladiatorCard.spartacus.description", 4, 2, 4, 5, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.pericles.title",
                    "card.gladiatorCard.pericles.description", 4, 3, 3, 4, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.gannicusTwo.title",
                    "card.gladiatorCard.gannicusTwo.description", 4, 1, 4, 4, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.marcellus.title",
                    "card.gladiatorCard.marcellus.description", 1, 1, 1, 2, false,
                    List.of(ActionFactory.SPY_LOOK_RANDOM_CARD)));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.cook.title",
                    "card.gladiatorCard.cook.description", 3, 2, 3, 2, true,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.celtWarrior.title",
                    "card.gladiatorCard.celtWarrior.description", 2, 3, 2, 2, true,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.thracianWarrior.title",
                    "card.gladiatorCard.thracianWarrior.description", 3, 2, 3, 2, true,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.ashur.title",
                    "card.gladiatorCard.ashur.description", 3, 3, 2, 3, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.ganeus.title",
                    "card.gladiatorCard.ganeus.description", 3, 3, 2, 3, false,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.syrianWarrior.title",
                    "card.gladiatorCard.syrianWarrior.description", 2, 2, 2, 3, true,
                    Collections.emptyList()));

            gladiatorCardsRepo.save(GladiatorCard.of("card.gladiatorCard.numidianWarrior.title",
                    "card.gladiatorCard.numidianWarrior.description", 2, 3, 1, 3, true,
                    Collections.emptyList()));

        }
    }

    private void addSchemeCards() {
        /////////////////////////////SCHEME/////////////////////////////
        if (schemeCardsRepo.findAll().size() != 61) {
            logger.info("Adding scheme cards");

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.collusion.title",
                    "card.schemeCard.collusion.description", 2, 1,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(GAIN_INFLUENCE, LOOSE_INFLUENCE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.blackMarketProfits.title",
                    "card.schemeCard.blackMarketProfits.description", 1, 7,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GAIN_5_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.blackMarketProfits.title",
                    "card.schemeCard.blackMarketProfits.description", 1, 7,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GAIN_5_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.blackMarketProfits.title",
                    "card.schemeCard.blackMarketProfits.description", 1, 7,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GAIN_5_GOLD)));


            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.inciteRebellion.title",
                    "card.schemeCard.inciteRebellion.description", 1, 5,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.DISCARD_READY_GLADIATOR)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.inciteRebellion.title",
                    "card.schemeCard.inciteRebellion.description", 1, 5,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.DISCARD_READY_GLADIATOR)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.insideInformation.title",
                    "card.schemeCard.insideInformation.description", 2, 6,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.DRAW_2_CARDS)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.insideInformation.title",
                    "card.schemeCard.insideInformation.description", 2, 6,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.DRAW_2_CARDS)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.insideInformation.title",
                    "card.schemeCard.insideInformation.description", 2, 6,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.DRAW_2_CARDS)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.aVisitorFromRome.title",
                    "card.schemeCard.aVisitorFromRome.description", 2, 6,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INFLUENCE_TO_TARGET)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.aVisitorFromRome.title",
                    "card.schemeCard.aVisitorFromRome.description", 2, 6,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INFLUENCE_TO_TARGET)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.blackmail.title",
                    "card.schemeCard.blackmail.description", 2, 4,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.DISCARD_READY_SLAVE, ActionFactory.INFLUENCE_TO_TARGET)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.blackmail.title",
                    "card.schemeCard.blackmail.description", 2, 4,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.DISCARD_READY_SLAVE, ActionFactory.INFLUENCE_TO_TARGET)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.collaboration.title",
                    "card.schemeCard.collaboration.description", 2, 12,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INFLUENCE_TO_TWO_PLAYERS)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.grandFeast.title",
                    "card.schemeCard.grandFeast.description", 2, 5,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.PAY_2_GOLD_TO_EVERYONE, ActionFactory.INFLUENCE_TO_TARGET)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.grandFeast.title",
                    "card.schemeCard.grandFeast.description", 2, 5,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.PAY_2_GOLD_TO_EVERYONE, ActionFactory.INFLUENCE_TO_TARGET)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.publicExhibition.title",
                    "card.schemeCard.publicExhibition.description", 2, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INFLUENCE_IF_READY_GLADIATORS, ActionFactory.LOOSE_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.publicExhibition.title",
                    "card.schemeCard.publicExhibition.description", 2, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INFLUENCE_IF_READY_GLADIATORS, ActionFactory.LOOSE_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.publicExhibition.title",
                    "card.schemeCard.publicExhibition.description", 2, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INFLUENCE_IF_READY_GLADIATORS, ActionFactory.LOOSE_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.laborContract.title",
                    "card.schemeCard.laborContract.description", 0, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GOLD_PER_READY_SLAVE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.laborContract.title",
                    "card.schemeCard.laborContract.description", 0, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GOLD_PER_READY_SLAVE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.laborContract.title",
                    "card.schemeCard.laborContract.description", 0, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GOLD_PER_READY_SLAVE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.laborContract.title",
                    "card.schemeCard.laborContract.description", 0, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GOLD_PER_READY_SLAVE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.laborContract.title",
                    "card.schemeCard.laborContract.description", 0, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GOLD_PER_READY_SLAVE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.wordToTheTaxCollector.title",
                    "card.schemeCard.wordToTheTaxCollector.description", 1, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.LOOSE_5_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.wordToTheTaxCollector.title",
                    "card.schemeCard.wordToTheTaxCollector.description", 1, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.LOOSE_5_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.sateRomanAppetites.title",
                    "card.schemeCard.sateRomanAppetites.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INFLUENCE_IF_READY_GLADIATORS)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.sateRomanAppetites.title",
                    "card.schemeCard.sateRomanAppetites.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INFLUENCE_IF_READY_GLADIATORS)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.sateRomanAppetites.title",
                    "card.schemeCard.sateRomanAppetites.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INFLUENCE_IF_READY_GLADIATORS)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.illicitAuction.title",
                    "card.schemeCard.illicitAuction.description", 1, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.DISCARD_SLAVE_GAIN_VALUE_TWICE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.caughtTakingBribes.title",
                    "card.schemeCard.caughtTakingBribes.description", 1, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(LOOSE_INFLUENCE, GAIN_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.caughtTakingBribes.title",
                    "card.schemeCard.caughtTakingBribes.description", 1, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(LOOSE_INFLUENCE, GAIN_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.bribeTheGuards.title",
                    "card.schemeCard.bribeTheGuards.description", 1, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.EXHAUST_ALL_GUARDS_PAY_PER)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.bribeTheGuards.title",
                    "card.schemeCard.bribeTheGuards.description", 1, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.EXHAUST_ALL_GUARDS_PAY_PER)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.lootingTheDead.title",
                    "card.schemeCard.lootingTheDead.description", 1, 4,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GAIN_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.lootingTheDead.title",
                    "card.schemeCard.lootingTheDead.description", 1, 4,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GAIN_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.lootingTheDead.title",
                    "card.schemeCard.lootingTheDead.description", 1, 4,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GAIN_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.revenge.title",
                    "card.schemeCard.revenge.description", 1, 2,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GAIN_INFLUENCE_FOR_WEAKEST)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.revenge.title",
                    "card.schemeCard.revenge.description", 1, 2,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GAIN_INFLUENCE_FOR_WEAKEST)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.spreadCheeksWide.title",
                    "card.schemeCard.spreadCheeksWide.description", 2, 4,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.LOSE_2_INFLUENCE_OTHER_LOSES_1)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.poisonedWine.title",
                    "card.schemeCard.poisonedWine.description", 2, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INJURE_ASSET)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.poisonedWine.title",
                    "card.schemeCard.poisonedWine.description", 2, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INJURE_ASSET)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.poisonedWine.title",
                    "card.schemeCard.poisonedWine.description", 2, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INJURE_ASSET)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.poisonedWine.title",
                    "card.schemeCard.poisonedWine.description", 2, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INJURE_ASSET)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.finalBlow.title",
                    "card.schemeCard.finalBlow.description", 1, 1,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INFLUENCE_TO_TARGET)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.robbery.title",
                    "card.schemeCard.robbery.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(GAIN_3_GOLD, LOOSE_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.robbery.title",
                    "card.schemeCard.robbery.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(GAIN_3_GOLD, LOOSE_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.robbery.title",
                    "card.schemeCard.robbery.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(GAIN_3_GOLD, LOOSE_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.robbery.title",
                    "card.schemeCard.robbery.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(GAIN_3_GOLD, LOOSE_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.jointVenture.title",
                    "card.schemeCard.jointVenture.description", 2, 12,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GAIN_7_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.jointVenture.title",
                    "card.schemeCard.jointVenture.description", 2, 12,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.GAIN_7_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.lendMeYourEar.title",
                    "card.schemeCard.lendMeYourEar.description", 1, 1,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(ActionFactory.INFLUENCE_TO_TARGET)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.illicitServices.title",
                    "card.schemeCard.illicitServices.description", 1, 6,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(GOLD_2_PER_READY_SLAVE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.illicitServices.title",
                    "card.schemeCard.illicitServices.description", 1, 6,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(GOLD_2_PER_READY_SLAVE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.illicitServices.title",
                    "card.schemeCard.illicitServices.description", 1, 6,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(GOLD_2_PER_READY_SLAVE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.conspiracy.title",
                    "card.schemeCard.conspiracy.description", 2, 16,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(LOOSE_2_INFLUENCE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.unlockedGate.title",
                    "card.schemeCard.unlockedGate.description", 1, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(DISCARD_SLAVE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.unlockedGate.title",
                    "card.schemeCard.unlockedGate.description", 1, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(DISCARD_SLAVE)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.epicSpectacle.title",
                    "card.schemeCard.epicSpectacle.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    Collections.singletonList(INFLUENCE_FOR_READY_GLADIATOR)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.epicSpectacle.title",
                    "card.schemeCard.epicSpectacle.description", 2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    Collections.singletonList(INFLUENCE_FOR_READY_GLADIATOR)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.buyingSecrets.title",
                    "card.schemeCard.buyingSecrets.description", 2, 4,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(LOOSE_INFLUENCE, LOOSE_3_GOLD)));

            schemeCardsRepo.save(SchemeCard.of("card.schemeCard.buyingSecrets.title",
                    "card.schemeCard.buyingSecrets.description", 2, 4,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(LOOSE_INFLUENCE, LOOSE_3_GOLD)));

        }
    }

    void addDominusCards(){
        /////////////////////////////Dominus/////////////////////////////
        if(dominusBoardRepo.findAll().size() != 4){
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
                    9, 2, 3, 1);
            dominusBoardRepo.save(Tullius);

            DominusBoard Solonius = DominusBoard.of("card.dominusBoard.solonius.title",
                    "card.dominusBoard.solonius.description",
                    12, 2, 2, 1);
            dominusBoardRepo.save(Solonius);
        }
    }

    void addReactionCards(){
        /////////////////////////////REACTION/////////////////////////////
        int guardsNumber = reactionCardsRepo.findAllByTitleKey("card.reactionCard.guard.title").size();
        if(guardsNumber != 23){
            for(int i = guardsNumber; i < 23; i++){
                reactionCardsRepo.save(GuardCard.of("card.reactionCard.guard.title",
                        "card.reactionCard.guard.description", 1, 0,
                        IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                        List.of(FOIL_SCHEME)));
            }
        }
        if (reactionCardsRepo.findAll().size() != 19) {
            logger.info("Adding reaction cards");
            reactionCardsRepo.save(ReactionCard.of("card.reactionCard.supportFromRome.title",
                    "card.reactionCard.supportFromRome.description", 3, 8,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(FOIL_SCHEME, RETRIEVE_GUARD_FROM_DISCARD)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.supportFromRome.title",
                    "card.reactionCard.supportFromRome.description",
                    3, 8,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(FOIL_SCHEME, RETRIEVE_GUARD_FROM_DISCARD)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.riggingTheMatch.title",
                    "card.reactionCard.riggingTheMatch.description",
                    2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(SWITCH_GLADIATOR)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.riggingTheMatch.title",
                    "card.reactionCard.riggingTheMatch.description",
                    2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(SWITCH_GLADIATOR)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.bloodOnTheSand.title",
                    "card.reactionCard.bloodOnTheSand.description",
                    2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(GAIN_INFLUENCE)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.bloodOnTheSand.title",
                    "card.reactionCard.bloodOnTheSand.description",
                    2, 0,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(GAIN_INFLUENCE)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.sacrificeForTheDominus.title",
                    "card.reactionCard.sacrificeForTheDominus.description",
                    3, 2,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(FOIL_SCHEME, DISCARD_SLAVE)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.sacrificeForTheDominus.title",
                    "card.reactionCard.sacrificeForTheDominus.description",
                    3, 2,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(FOIL_SCHEME, DISCARD_SLAVE)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.forAFewDenarii.title",
                    "card.reactionCard.forAFewDenarii.description",
                    3, 2,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(PAY_DOMINUS_TO_FAIL_SCHEME)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.forAFewDenarii.title",
                    "card.reactionCard.forAFewDenarii.description",
                    3, 2,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(PAY_DOMINUS_TO_FAIL_SCHEME)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.emptyBrothel.title",
                    "card.reactionCard.emptyBrothel.description",
                    1, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(LOOSE_INFLUENCE_IF_NO_READY_SLAVES)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.emptyBrothel.title",
                    "card.reactionCard.emptyBrothel.description",
                    1, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(LOOSE_INFLUENCE_IF_NO_READY_SLAVES)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.aShamefulLudus.title",
                    "card.reactionCard.aShamefulLudus.description",
                    1, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(LOOSE_INFLUENCE_IF_NO_READY_GLADIATORS)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.aShamefulLudus.title",
                    "card.reactionCard.aShamefulLudus.description",
                    1, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(LOOSE_INFLUENCE_IF_NO_READY_GLADIATORS)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.destitute.title",
                    "card.reactionCard.destitute.description",
                    1, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(LOOSE_INFLUENCE_IF_NO_GOLD)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.destitute.title",
                    "card.reactionCard.destitute.description",
                    1, 3,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(LOOSE_INFLUENCE_IF_NO_GOLD)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.whisperedRumors.title",
                    "card.reactionCard.whisperedRumors.description",
                    3, 6,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(FOIL_SCHEME)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.whisperedRumors.title",
                    "card.reactionCard.whisperedRumors.description",
                    3, 6,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(FOIL_SCHEME)));

            reactionCardsRepo.save(ReactionCard.of(
                    "card.reactionCard.jupiterCock.title",
                    "card.reactionCard.jupiterCock.description",
                    4, 6,
                    IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                    List.of(FOIL_SCHEME_OR_REACTION)));
        }
    }

    public void printGameBoxContent(){
        logger.info("GameBox content:");
        logger.info("Equipment cards: " + equipmentCardsRepo.findAll().size());
        logger.info("Gladiator cards: " + gladiatorCardsRepo.findAll().size());
        logger.info("Slave cards: " + slaveCardsRepo.findAll().size());
        logger.info("Scheme cards: " + schemeCardsRepo.findAll().size());
        logger.info("Reaction cards: " + reactionCardsRepo.findAll().size());
        logger.info("Dominus boards: " + dominusBoardRepo.findAll().size());
    }

    public void cleanUpRepos() {
        this.reactionCardsRepo.deleteAll();
        this.gladiatorCardsRepo.deleteAll();
        this.schemeCardsRepo.deleteAll();
        this.slaveCardsRepo.deleteAll();
        this.equipmentCardsRepo.deleteAll();
        this.dominusBoardRepo.deleteAll();
    }
}
