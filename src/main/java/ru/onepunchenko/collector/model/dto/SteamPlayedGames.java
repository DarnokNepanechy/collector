package ru.onepunchenko.collector.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public record SteamPlayedGames(Response response) {
    public record Response(
            Integer total_count,
            List<Game> games
    ) {
        public record Game(
                Integer appid,
                String name,
                Integer playtime_2weeks,
                Integer playtime_forever,
                @JsonIgnore
                Integer playtime_windows_forever,
                @JsonIgnore
                Integer playtime_mac_forever,
                @JsonIgnore
                Integer playtime_linux_forever,
                @JsonIgnore
                Integer playtime_deck_forever
        ) { }
    }
}
