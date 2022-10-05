package main.converter;


enum Degree implements MutliformType {

    TRILLION(1000000000000L, "триллион", "триллиона", "триллионов", false),
    BILLION(1000000000L, "миллиард", "миллиарда", "миллиардов", false),
    MILLION(1000000L, "миллион", "миллиона", "миллионов", false),
    THOUSAND(1000L, "тысяча", "тысячи", "тысяч", true), // тысяча может звучать в женском роде
    EMPTY(1L, "", "", "", true); // числа: (одна, две могут быть в женском роде)

    private final long length;
    private final String firstForm;
    private final String secondForm;
    private final String thirdForm;
    private final boolean female;

    Degree(long length, String firstForm, String secondForm, String thirdForm, boolean female) {
        this.length = length;
        this.firstForm = firstForm;
        this.secondForm = secondForm;
        this.thirdForm = thirdForm;
        this.female = female;
    }

    public long getLength() {
        return length;
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

    public boolean hasName() {
        return length > 1L;
    }

    public boolean isFemale() {
        return female;
    }
}
