package de.autoDrive.NetworkServer.mapper;

import de.autoDrive.NetworkServer.entity.Route;
import de.autoDrive.NetworkServer.repository.RouteRepository;
import de.autoDrive.NetworkServer.rest.dto_v1.RouteDto;
import de.autoDrive.NetworkServer.rest.dto_v1.RoutesRequestDto;
import de.autoDrive.NetworkServer.rest.dto_v1.RoutesResponseDtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RouteMapper {

    @Autowired
    private WaypointMapper waypointMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private ZoneDateTimeMapper zoneDateTimeMapper;


    public Route toEntity(RoutesRequestDto dto) {
        Route route = new Route();
        route.setDate(zoneDateTimeMapper.toZoneDateTime(dto.getDate()));
        route.setUploaded(ZonedDateTime.now());
        route.setMap(dto.getMap());
        route.setName(dto.getName());
        route.setUsername(dto.getUsername());
        route.setDescription(dto.getDescription());
        route.setRevision(dto.getRevision());
        routeRepository.save(route);
        route.setGroups(groupMapper.toEntity(route, dto.getGroups()));
        route.setWaypoints(waypointMapper.toEntity(route, dto.getWaypoints(), dto.getMarkers()));
        route.setUpdated(ZonedDateTime.now());
        return route;
    }

    public RoutesResponseDtos toRoutesResponseDtos(Iterable<Route> routes) {
        RoutesResponseDtos routesResponseDtos = new RoutesResponseDtos();
        List<RouteDto> routeDtos = StreamSupport.stream(routes.spliterator(), false).map(this::toRouteDto).collect(Collectors.toList());
        routesResponseDtos.setRoutes(routeDtos);

        return routesResponseDtos;
    }

    public RouteDto toRouteDto(Route route) {
        RouteDto dto = new RouteDto();
        dto.setDate(zoneDateTimeMapper.toDateStr(route.getDate()));
        dto.setUpdated(route.getUpdated()!=null?zoneDateTimeMapper.toDateStr(route.getUpdated()):null);
        dto.setUploaded(route.getUploaded()!=null?zoneDateTimeMapper.toDateStr(route.getUploaded()):null);
        dto.setDescription(route.getDescription());
        dto.setUsername(route.getUsername());
        dto.setMap(route.getMap());
        dto.setName(route.getName());
        dto.setRevision(route.getRevision());
        dto.setId(route.getId());
        return dto;
    }
}
