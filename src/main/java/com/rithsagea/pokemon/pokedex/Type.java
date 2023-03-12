package com.rithsagea.pokemon.pokedex;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Type {
  BUG,
  DARK,
  DRAGON,
  ELECTRIC,
  FAIRY,
  FIGHTING,
  FIRE,
  FLYING,
  GHOST,
  GRASS,
  GROUND,
  ICE,
  NORMAL,
  POISON,
  PSYCHIC,
  ROCK,
  STEEL,
  WATER,

  // weird types
  BIRD;

  @JsonCreator
  public static Type fromString(String value) {
    return Type.valueOf(value.toUpperCase());
  }
}
