package pl.retrix.smartfarm.exceptions;

public class NawozenieIdNawozeniaExceptionResponse {

    private String idNawozenia;

    public NawozenieIdNawozeniaExceptionResponse(String idNawozenia) {
        this.idNawozenia = idNawozenia;
    }

    public String getIdNawozenia() {
        return idNawozenia;
    }

    public void setIdNawozenia(String idNawozenia) {
        this.idNawozenia = idNawozenia;
    }
}
