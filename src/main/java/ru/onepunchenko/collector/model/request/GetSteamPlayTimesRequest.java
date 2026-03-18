package ru.onepunchenko.collector.model.request;

import java.time.Instant;

public record GetSteamPlayTimesRequest(
        Instant from,
        Instant to
) { }
