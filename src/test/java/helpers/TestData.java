package helpers;

import java.util.Random;

public class TestData {
    private static final int random = (int) (Math.random() * 10000);

    public static final String url = "http://the-internet.herokuapp.com/login";
    public static final String username = "tomsmith";
    public static final String password = "SuperSecretPassword!";
    public static final String expectedUrl = "http://the-internet.herokuapp.com/secure";
    public static final String loginText = "Welcome to the Secure Area. When you are done click logout below.";
    public static final String alertUserNameText = "Your username is invalid!\n" + "×";
    public static final String alertPasswordText = "Your password is invalid!\n" + "×";
    public static final String invalid = "invalid";

    // Robo-data
    public static final String roboUrl = "http://127.0.0.1";
    public static final String roboUrlAdmin = "http://127.0.0.1/employee/login";
    public static final String loanApplicationText = "Заявка на займ";
    public static final String phoneVerificationText = "Подтверждение номера телефона";
    public static final String passportPageHeadingText = "Паспортные данные";
    public static final String addressesPageHeadingText = "Дополнительные контакты";

    //client
    public static final String lastNameData =  randomStr();
    public static final String firstNameData =  randomStr();
    public static final String middleNameData =  randomStr();
    public static final String fullName = lastNameData + " " + firstNameData + " " + middleNameData;
    public static final String emailData = random + "cheat" + random + "@mail.ru";
    public static final String phoneData = "79235500" + random;

    public static final String acceptPhoneData = "123456";
    // passport
    public static final String passportData = "55" + random + random;
    public static final String passportDateData = "11112014";
    public static final String birthdayData = "11111994";
    public static final String subdivisionData = "11112014";
    public static final String issuerData = "УФМС ПО ГОРОДУ ГОРОДОВ";
    public static final String birthplaceData = "Кемерово";
    // address
    public static final String registeredAddressData = "г Кемерово, ул Терешковой, д 25, кв 24";
    public static final String ownerName = "Виталий Витальевич";

    // admin
    public static final String adminLoginData = "admin";
    public static final String adminPassData = "admin1";
    public static final String textToAdminTitle = "Общая информация";
    public static final String textToAdminTitleClients = "Список клиентов";

    private static String randomStr() {
        char[] chars = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя".toCharArray();
        StringBuilder sb = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
