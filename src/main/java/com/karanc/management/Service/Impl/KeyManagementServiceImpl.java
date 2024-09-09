package com.karanc.management.Service.Impl;

import com.karanc.management.Dao.KeyInfoDao;
import com.karanc.management.Entity.KeyInfo;
import com.karanc.management.Json.*;
import com.karanc.management.Service.KeyManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.logging.Logger;

@Service
public class KeyManagementServiceImpl implements KeyManagementService {

    private static final Logger logger = Logger.getLogger(String.valueOf(KeyManagementServiceImpl.class));

    @Autowired
    private KeyInfoDao keyInfoDao;

    @Override
    public KeyResponseJson postKeys(KeyRequestJson keyRequestJson) {
        logger.info("Inside PostKeys");
        KeyResponseJson keyResponseJson = new KeyResponseJson();
        if(keyRequestJson != null) {
            logger.info("KeyRequestJson Not null");
            List<String> keyNames = keyRequestJson.getNames();
            if(!CollectionUtils.isEmpty(keyNames)) {
                for(String keyName: keyNames) {
                    logger.info("KeyName: {}");
                    KeyInfo keyInfo = new KeyInfo();
                    keyInfo.setName(keyName);
                    keyInfo.setIsBlocked(0);
                    keyInfo.setBlockedAt(null);
                    keyInfo.setIsKeyKeepAlive(0);
                    keyInfoDao.save(keyInfo);
                }
            }
            keyResponseJson.setStatusCode("200");
            keyResponseJson.setStatusMessage("SUCCESS");

        } else {
            ErrorJsonCommon errorJsonCommon = new ErrorJsonCommon();
            errorJsonCommon.setErrorCode("200");
            errorJsonCommon.setErrorMessage("Unable to save the given keys");
            keyResponseJson.setErrorJsonCommon(errorJsonCommon);
        }


        return keyResponseJson;
    }

    public KeyResponseJson getAvailableKey() {
        logger.info("Inside getAvailableKey");
        KeyResponseJson keyResponseJson = new KeyResponseJson();

        KeyInfo keyInfo = keyInfoDao.getAvailableKey();
        if(keyInfo != null) {
            AvailableKey availableKey = new AvailableKey();
            availableKey.setName(keyInfo.getName());
            availableKey.setId(keyInfo.getId());
            keyResponseJson.setAvailableKeyJson(availableKey);
        } else {
            ErrorJsonCommon errorJsonCommon = new ErrorJsonCommon();
            errorJsonCommon.setErrorCode("404");
            errorJsonCommon.setErrorMessage("Unable to get any available Key");
            keyResponseJson.setErrorJsonCommon(errorJsonCommon);
        }
        return keyResponseJson;
    }

    public KeyResponseJson getKey(String key) {
        logger.info("Inside getKey");
        KeyResponseJson keyResponseJson = new KeyResponseJson();

        KeyInfo keyInfo = keyInfoDao.getKey(key);
        if(keyInfo != null) {
            KeyInfoJson keyInfoJson = toKeyInfoJson(keyInfo);
            keyResponseJson.setKeyInfo(keyInfoJson);
        } else {
            ErrorJsonCommon errorJsonCommon = new ErrorJsonCommon();
            errorJsonCommon.setErrorCode("404");
            errorJsonCommon.setErrorMessage("Unable to get any available Key");
            keyResponseJson.setErrorJsonCommon(errorJsonCommon);
        }
        return keyResponseJson;
    }

    private KeyInfoJson toKeyInfoJson(KeyInfo keyInfo) {
        KeyInfoJson keyInfoJson = new KeyInfoJson();
        keyInfoJson.setId(keyInfo.getId());
        keyInfoJson.setName(keyInfo.getName());
        keyInfoJson.setBlocked(keyInfo.getIsBlocked() == 0);
        keyInfoJson.setBlockedAt(keyInfo.getBlockedAt());
        keyInfoJson.setCreatedAt(keyInfo.getCreatedAt());
        keyInfoJson.setUpdatedAt(keyInfo.getUpdatedAt());
        return keyInfoJson;

    }

    public KeyResponseJson deleteKey(String key) {
        logger.info("Inside deleteKey");
        KeyResponseJson keyResponseJson = new KeyResponseJson();

        keyInfoDao.deleteByName(key);
//        if(keyInfo != null) {
//            keyResponseJson.setStatusMessageWithKey("Deleted Key: {}", key);
//            keyResponseJson.setStatusCode("200");
//        } else {
//            ErrorJsonCommon errorJsonCommon = new ErrorJsonCommon();
//            errorJsonCommon.setErrorCode("404");
//            errorJsonCommon.setErrorMessage("Unable to delete any available Key");
//            keyResponseJson.setErrorJsonCommon(errorJsonCommon);
//        }
        return keyResponseJson;
    }
}
