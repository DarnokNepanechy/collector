package ru.onepunchenko.collector.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.onepunchenko.collector.model.dto.SteamPlayedGames;

@Component
public class SteamClient {
    private final RestClient restClient;
    @Value("${STEAM_KEY}")
    private String STEAM_KEY;
    @Value("${STEAM_ID}")
    private String STEAM_ID;

    public SteamClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://api.steampowered.com")
                .build();
    }

    public SteamPlayedGames getRecentlyPlayedGames() {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/IPlayerService/GetRecentlyPlayedGames/v0001/")
                        .queryParam("key", STEAM_KEY)
                        .queryParam("steamid", STEAM_ID)
                        .queryParam("format", "json")
                        .build())
                .retrieve()
                .body(SteamPlayedGames.class);
    }
}
