package ru.onepunchenko.collector.mapper;

import ru.onepunchenko.collector.model.dto.SteamPlayedGames;
import ru.onepunchenko.collector.model.entity.SteamPlaytime;

import java.time.Instant;
import java.util.List;

public class SteamMapper {
    public static List<SteamPlaytime> mapPlayTimesToEntity(List<SteamPlayedGames.Response.Game> games) {
        return games.stream()
                .map(SteamMapper::mapPlayTimeToEntity)
                .toList();
    }

    public static SteamPlaytime mapPlayTimeToEntity(SteamPlayedGames.Response.Game game) {
        return SteamPlaytime.builder()
                .appId(game.appid())
                .gameName(game.name())
                .playtime2weeks(game.playtime_2weeks())
                .playtimeForever(game.playtime_forever())
                .fieldCreated(Instant.now())
                .build();
    }
}
