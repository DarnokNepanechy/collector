package ru.onepunchenko.collector.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.onepunchenko.collector.model.entity.SteamPlaytime;
import ru.onepunchenko.collector.model.request.GetSteamPlayTimesRequest;
import ru.onepunchenko.collector.service.GameService;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @PostMapping("steam/playtime/save")
    public void saveSteamPlayTimes() throws Exception {
        gameService.saveSteamPlaytime();
    }

    @PostMapping("steam/playtime/get")
    public List<SteamPlaytime> getSteamPlayTimes(@RequestBody GetSteamPlayTimesRequest request) {
        return gameService.getSteamPlaytime(request.from(), request.to());
    }
}
