package com.rithsagea.pokemon.pokedex;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

public class Species {

  @JsonAlias("num")
  @Getter
  private int dexNumber;

  @Getter
  private String name;

  @Getter
  private String baseSpecies;

  @Getter
  @JsonAlias("baseForme")
  private String baseForm;

  @Getter
  @JsonAlias("forme")
  private String form;

  @Getter
  private List<Type> types;

  @Getter
  private String gender;

  private Map<Gender, Double> genderRatio;

  @Getter
  private Map<Stat, Integer> baseStats;

  @Getter
  private int maxHP;

  @Getter
  private Map<String, String> abilities;

  @Getter
  @JsonAlias("heightm")
  private double height; // meters

  @Getter
  @JsonAlias("weightkg")
  private double weight; // kilograms

  @Getter
  private String color;

  // Evolutions

  @Getter
  @JsonAlias("prevo")
  private String previousEvolution;

  @Getter
  @JsonAlias("evoType")
  private String evolutionType;

  @Getter
  @JsonAlias("evoCondition")
  private String evolutionCondition;

  @Getter
  @JsonAlias("evoLevel")
  private int evolutionLevel;

  @Getter
  @JsonAlias("evoItem")
  private String evolutionItem;

  @Getter
  @JsonAlias("evoMove")
  private String evolutionMove;

  @Getter
  @JsonAlias("evoRegion")
  private String evolutionRegion;

  @Getter
  @JsonAlias("evos")
  private List<String> evolutions;

  @Getter
  private List<String> tags;

  @Getter
  private List<EggGroup> eggGroups;

  @JsonProperty("canHatch")
  private boolean canHatch;

  // forms

  @Getter
  @JsonAlias("otherFormes")
  private List<String> otherForms;

  @Getter
  @JsonAlias("cosmeticFormes")
  private List<String> cosmeticForms;

  @Getter
  @JsonAlias("formeOrder")
  private List<String> formOrder;

  @Getter
  private String requiredItem;

  @Getter
  private List<String> requiredItems;

  @Getter
  private String requiredMove;

  @Getter
  private String requiredAbility;

  @Getter
  private List<String> battleOnly;

  @Getter
  private String changesFrom;

  @Getter
  @JsonAlias("canGigantamax")
  private String gigantamax;

  @JsonProperty("cannotDynamax")
  private boolean cannotDynamax;

  @Getter
  @JsonAlias("gen")
  private int generation;

  // ACCESSORS

  private static final Map<Gender, Double> DEFAULT_GENDER_RATIO = Map.of(Gender.MALE, .50, Gender.FEMALE, .50);

  public Map<Gender, Double> getGenderRatio() {
    if (genderRatio == null)
      return DEFAULT_GENDER_RATIO;
    return genderRatio;
  }

  public boolean canHatch() {
    return canHatch;
  }

  public boolean cannotDynamax() {
    return cannotDynamax;
  }
}
