package ru.netology.i18n;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import ru.netology.entity.Country;


@RunWith(MockitoJUnitRunner.class)
public class LocalizationServiceTests {

    public LocalizationServiceTests(){}
    @Test
    public void localeTestRussia(){
        //arrange
        LocalizationServiceImpl localizationServiceImpl = new LocalizationServiceImpl();
        String actual = localizationServiceImpl.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";

        //assert
        Assert.assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({
            "RUSSIA, Добро пожаловать ",
            "GERMANY, Welcome",
            "USA, Welcome",
            "BRAZIL, Welcome"
    })
    public void localeTest(Country country, String expected) {
        //arrange
        LocalizationServiceImpl localizationServiceImpl = new LocalizationServiceImpl();
        String actual = localizationServiceImpl.locale(country);

        //assert
        Assert.assertEquals(expected, actual);

    }

}
