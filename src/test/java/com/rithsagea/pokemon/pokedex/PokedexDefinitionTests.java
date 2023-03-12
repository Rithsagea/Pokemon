package com.rithsagea.pokemon.pokedex;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PokedexDefinitionTests {

  @Autowired
  public Pokedex pokedex;

  @Test
  public void testKirliaDefinition() {
    Species kirlia = pokedex.getSpecies("kirlia");
    assert kirlia.getDexNumber() == 281;
    assert kirlia.getName().equals("Kirlia");
    assert kirlia.getTypes().equals(List.of(Type.PSYCHIC, Type.FAIRY));
    assert kirlia.getBaseStats().equals(Map.of(Stat.HP, 38, Stat.ATTACK, 35, Stat.DEFENSE, 35, Stat.SPECIAL_ATTACK, 65,
        Stat.SPECIAL_DEFENSE, 55, Stat.SPEED, 50));
    assert kirlia.getAbilities().equals(Map.of("0", "Synchronize", "1", "Trace", "H", "Telepathy"));
    assert kirlia.getHeight() == 0.8;
    assert kirlia.getWeight() == 20.2;
    assert kirlia.getColor().equals("White");
    assert kirlia.getPreviousEvolution().equals("Ralts");
    assert kirlia.getEvolutionLevel() == 20;
    assert kirlia.getEvolutions().equals(List.of("Gardevoir", "Gallade"));
    assert kirlia.getEggGroups().equals(List.of(EggGroup.HUMANLIKE, EggGroup.AMORPHOUS));
  }

  @Test
  public void testGardevoirDefinition() {
    Species gardevoir = pokedex.getSpecies("gardevoir");
    assert gardevoir.getDexNumber() == 282;
    assert gardevoir.getName().equals("Gardevoir");
    assert gardevoir.getTypes().equals(List.of(Type.PSYCHIC, Type.FAIRY));
    assert gardevoir.getBaseStats().equals(Map.of(Stat.HP, 68, Stat.ATTACK, 65, Stat.DEFENSE, 65, Stat.SPECIAL_ATTACK,
        125, Stat.SPECIAL_DEFENSE, 115, Stat.SPEED, 80));
    assert gardevoir.getAbilities().equals(Map.of("0", "Synchronize", "1", "Trace", "H", "Telepathy"));
    assert gardevoir.getHeight() == 1.6;
    assert gardevoir.getWeight() == 48.4;
    assert gardevoir.getColor().equals("White");
    assert gardevoir.getPreviousEvolution().equals("Kirlia");
    assert gardevoir.getEvolutionLevel() == 30;
    assert gardevoir.getEggGroups().equals(List.of(EggGroup.HUMANLIKE, EggGroup.AMORPHOUS));
    assert gardevoir.getOtherForms().equals(List.of("Gardevoir-Mega"));
    assert gardevoir.getFormOrder().equals(List.of("Gardevoir", "Gardevoir-Mega"));
  }

  @Test
  public void testMiloticDefinition() {
    Species milotic = pokedex.getSpecies("milotic");
    assert milotic.getDexNumber() == 350;
    assert milotic.getName().equals("Milotic");
    assert milotic.getTypes().equals(List.of(Type.WATER));
    assert milotic.getGenderRatio().equals(Map.of(Gender.MALE, .50, Gender.FEMALE, .50));
    assert milotic.getBaseStats().equals(Map.of(Stat.HP, 95, Stat.ATTACK, 60, Stat.DEFENSE, 79, Stat.SPECIAL_ATTACK,
        100, Stat.SPECIAL_DEFENSE, 125, Stat.SPEED, 81));
    assert milotic.getAbilities().equals(Map.of("0", "Marvel Scale", "1", "Competitive", "H", "Cute Charm"));
    assert milotic.getHeight() == 6.2;
    assert milotic.getWeight() == 162;
    assert milotic.getColor().equals("Pink");
    assert milotic.getPreviousEvolution().equals("Feebas");
    assert milotic.getEvolutionType().equals("trade");
    assert milotic.getEvolutionItem().equals("Prism Scale");
    assert milotic.getEggGroups().equals(List.of(EggGroup.WATER1, EggGroup.DRAGON));
  }

  @Test
  public void testMegaCharizard() {
    Species charizard = pokedex.getSpecies("charizard");
    assert charizard.getOtherForms().equals(List.of("Charizard-Mega-X", "Charizard-Mega-Y"));
    assert charizard.getFormOrder().equals(List.of("Charizard", "Charizard-Mega-X", "Charizard-Mega-Y"));
    assert charizard.getGigantamax().equals("G-Max Wildfire");

    Species charizardMega = pokedex.getSpecies("charizardmegax");
    assert charizardMega.getRequiredItem().equals("Charizardite X");
  }

  @Test
  public void testForms() {
    Species pikachu = pokedex.getSpecies("pikachu");
    assert pikachu.getOtherForms()
        .equals(List.of("Pikachu-Cosplay", "Pikachu-Rock-Star", "Pikachu-Belle", "Pikachu-Pop-Star", "Pikachu-PhD",
            "Pikachu-Libre", "Pikachu-Original", "Pikachu-Hoenn", "Pikachu-Sinnoh", "Pikachu-Unova", "Pikachu-Kalos",
            "Pikachu-Alola", "Pikachu-Partner", "Pikachu-Starter", "Pikachu-World"));
    assert pikachu.getFormOrder().equals(List.of("Pikachu",
        "Pikachu-Original", "Pikachu-Hoenn", "Pikachu-Sinnoh", "Pikachu-Unova", "Pikachu-Kalos", "Pikachu-Alola",
        "Pikachu-Partner", "Pikachu-Starter", "Pikachu-World", "Pikachu-Rock-Star", "Pikachu-Belle", "Pikachu-Pop-Star",
        "Pikachu-PhD", "Pikachu-Libre", "Pikachu-Cosplay"));

    Species pikachuCosplay = pokedex.getSpecies("pikachucosplay");
    assert pikachuCosplay.getGeneration() == 6;

    Species arceusGhost = pokedex.getSpecies("arceusghost");
    assert arceusGhost.getForm().equals("Ghost");
    assert arceusGhost.getChangesFrom().equals("Arceus");
    assert arceusGhost.getRequiredItems().equals(List.of("Spooky Plate", "Ghostium Z"));

    Species arceus = pokedex.getSpecies("arceus");
    assert arceus.getBaseForm().equals("Normal");

    Species deerling = pokedex.getSpecies("deerling");
    assert deerling.getCosmeticForms().equals(List.of("Deerling-Summer", "Deerling-Autumn", "Deerling-Winter"));

    Species rayquazaMega = pokedex.getSpecies("rayquazamega");
    assert rayquazaMega.getRequiredMove().equals("Dragon Ascent");

    Species zacian = pokedex.getSpecies("zacian");
    assert zacian.cannotDynamax() == true;
  }

  @Test
  public void testEvolutionCondition() {
    Species malamar = pokedex.getSpecies("malamar");
    assert malamar.getEvolutionCondition().equals("with the console turned upside-down");

    Species raichuAlola = pokedex.getSpecies("raichualola");
    assert raichuAlola.getEvolutionRegion().equals("Alola");

    Species sudowudo = pokedex.getSpecies("sudowoodo");
    assert sudowudo.getEvolutionMove().equals("Mimic");
  }

  @Test
  public void testMisc() {
    Species beldum = pokedex.getSpecies("beldum");
    assert beldum.getGender().equals("N");

    Species chansey = pokedex.getSpecies("chansey");
    assert chansey.canHatch() == true;

    Species shaymin = pokedex.getSpecies("shaymin");
    assert shaymin.getTags().equals(List.of("Mythical"));

    Species shedinja = pokedex.getSpecies("shedinja");
    assert shedinja.getMaxHP() == 1;

    Species castformSnowy = pokedex.getSpecies("castformsnowy");
    assert castformSnowy.getRequiredAbility().equals("Forecast");
    assert castformSnowy.getBattleOnly().equals(List.of("Castform"));

  }
}
