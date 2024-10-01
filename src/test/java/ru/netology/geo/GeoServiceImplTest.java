package ru.netology.geo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @ParameterizedTest
    @CsvSource(value = {
            "127.0.0.1, null, null, null, 0",
            "172.0.32.11, Moscow, RUSSIA, Lenina, 15",
            "172.11.144.38, Moscow, RUSSIA, null, 0",
            "96.44.183.149, New York, USA, 10th Avenue, 32",
            "96.11.123.66, New York, USA, null, 0"})
    void byIp(String ip, String city, String country, String street, String building) {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp(ip);
        String[] actual = {String.valueOf(location.getCity()),
                String.valueOf(location.getCountry()),
                String.valueOf(location.getStreet()),
                String.valueOf(location.getBuiling())};
        String[] expected = {city,
                country,
                street,
                building};
        assertArrayEquals(expected, actual);
    }

    @Test
    void byCoordinates() {
        GeoServiceImpl geoService = new GeoServiceImpl();


        assertThrows(RuntimeException.class, () -> geoService.byCoordinates(1.2, 1.1));
    }
}