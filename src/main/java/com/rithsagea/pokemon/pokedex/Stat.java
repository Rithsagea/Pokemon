package com.rithsagea.pokemon.pokedex;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Stat {
  HP, ATTACK, DEFENSE, SPECIAL_ATTACK, SPECIAL_DEFENSE, SPEED;

  @JsonCreator
  public static Stat fromString(String value) {
    switch(value) {
      case "hp": return HP;
      case "atk": return ATTACK;
      case "def": return DEFENSE;
      case "spa": return SPECIAL_ATTACK;
      case "spd": return SPECIAL_DEFENSE;
      case "spe": return SPEED;
    }
    
    return Stat.valueOf(value.toUpperCase());
  }
}
