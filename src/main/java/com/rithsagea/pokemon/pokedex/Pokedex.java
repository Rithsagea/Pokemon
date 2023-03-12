package com.rithsagea.pokemon.pokedex;

import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Service
public class Pokedex {
  @Value("classpath:data/species.json")
  private Resource speciesJson;

  private HashMap<String, Species> speciesMap = new HashMap<>();

  private Logger LOG = LoggerFactory.getLogger(Pokedex.class);

  @PostConstruct
  public void init() throws IOException {
    LOG.info("Initializing Pokedex");

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    speciesMap = objectMapper.readValue(speciesJson.getInputStream(), new TypeReference<HashMap<String, Species>>() {
    });

    LOG.info("Registered {} species", speciesMap.size());
  }

  public Species getSpecies(String id) {
    return speciesMap.get(id);
  }
}
