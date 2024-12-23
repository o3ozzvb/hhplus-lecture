package com.example.hhplus_lecture.domain.user;

import java.time.LocalDateTime;

public class User {

    private final Long id;
    private final String name;
    private final LocalDateTime createdAt;

    public User(Long id, String name, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
