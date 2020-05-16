package de.autoDrive.NetworkServer.service;

import de.autoDrive.NetworkServer.helper.ImageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;

@Service
public class TileService {

    private final static Logger LOG = LoggerFactory.getLogger(MapService.class);

    @Autowired
    private MapService mapService;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) throws IOException {
        LOG.info("Check Maps.");

        for (int i = 0; i < 7; i++) {

            mapService.runTileCheck(i,"FELSBRUNN");
        }
    }

}
