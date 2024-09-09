package com.karanc.management.Json;

import java.util.Date;

public class KeyInfoJson {

    private Long id;

    private String Name;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isBlocked;

    private Date blockedAt;

    private Boolean isKeyKeepAlive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public Date getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(Date blockedAt) {
        this.blockedAt = blockedAt;
    }

    public Boolean getKeyKeepAlive() {
        return isKeyKeepAlive;
    }

    public void setKeyKeepAlive(Boolean keyKeepAlive) {
        isKeyKeepAlive = keyKeepAlive;
    }
}
