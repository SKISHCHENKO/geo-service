package ru.netology.i18n;

import ru.netology.entity.Country;

import java.util.Objects;

public class LocalizationServiceMock implements LocalizationService {
    private Country country;

    public LocalizationServiceMock(Country country) {
        this.country = country;
    }

    @Override
    public String locale(Country country) {
        if (Objects.requireNonNull(country) == Country.RUSSIA) {
            return "Добро пожаловать";
        }
        return "Welcome";
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
