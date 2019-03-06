package pl.retrix.smartfarm.exceptions;

public class InwentarzNrIdExceptionResponse {

    private String nrKolczyka;

    public InwentarzNrIdExceptionResponse(String nrKolczyka) {this.nrKolczyka = nrKolczyka; }

    public String getNrKolczyka() {
        return nrKolczyka;
    }

    public void setNrKolczyka(String nrKolczyka) {
        this.nrKolczyka = nrKolczyka;
    }
}
