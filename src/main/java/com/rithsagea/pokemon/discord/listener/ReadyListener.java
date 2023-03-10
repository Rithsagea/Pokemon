package com.rithsagea.pokemon.discord.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rithsagea.pokemon.discord.commands.DiscordCommand;

import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.discordjson.json.ApplicationCommandRequest;
import discord4j.rest.RestClient;
import reactor.core.publisher.Mono;

@Service
public class ReadyListener implements EventListener<ReadyEvent> {

  private Logger LOG = LoggerFactory.getLogger(ReadyListener.class);

  @Value("${discord.testGuild}")
  private long testGuild;

  @Autowired
  private List<DiscordCommand> commands;

  @Override
  public Class<ReadyEvent> getEventType() {
    return ReadyEvent.class;
  }

  @Override
  public Mono<Void> execute(ReadyEvent event) {
    LOG.info("Logged in as {}", event.getSelf().getTag());

    RestClient client = event.getClient().getRestClient();
    long applicationId = client.getApplicationId().block();

    commands.forEach(command -> {
      ApplicationCommandRequest commandInfo = command.getInfo();
      client.getApplicationService()
          .createGuildApplicationCommand(applicationId, testGuild, commandInfo)
          .subscribe();
      LOG.info("Registered Command [{}]", commandInfo.name());
    });

    return Mono.empty();
  }

}
