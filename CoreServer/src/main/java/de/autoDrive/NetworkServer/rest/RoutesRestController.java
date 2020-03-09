package de.autoDrive.NetworkServer.rest;

import de.autoDrive.NetworkServer.rest.dto_v1.RoutesRequestDto;
import de.autoDrive.NetworkServer.rest.dto_v1.RoutesResponseDtos;
import de.autoDrive.NetworkServer.rest.dto_v1.RoutesStoreResponseDto;
import de.autoDrive.NetworkServer.service.RoutesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static de.autoDrive.NetworkServer.rest.NetworkServiceRestType.X_AUTODRIVE_MEDIA_TYPE;

@RestController
@RequestMapping(RoutesRestPath.ROUTES)
public class RoutesRestController {

    private final static Logger LOG = LoggerFactory.getLogger(RoutesRestController.class);

    @Autowired
    private RoutesService routesService;


    @RequestMapping(value ="",
            method= RequestMethod.GET,
            produces = {NetworkServiceRestType.MEDIATYPE_NETWORKSERVICE_JSON_V1})
    public ResponseEntity<RoutesResponseDtos> getRoutes ()
    {
        LOG.info("--->>>> Incoming getRoutes-Rest.");
        RoutesResponseDtos response = routesService.getRoutes();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        responseHeaders.set(NetworkServiceRestType.X_AUTODRIVE_MEDIA_TYPE , NetworkServiceRestType.MEDIATYPE_NETWORKSERVICE_JSON_V1);
        LOG.info("<<<<--- getRoutes-Rest ende. {}",  LOG.isDebugEnabled() ? response:"");
        return new ResponseEntity<RoutesResponseDtos>(response, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value ="",
            method=RequestMethod.POST,
            produces = {NetworkServiceRestType.MEDIATYPE_NETWORKSERVICE_JSON_V1},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RoutesStoreResponseDto> store(@RequestBody RoutesRequestDto dto) throws Exception
    {
        LOG.info("--->>>> Incoming store-Rest. {}", LOG.isDebugEnabled() ? dto : "");
        RoutesStoreResponseDto sendResult = routesService.saveNewRoute(dto);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        responseHeaders.set(X_AUTODRIVE_MEDIA_TYPE, NetworkServiceRestType.MEDIATYPE_NETWORKSERVICE_JSON_V1);
        LOG.info("<<<<--- store-Rest ende. {}", sendResult);
        return new ResponseEntity<RoutesStoreResponseDto>(sendResult, responseHeaders, HttpStatus.CREATED);
    }

}
