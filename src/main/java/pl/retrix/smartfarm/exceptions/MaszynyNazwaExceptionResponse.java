package pl.retrix.smartfarm.exceptions;

public class MaszynyNazwaExceptionResponse {

    private String nazwaMaszyny;

    public MaszynyNazwaExceptionResponse(String nazwaMaszyny) { this.nazwaMaszyny = nazwaMaszyny;}

    public String getNazwaMaszyny() { return nazwaMaszyny; }

    public void setNazwaMaszyny(String nazwaMaszyny) {
        this.nazwaMaszyny = nazwaMaszyny;
    }
}
