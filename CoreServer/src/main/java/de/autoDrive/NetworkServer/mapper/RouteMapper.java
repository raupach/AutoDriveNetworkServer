package de.autoDrive.NetworkServer.mapper;

import de.autoDrive.NetworkServer.entity.Route;
import de.autoDrive.NetworkServer.repository.RouteRepository;
import de.autoDrive.NetworkServer.rest.dto_v1.RoutesRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        route.setWaypoints(waypointMapper.toEntity(route, dto.getWaypoints()));
        route.setGroups(groupMapper.toEntity(route, dto.getGroups()));
        route.setMarkers(markerMapper.toEntity(route, dto.getMarkers()));
        routeRepository.save(route);
        return route;
    }
}
