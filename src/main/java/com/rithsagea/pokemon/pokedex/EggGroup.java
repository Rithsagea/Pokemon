package com.rithsagea.pokemon.pokedex;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EggGroup {
  MONSTER,
  WATER1,
  BUG,
  FLYING,
  FIELD,
  FAIRY,
  GRASS,
  HUMANLIKE,
  WATER3,
  MINERAL,
  AMORPHOUS,
  WATER2,
  DITTO,
  DRAGON,
  UNDISCOVERED;

  @JsonCreator
  public static EggGroup fromString(String value) {
    return EggGroup.valueOf(value.toUpperCase().replaceAll("[\\s-]", ""));
  }
}
