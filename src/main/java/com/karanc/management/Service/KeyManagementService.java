package com.karanc.management.Service;

import com.karanc.management.Json.KeyInfoJson;
import com.karanc.management.Json.KeyRequestJson;
import com.karanc.management.Json.KeyResponseJson;

public interface KeyManagementService {

    KeyResponseJson postKeys(KeyRequestJson keyRequestJson);

    KeyResponseJson getAvailableKey();

    KeyResponseJson getKey(String key);

    KeyResponseJson deleteKey(String key);

}
