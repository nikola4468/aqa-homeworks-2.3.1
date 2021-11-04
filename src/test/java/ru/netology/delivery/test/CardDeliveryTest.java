package ru.netology.delivery.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.delivery.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {
    int planDate = 3;
    int rePlanDate = 4;

    String day = DataGenerator.getDate(planDate);
    String nextDay = DataGenerator.getDate(planDate + rePlanDate);

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldRegisterByOrderCardRePlan() {
        var user = DataGenerator.generationInfo("ru");
        String city = user.getCity();
        String name = user.getName();
        String phone = user.getPhone();

        $("[data-test-id='city'] .input__control").setValue(city);
        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id='date'] .input__control").setValue(day);
        $("[data-test-id='name'] .input__control").setValue(name);
        $("[data-test-id='phone'] .input__control").setValue(phone);
        $("[data-test-id='agreement']").click();
        $(withText("Запланировать")).click();
        $("[data-test-id='success-notification'] .notification__content").shouldHave(exactText("Встреча успешно запланирована на " + day), Duration.ofSeconds(15));
        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id='date'] .input__control").setValue(nextDay);
        $(withText("Запланировать")).click();
        $("[data-test-id='replan-notification'] .button__text").click();
        $("[data-test-id='success-notification'] .notification__content").shouldHave(exactText("Встреча успешно запланирована на " + nextDay), Duration.ofSeconds(15));
    }
}
