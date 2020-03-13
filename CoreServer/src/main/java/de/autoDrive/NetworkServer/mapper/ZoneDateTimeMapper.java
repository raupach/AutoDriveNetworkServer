package de.autoDrive.NetworkServer.mapper;

import de.autoDrive.NetworkServer.rest.RoutesRestPath;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ZoneDateTimeMapper {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(RoutesRestPath.DATE_FORMAT);

    public ZonedDateTime toZoneDateTime(String dateStr) {
        return ZonedDateTime.parse(dateStr, formatter);
    }

    public String toDateStr(ZonedDateTime zonedDateTime) {
        return zonedDateTime.format(formatter);
    }
}
