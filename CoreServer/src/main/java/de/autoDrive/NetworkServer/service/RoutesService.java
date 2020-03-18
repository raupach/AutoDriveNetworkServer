package de.autoDrive.NetworkServer.service;

import de.autoDrive.NetworkServer.entity.Route;
import de.autoDrive.NetworkServer.mapper.GroupMapper;
import de.autoDrive.NetworkServer.mapper.RouteMapper;
import de.autoDrive.NetworkServer.mapper.WaypointMapper;
import de.autoDrive.NetworkServer.repository.RouteRepository;
import de.autoDrive.NetworkServer.rest.dto_v1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoutesService {

    @Autowired
    private RouteMapper routeMapper;

    @Autowired
    private WaypointMapper waypointMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private RouteRepository routeRepository;

    public RoutesResponseDtos getRoutes() {
        Iterable<Route> routes = routeRepository.findAll();
        return routeMapper.toRoutesResponseDtos(routes);
    }

    public RoutesStoreResponseDto saveNewRoute(RoutesRequestDto dto) {
        RoutesStoreResponseDto routesStoreResponseDto = new RoutesStoreResponseDto();
        Route route = routeMapper.toEntity(dto);
        routesStoreResponseDto.setRouteId(route.getId());
        return routesStoreResponseDto;
    }

    public WaypointsResponseDto getWaypoints(String routeId) {
        WaypointsResponseDto dto = new WaypointsResponseDto();
        routeRepository.findById(routeId).ifPresent(route -> {
            dto.setWaypoints(waypointMapper.toWaypointDto(route.getWaypoints()));
            dto.setGroups(groupMapper.toGroupDto(route.getGroups()));
            dto.setMarkers(waypointMapper.toMarkerDto(route.getWaypoints()));
            dto.setRoute(routeMapper.toRouteDto(route));
        });
        return dto;
    }
}
