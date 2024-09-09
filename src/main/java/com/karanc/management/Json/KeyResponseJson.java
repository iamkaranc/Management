package com.karanc.management.Json;

public class KeyResponseJson {
    private String statusMessage;
    private String statusCode;
    private ErrorJsonCommon error;
    private AvailableKey availableKey;

    private KeyInfoJson keyInfo;
    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public ErrorJsonCommon getErrorJsonCommon() {
        return error;
    }

    public void setErrorJsonCommon(ErrorJsonCommon error) {
        this.error = error;
    }

    public AvailableKey getAvailableKeyJson() {
        return availableKey;
    }

    public void setAvailableKeyJson(AvailableKey availableKey) {
        this.availableKey = availableKey;
    }

    public KeyInfoJson getKeyInfo() {
        return keyInfo;
    }

    public void setKeyInfo(KeyInfoJson keyInfo) {
        this.keyInfo = keyInfo;
    }

    public void setStatusMessageWithKey(String statusMessage, String key) {
        this.statusMessage = statusMessage + key;
    }
}
