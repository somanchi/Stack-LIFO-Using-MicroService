package sp.sample.simpleCurd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sp.sample.simpleCurd.dao.DataObject;
import sp.sample.simpleCurd.service.DataAccessService;

import static sp.sample.simpleCurd.utils.Constants.VERSION;

@RestController
@RequestMapping(VERSION)
@Slf4j
public class CurdController {

    @Autowired
    private DataAccessService dataAccessService;

    @PostMapping("/application/push")
    private ResponseEntity pushData(@RequestBody String object) {
        log.info("pushing object" + object);
        DataObject dataObject = new DataObject();
        dataObject.setItem(object);
        String item =dataAccessService.insertObject(dataObject);
        return ResponseEntity.ok("Item Inserted is : " + item);
    }

    @DeleteMapping("/application/pop")
    private ResponseEntity popData() {
        log.info("popping an Object");
        String item =dataAccessService.deleteObject();
        return ResponseEntity.ok("Top Element is : " + item);
    }
}
