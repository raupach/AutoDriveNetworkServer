package de.autoDrive.NetworkServer.rest;

import de.autoDrive.NetworkServer.rest.dto_v1.RoutesRequestDto;
import de.autoDrive.NetworkServer.rest.dto_v1.RoutesResponseDtos;
import de.autoDrive.NetworkServer.rest.dto_v1.RoutesStoreResponseDto;
import de.autoDrive.NetworkServer.rest.dto_v1.WaypointsResponseDto;
import de.autoDrive.NetworkServer.service.RoutesService;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
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
        long start = System.currentTimeMillis();
        LOG.info("--->>>> Incoming getRoutes-Rest.");
        RoutesResponseDtos response = routesService.getRoutes();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        responseHeaders.set(NetworkServiceRestType.X_AUTODRIVE_MEDIA_TYPE , NetworkServiceRestType.MEDIATYPE_NETWORKSERVICE_JSON_V1);
        LOG.info("<<<<--- getRoutes-Rest ende. {}ms, {}", System.currentTimeMillis()-start, LOG.isDebugEnabled() ? response:"");
        return new ResponseEntity<RoutesResponseDtos>(response, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value ="{routeId}"+RoutesRestPath.WAYPOINTS,
            method= RequestMethod.GET,
            produces = {NetworkServiceRestType.MEDIATYPE_NETWORKSERVICE_JSON_V1})
    public ResponseEntity<WaypointsResponseDto> getWaypoints (@PathVariable String routeId)
    {
        long start = System.currentTimeMillis();
        LOG.info("--->>>> Incoming getWaypoints-Rest.");
        WaypointsResponseDto response = routesService.getWaypoints(routeId);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        responseHeaders.set(NetworkServiceRestType.X_AUTODRIVE_MEDIA_TYPE , NetworkServiceRestType.MEDIATYPE_NETWORKSERVICE_JSON_V1);
        LOG.info("<<<<--- getWaypoints-Rest ende. {}ms, {}", System.currentTimeMillis()-start,  LOG.isDebugEnabled() ? response:"");
        return new ResponseEntity<WaypointsResponseDto>(response, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value ="",
            method=RequestMethod.POST,
            produces = {NetworkServiceRestType.MEDIATYPE_NETWORKSERVICE_JSON_V1},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RoutesStoreResponseDto> store(@RequestBody RoutesRequestDto dto, KeycloakAuthenticationToken authentication) throws Exception
    {
        long start = System.currentTimeMillis();
        LOG.info("--->>>> Incoming store-Rest. {}", LOG.isDebugEnabled() ? dto : "");
        RoutesStoreResponseDto sendResult = routesService.saveNewRoute(dto, getkeycloakUserId(authentication), getUsername(authentication));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        responseHeaders.set(X_AUTODRIVE_MEDIA_TYPE, NetworkServiceRestType.MEDIATYPE_NETWORKSERVICE_JSON_V1);
        LOG.info("<<<<--- store-Rest ende. {}ms, {}", System.currentTimeMillis()-start, sendResult);
        return new ResponseEntity<RoutesStoreResponseDto>(sendResult, responseHeaders, HttpStatus.CREATED);
    }

    private String getkeycloakUserId(KeycloakAuthenticationToken authentication) {
        if (authentication!=null) {
            return authentication.getAccount().getKeycloakSecurityContext().getToken().getSubject();
        } else {
            return "N.N.";
        }
    }

    private String getUsername(KeycloakAuthenticationToken authentication) {
        if (authentication!=null) {
            return authentication.getAccount().getKeycloakSecurityContext().getToken().getPreferredUsername();
        } else {
            return "N.N.";
        }
    }

}
