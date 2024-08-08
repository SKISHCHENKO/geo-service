package ru.netology.geo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

@RunWith(MockitoJUnitRunner.class)
public class GeoServiceImplTests {

    public GeoServiceImplTests() {
    }

    @Test
    public void byIpTestLocal() {
        //arrange
        GeoServiceImpl geoServiceimpl = new GeoServiceImpl();
        Location actual = geoServiceimpl.byIp(GeoServiceImpl.LOCALHOST);
        //act
        Location expected = new Location(null, null, null, 0);
        //assert
        Assert.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "127.0.0.1, , , , 0",
            "172.0.32.11, Moscow, RUSSIA, Lenina, 15",
            "96.44.183.149, New York, USA, 10th Avenue, 32",
            "172.0.0.0, Moscow, RUSSIA, , 0",
            "96.0.0.0, New York, USA, , 0"
    })
    public void byIpTest(String ip, String city, Country country, String street, int builing) {
        //arrange
        GeoServiceImpl geoServiceimpl = new GeoServiceImpl();
        Location actual = geoServiceimpl.byIp(ip);
        //act
        Location expected = new Location(city, country, street, builing);
        //assert
        Assert.assertEquals(expected, actual);
    }

}
