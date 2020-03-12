package de.autoDrive.NetworkServer.rest.dto_v1;

import java.util.ArrayList;
import java.util.List;

public class RoutesResponseDtos {
    private List<RouteDto> routes = new ArrayList<>();

    public List<RouteDto> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteDto> routes) {
        this.routes = routes;
    }
}
