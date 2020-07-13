package helpers;

public class TestData {
    private static final int random = (int) (Math.random() * 1000);

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
    public static final String loanApplicationText = "Заявка на займ";
    public static final String PhoneVerificationText = "Подтверждение номера телефона";
    public static final String PassportPageHeadingText = "Паспортные данные";
    public static final String AddressesPageHeadingText = "Ваши адреса";


    public static final String lastNameData = "Иванов";
    public static final String firstNameData = "Иван";
    public static final String middleNameData = "Иванович";
    public static final String emailData = random + "glad" + random + "@mail.ru";
    public static final String phoneData = "79235500" + random;
    public static final String acceptPhoneData = "123456";
    public static final int passportData = 1848455111;
    public static final String passportDateData = "11112014";
    public static final String birthdayData = "11111998";
    public static final String subdivisionData = "11112014";
    public static final String issuerData = "УФМС ПО ГОРОДУ ГОРОДОВ";
    public static final String birthplaceData = "Кемерово";
    public static final String registeredAddressData = "г Кемерово, ул Терешковой, д 25, кв 24";
    public static final String ownerName = "Виталий Витальевич";


}
