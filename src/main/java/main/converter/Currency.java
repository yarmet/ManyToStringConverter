package main.converter;

public enum Currency implements MutliformType {

    BYN("BYN", false, "белорусский рубль", "белорусских рубля", "белорусских рублей"),
    CAD("CAD", false, "канадский доллар", "канадских доллара", "канадских долларов"),
    CHF("CHF", false, "швейцарский франк", "швейцарских франка", "швейцарских франков"),
    CNY("CNY", false, "китайский юань", "китайских юаня", "китайских юаней"),
    CZK("CZK", true, "чешская крона", "чешских кроны", "чешских крон"),
    EUR("EUR", false, "евро", "евро", "Евро"),
    GBP("GBP", false, "английский фунт стерлингов", "английских фунта стерлинга", "английских фунтов стерлингов"),
    HKD("HKD", false, "гонконский доллар", "гонконских доллара", "гонконских долларов"),
    JPY("JPY", true, "японская иена", "японских иены", "японских иен"),
    NOK("NOK", true, "норвежская крона", "норвежских кроны", "норвежских крон"),
    PLN("PLN", false, "польский злотый", "польских злотых", "польских злотых"),
    RUB("RUB", false, "российский рубль", "российских рубля", "российских рублей"),
    RUR("RUR", false, "российский Рубль", "российских рубля", "российских рублей"),
    SEK("SEK", true, "шведская крона", "шведских кроны", "шведских крон"),
    USD("USD", false, "доллар США", "доллара США", "долларов США");


    private final String isoCode;
    private final boolean female;
    private final String firstForm;
    private final String secondForm;
    private final String thirdForm;


    Currency(String isoCode, boolean female, String firstForm, String secondForm, String thirdForm) {
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
