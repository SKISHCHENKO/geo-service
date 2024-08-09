package ru.netology.sender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceMock;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceMock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageSenderImplTests {

    @Mock
    private GeoService geoService;

    @Mock
    private LocalizationService localizationService;

    @InjectMocks
    private MessageSenderImpl messageSenderImpl;

    @Test
    public void testSendWithRussianIp() { // с использованием класса Mock
        // Arrange
        String ipAddress = "172.0.32.11";
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipAddress);
        Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        GeoServiceMock geoServiceMock = new GeoServiceMock(location);

        LocalizationServiceMock localizationServiceMock = new LocalizationServiceMock(Country.RUSSIA);
        MessageSenderImpl messageSenderImpl = new MessageSenderImpl(geoServiceMock, localizationServiceMock);

        // Act
        String result = messageSenderImpl.send(headers);

        // Assert
        assertEquals("Добро пожаловать", result);
    }


    @Test
    public void testSendWithAmericanIp() { // использование аннотации Mock
        // Arrange
        String ipAddress = "96.44.183.149";
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipAddress);

        Location location = new Location("New York", Country.USA, " 10th Avenue", 32);
        when(geoService.byIp(ipAddress)).thenReturn(location);
        when(localizationService.locale(Country.USA)).thenReturn("US");

        // Act
        String result = messageSenderImpl.send(headers);

        // Assert
        assertEquals("US", result);
    }

    @Test
    public void testSendWithoutIp() {
        // Arrange
        Map<String, String> headers = new HashMap<>();

        // Act
        // Assert
        assertThrows(NullPointerException.class, () -> messageSenderImpl.send(headers));
    }
}