package pl.retrix.smartfarm.exceptions;

import java.util.Date;

public class MlekoDataOdbioruExceptionResponse {

    private Date dataOdbioru;

    public MlekoDataOdbioruExceptionResponse(Date dataOdbioru) {
        this.dataOdbioru = dataOdbioru;
    }

    public Date getDataOdbioru() {
        return dataOdbioru;
    }

    public void setDataOdbioru(Date dataOdbioru) {
        this.dataOdbioru = dataOdbioru;
    }
}
