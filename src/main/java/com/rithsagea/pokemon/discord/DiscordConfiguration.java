package com.rithsagea.pokemon.discord;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rithsagea.pokemon.discord.listener.EventListener;

import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.EventDispatcher;
import discord4j.core.event.domain.Event;
import discord4j.core.shard.GatewayBootstrap;
import discord4j.gateway.GatewayOptions;

@Configuration
public class DiscordConfiguration {

  @Value("${discord.token}")
  private String token;

  @Bean("discordClient")
  DiscordClient discordClient() {
    return DiscordClientBuilder.create(token).build();
  }

  @Bean("eventDispatcher")
  <T extends Event> EventDispatcher eventDispatcher(List<EventListener<T>> listeners) {
    EventDispatcher eventDispatcher = EventDispatcher.builder().build();

    for(EventListener<T> listener : listeners) {
      eventDispatcher.on(listener.getEventType())
        .flatMap(listener::execute)
        .onErrorResume(listener::handleError)
        .subscribe();
    }

    return eventDispatcher;
  }

  @Bean
  GatewayDiscordClient gatewayDiscordClient(DiscordClient discordClient, EventDispatcher eventDispatcher) {
    GatewayBootstrap<GatewayOptions> gateway = discordClient.gateway();
    return gateway.setEventDispatcher(eventDispatcher)
      .login().doOnNext(c -> createThread(c)).block();
  }

  private void createThread(GatewayDiscordClient client) {
    Thread thread = new Thread("discord") {
      @Override
      public void run() {
        client.onDisconnect().block();
      }
    };
    thread.setContextClassLoader(getClass().getClassLoader());
    thread.setDaemon(false);
    thread.start();
  }
}
