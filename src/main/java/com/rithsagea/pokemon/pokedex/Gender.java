package com.rithsagea.pokemon.pokedex;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Gender {
  MALE, FEMALE, GENDERLESS;

  @JsonCreator
  public static Gender fromString(String value) {
    switch(value) {
      case "M": return MALE;
      case "F": return FEMALE;
      case "N": return GENDERLESS;
    }

    return null;
  }
}
