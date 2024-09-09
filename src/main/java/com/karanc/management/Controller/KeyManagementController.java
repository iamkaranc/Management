package com.karanc.management.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.karanc.management.Json.ErrorJsonCommon;
import com.karanc.management.Json.KeyRequestJson;
import com.karanc.management.Json.KeyResponseJson;
import com.karanc.management.Service.KeyManagementService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/key/management")
public class KeyManagementController {

    private static final Logger logger = Logger.getLogger(String.valueOf(KeyManagementController.class));
    private static final Gson gson = new GsonBuilder().setDateFormat("dd/mm/yyyy HH:mm:ss").create();

    @Autowired
    private KeyManagementService keyManagementService;

    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck() {
        logger.info("Successfully started the KeyManagement Application");
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @PostMapping(value = "/generate/keys")
    public ResponseEntity<String> generateKeys(@RequestBody String body) {
        logger.info("Request received in generate/keys api");
        KeyResponseJson keyResponseJson = new KeyResponseJson();
        KeyRequestJson keyRequestJson;

        try {
            keyRequestJson = gson.fromJson(body, KeyRequestJson.class);
        } catch (Exception e) {
            logger.info("Unable to parse the request body");
            ErrorJsonCommon errorJsonCommon = new ErrorJsonCommon();
            errorJsonCommon.setErrorMessage("Bad Request");
            errorJsonCommon.setErrorCode("434");
            keyResponseJson.setErrorJsonCommon(errorJsonCommon);
            return new ResponseEntity<>(gson.toJson(keyResponseJson), HttpStatus.OK);
        }

        try {
            logger.info("Inside first block");
            keyResponseJson = keyManagementService.postKeys(keyRequestJson);
            if(keyResponseJson.getErrorJsonCommon() != null) {
                //Error Section
                return new ResponseEntity<>(gson.toJson(keyResponseJson), HttpStatus.OK);
            }
             else {
                 //Success Section
                return new ResponseEntity<>(gson.toJson(keyResponseJson), HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.info("Unknown Error Occured");

            return new ResponseEntity<>("InternalServerError", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/get/availableKey")
    public ResponseEntity<String> getAvailableKey() {
        logger.info("Request received in available/key api");
        KeyResponseJson keyResponseJson = new KeyResponseJson();

        try {
            logger.info("Inside first block");
            keyResponseJson = keyManagementService.getAvailableKey();
            if(keyResponseJson.getErrorJsonCommon() != null) {
                //Error Section
                return new ResponseEntity<>(gson.toJson(keyResponseJson), HttpStatus.OK);
            }
            else {
                //Success Section
                return new ResponseEntity<>(gson.toJson(keyResponseJson), HttpStatus.OK);
            }
        }catch(Exception e) {
            logger.info("Unknown Error Occured");

            return new ResponseEntity<>("InternalServerError", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping(value = "/get/key")
    public ResponseEntity<String> getKey(@RequestParam String key) {
        logger.info("Request received in get/key api");
        KeyResponseJson keyResponseJson = new KeyResponseJson();

        try {
            logger.info("Inside first block");
            keyResponseJson = keyManagementService.getKey(key);
            if(keyResponseJson.getErrorJsonCommon() != null) {
                //Error Section
                return new ResponseEntity<>(gson.toJson(keyResponseJson), HttpStatus.OK);
            }
            else {
                //Success Section
                return new ResponseEntity<>(gson.toJson(keyResponseJson), HttpStatus.OK);
            }
        }catch(Exception e) {
            logger.info("Unknown Error Occured");

            return new ResponseEntity<>("InternalServerError", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/delete/key")
    public ResponseEntity<String> deleteKey(@RequestParam String key) {
        logger.info("Request received in delete/key api");
        KeyResponseJson keyResponseJson = new KeyResponseJson();

        try {
            logger.info("Inside first block");
            keyResponseJson = keyManagementService.deleteKey(key);
            if(keyResponseJson.getErrorJsonCommon() != null) {
                //Error Section
                return new ResponseEntity<>(gson.toJson(keyResponseJson), HttpStatus.OK);
            }
            else {
                //Success Section
                return new ResponseEntity<>(gson.toJson(keyResponseJson), HttpStatus.OK);
            }
        }catch(Exception e) {
            logger.info("Unknown Error Occured");

            return new ResponseEntity<>("InternalServerError", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
