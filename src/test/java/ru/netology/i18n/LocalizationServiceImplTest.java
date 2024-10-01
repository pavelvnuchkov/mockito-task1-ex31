package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @ParameterizedTest
    @CsvSource(value = {
            "RUSSIA, Добро пожаловать",
        "USA, Welcome"})
    void localeTest(String country, String expected) {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        String actual = localizationService.locale(Country.valueOf(country));
        assertEquals(expected, actual);
    }
}