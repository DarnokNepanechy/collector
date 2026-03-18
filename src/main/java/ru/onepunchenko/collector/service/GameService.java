package ru.onepunchenko.collector.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.onepunchenko.collector.client.SteamClient;
import ru.onepunchenko.collector.mapper.SteamMapper;
import ru.onepunchenko.collector.model.entity.SteamPlaytime;
import ru.onepunchenko.collector.repository.SteamPlaytimeRepository;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final SteamPlaytimeRepository steamPlaytimeRepository;
    private final SteamClient steamClient;

    public void saveSteamPlaytime() throws Exception {
        var playedGames = steamClient.getRecentlyPlayedGames();
        if (playedGames == null || playedGames.response() == null
                || playedGames.response().games() == null || playedGames.response().games().isEmpty()) {
            throw new Exception("Empty result");
        }

        var playTimes = SteamMapper.mapPlayTimesToEntity(playedGames.response().games());

        steamPlaytimeRepository.saveAll(playTimes);
    }

    public List<SteamPlaytime> getSteamPlaytime(Instant from, Instant to) {
        return steamPlaytimeRepository.getFromPeriod(from, to);
    }
}
