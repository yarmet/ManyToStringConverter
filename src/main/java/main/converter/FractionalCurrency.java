package main.converter;

enum FractionalCurrency implements MutliformType {

    BYN("BYN", true, "копейка", "копейки", "копеек"),
    CAD("CAD", false, "цент", "цента", "центов"),
    CHF("CHF", false, "сантим", "сантима", "сантимов"),
    CNY("CNY", false, "Фынь", "Фыня", "Фыней"),
    EUR("EUR", false, "евроцент", "евроцента", "евроцентов"),
    GBP("GBP", false, "пенни", "пенни", "пенни"),
    HKD("HKD", false, "цент", "цент", "цент"),
    JPY("JPY", false, "сен", "сена", "сенов"),
    NOK("NOK", false, "эре", "эре", "эре"),
    PLN("PLN", false, "грош", "гроша", "грошей"),
    SEK("SEK", false, "эре", "эре", "эре"),
    USD("USD", false, "цент", "цента", "центов"),
    CZK("CZK", false, "геллер", "геллера", "геллеров"),
    RUR("RUR", true, "копейка", "копейки", "копеек"),
    RUB("RUB", true, "копейка", "копейки", "копеек");


    private final String isoCode;
    private final boolean female;
    private final String firstForm;
    private final String secondForm;
    private final String thirdForm;


    FractionalCurrency(String isoCode, boolean female, String firstForm, String secondForm, String thirdForm) {
        this.isoCode = isoCode;
        this.female = female;
        this.firstForm = firstForm;
        this.secondForm = secondForm;
        this.thirdForm = thirdForm;
    }


    public String getIsoCode() {
        return isoCode;
    }

    public String getFirstForm() {
        return firstForm;
    }

    public String getSecondForm() {
        return secondForm;
    }

    public String getThirdForm() {
        return thirdForm;
    }

    public boolean isFemale() {
        return female;
    }


}
