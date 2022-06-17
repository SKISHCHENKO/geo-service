package ru.netology.i18n;

import ru.netology.entity.Country;

public class LocalizationServiceMock implements LocalizationService {
    private Country country;

    public LocalizationServiceMock(Country country) {
        this.country = country;
    }

    @Override
    public String locale(Country country) {
        switch (country) {
            case RUSSIA:
                return "Добро пожаловать";
            default:
                return "Welcome";
        }
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
