package ru.onepunchenko.collector.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SteamScheduler {
    private final GameService gameService;

    @Scheduled(cron = "0 0 0 * * *", zone = "UTC")
    public void saveSteamPlaytimeDaily() {
        try {
            gameService.saveSteamPlaytime();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
