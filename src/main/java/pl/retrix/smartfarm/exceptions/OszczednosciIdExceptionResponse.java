package pl.retrix.smartfarm.exceptions;

public class OszczednosciIdExceptionResponse {

    private String idOszczednosci;

    public OszczednosciIdExceptionResponse(String idOszczednosci) {
        this.idOszczednosci = idOszczednosci;
    }

    public String getIdOszczednosci() {
        return idOszczednosci;
    }

    public void setIdOszczednosci(String idOszczednosci) {
        this.idOszczednosci = idOszczednosci;
    }
}
