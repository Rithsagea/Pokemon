package com.rithsagea.pokemon.discord.commands;

import org.springframework.stereotype.Component;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.discordjson.json.ApplicationCommandRequest;
import reactor.core.publisher.Mono;

@Component
public class TestCommand implements DiscordCommand {

  @Override
  public ApplicationCommandRequest getInfo() {
    return ApplicationCommandRequest.builder()
        .name("test")
        .description("Test command")
        .build();
  }

  @Override
  public Mono<Void> execute(ChatInputInteractionEvent event) {
    return event.reply("This is a test command");
  }

}
