package ru.onepunchenko.collector.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SteamPlaytime {
    @Id
    private Integer id;
    private Integer appId;
    private Instant fieldCreated;
    private String gameName;
    @Column("playtime_2weeks")
    private Integer playtime2weeks;
    private Integer playtimeForever;
}
