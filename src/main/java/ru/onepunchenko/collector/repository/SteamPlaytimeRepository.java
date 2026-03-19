package ru.onepunchenko.collector.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import ru.onepunchenko.collector.model.entity.SteamPlaytime;

import java.time.Instant;
import java.util.List;

public interface SteamPlaytimeRepository extends ListCrudRepository<SteamPlaytime, Integer> {
    @Query("select * from steam_playtime sp where sp.field_created > :from and sp.field_created <= :to")
    List<SteamPlaytime> getFromPeriod(Instant from, Instant to);
}
