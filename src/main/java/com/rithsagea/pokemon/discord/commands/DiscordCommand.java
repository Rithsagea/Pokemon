package com.rithsagea.pokemon.discord.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.discordjson.json.ApplicationCommandRequest;
import reactor.core.publisher.Mono;

public interface DiscordCommand {
  public ApplicationCommandRequest getInfo();

  public Mono<Void> execute(ChatInputInteractionEvent event);
}
