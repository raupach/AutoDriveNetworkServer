package de.autoDrive.NetworkServer.rest.dto_v1;

import java.util.ArrayList;
import java.util.List;

public class MarkersResponseDto {
    private List<MarkerDto> markers = new ArrayList<>();

    public List<MarkerDto> getMarkers() {
        return markers;
    }

    public void setMarkers(List<MarkerDto> markers) {
        this.markers = markers;
    }
}
