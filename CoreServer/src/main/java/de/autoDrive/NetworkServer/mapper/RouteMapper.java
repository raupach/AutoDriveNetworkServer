package de.autoDrive.NetworkServer.mapper;

import de.autoDrive.NetworkServer.entity.Route;
import de.autoDrive.NetworkServer.repository.RouteRepository;
import de.autoDrive.NetworkServer.rest.dto_v1.RouteDto;
import de.autoDrive.NetworkServer.rest.dto_v1.RoutesRequestDto;
import de.autoDrive.NetworkServer.rest.dto_v1.RoutesResponseDtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private MarkerMapper markerMapper;

    @Autowired
    private RouteRepository routeRepository;

    public Route toEntity(RoutesRequestDto dto) {
        Route route = new Route();
        route.setDate(dto.getDate());
        route.setMap(dto.getMap());
        route.setName(dto.getName());
        route.setRevision(dto.getRevision());
        routeRepository.save(route);
        route.setWaypoints(waypointMapper.toEntity(route, dto.getWaypoints()));
        route.setGroups(groupMapper.toEntity(route, dto.getGroups()));
        route.setMarkers(markerMapper.toEntity(route, dto.getMarkers()));
        return route;
    }

    public RoutesResponseDtos toRoutesResponseDtos(Iterable<Route> routes) {
        RoutesResponseDtos routesResponseDtos = new RoutesResponseDtos();
        List<RouteDto> routeDtos = StreamSupport.stream(routes.spliterator(), false).map(this::toRouteDto).collect(Collectors.toList());
        routesResponseDtos.setRoutes(routeDtos);

        return routesResponseDtos;
    }

    private RouteDto toRouteDto(Route route) {
        RouteDto dto = new RouteDto();
        dto.setDate(route.getDate());
        dto.setMap(route.getMap());
        dto.setName(route.getName());
        dto.setRevision(route.getRevision());
        return dto;
    }
}
