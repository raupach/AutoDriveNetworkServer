package de.autoDrive.NetworkServer.service;

import de.autoDrive.NetworkServer.entity.Route;
import de.autoDrive.NetworkServer.mapper.RouteMapper;
import de.autoDrive.NetworkServer.rest.dto_v1.RoutesRequestDto;
import de.autoDrive.NetworkServer.rest.dto_v1.RoutesResponseDtos;
import de.autoDrive.NetworkServer.rest.dto_v1.RoutesStoreResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoutesService {

    @Autowired
    private RouteMapper routeMapper;

    public RoutesResponseDtos getRoutes() {
        return null;
    }

    public RoutesStoreResponseDto saveNewRoute(RoutesRequestDto dto) {
        RoutesStoreResponseDto routesStoreResponseDto = new RoutesStoreResponseDto();
        Route route = routeMapper.toEntity(dto);
        routesStoreResponseDto.setRouteId(route.getId());
        return routesStoreResponseDto;
    }
}
