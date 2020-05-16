package de.autoDrive.NetworkServer.rest;

import de.autoDrive.NetworkServer.service.MapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(RoutesRestPath.MAPS)
public class MapRestController {

    private final static Logger LOG = LoggerFactory.getLogger(MapRestController.class);

    @Autowired
    private MapService mapService;

    @RequestMapping(value = "{name}" + RoutesRestPath.LEVEL + "/{level}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> getMap(@PathVariable String name, @PathVariable int level, @RequestParam int x, @RequestParam int y) throws IOException {
        LOG.info("--->>>> Incoming getMap-Rest level: {}, x: {}, y: {}.", level, x, y);
        HttpHeaders headers = new HttpHeaders();
        byte[] response = mapService.getMap(name, level, x, y);
        if (response != null) {
            return new ResponseEntity<byte[]>(response, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<byte[]>(null, headers, HttpStatus.NOT_FOUND);
        }
    }
}
