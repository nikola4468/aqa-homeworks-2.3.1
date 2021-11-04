package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static java.time.format.DateTimeFormatter.ofPattern;

@UtilityClass
public class DataGenerator {

    public static String getDate(int day) {
        return LocalDate.now().plusDays(day).format(ofPattern("dd.MM.yyyy"));
    }

    public static RegistrationInfo generationInfo(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return new RegistrationInfo(
                getCity(),
                faker.name().fullName().replace("ё", "е"),
                String.format(faker.phoneNumber().phoneNumber(), "+70000000000"));
    }

    public static String getCity() {
        Random randomCity = new Random();
        List<String> cities = Arrays.asList("Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Белгород",
                "Биробиджан", "Благовещенск", "Брянск", "Великий Новгород", "Владивосток", "Владикавказ", "Владимир",
                "Волгоград", "Вологда", "Воронеж", "Горно-Алтайск", "Грозный", "Екатеринбург", "Иваново", "Ижевск",
                "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома",
                "Краснодар", "Красноярск", "Курган", "Курск", "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп",
                "Махачкала", "Москва", "Мурманск", "Нальчик", "Нарьян-Мар", "Нижний Новгород", "Новосибирск", "Омск",
                "Орёл", "Оренбург", "Пенза", "Пермь", "Петрозаводск", "Петропавловск-Камчатский", "Псков",
                "Ростов-на-Дону", "Рязань", "Салехард", "Самара", "Санкт-Петербург", "Саранск", "Саратов",
                "Севастополь", "Симферополь", "Смоленск", "Ставрополь", "Сыктывкар", "Тамбов", "Тверь", "Томск",
                "Тула", "Тюмень", "Улан-Удэ", "Ульяновск", "Уфа", "Хабаровск", "Ханты-Мансийск", "Чебоксары",
                "Челябинск", "Черкесск", "Чита", "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль");
        return cities.get(randomCity.nextInt(cities.size()));
    }
}