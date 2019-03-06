package pl.retrix.smartfarm.exceptions;

public class MlekoIloscExceptionResponse {

    private String iloscMleko;

    public MlekoIloscExceptionResponse(String iloscMleko) {
        this.iloscMleko = iloscMleko;
    }

    public String getIloscMleko() {
        return iloscMleko;
    }

    public void setIloscMleko(String iloscMleko) {
        this.iloscMleko = iloscMleko;
    }
}
