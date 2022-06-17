package ru.netology.geo;

import ru.netology.entity.Location;

public class GeoServiceMock implements GeoService {
    private Location location;

    public GeoServiceMock(Location location) {
        this.location = location;
    }

    @Override
    public Location byIp(String ip) {
        return location;
    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {
        return location;
    }
}
