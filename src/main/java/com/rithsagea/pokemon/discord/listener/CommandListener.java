package com.rithsagea.pokemon.discord.listener;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rithsagea.pokemon.discord.commands.DiscordCommand;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import reactor.core.publisher.Mono;

@Service
public class CommandListener implements EventListener<ChatInputInteractionEvent> {

  private Map<String, DiscordCommand> commandMap;

  public CommandListener(List<DiscordCommand> commands) {
    commandMap = commands.stream().collect(
        Collectors.toMap(cmd -> cmd.getInfo().name(), Function.identity()));
  }

  @Override
  public Class<ChatInputInteractionEvent> getEventType() {
    return ChatInputInteractionEvent.class;
  }

  @Override
  public Mono<Void> execute(ChatInputInteractionEvent event) {
    DiscordCommand command = commandMap.get(event.getCommandName());
    if (command == null)
      return Mono.empty();
    return command.execute(event);
  }

}
