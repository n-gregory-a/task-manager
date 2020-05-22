
package ru.naumkin.tm.api.endpoint;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.3.6
 * 2020-05-22T19:31:29.176+07:00
 * Generated source version: 3.3.6
 */

@WebFault(name = "SQLException", targetNamespace = "http://endpoint.api.tm.naumkin.ru/")
public class SQLException_Exception extends java.lang.Exception {

    private ru.naumkin.tm.api.endpoint.SQLException sqlException;

    public SQLException_Exception() {
        super();
    }

    public SQLException_Exception(String message) {
        super(message);
    }

    public SQLException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public SQLException_Exception(String message, ru.naumkin.tm.api.endpoint.SQLException sqlException) {
        super(message);
        this.sqlException = sqlException;
    }

    public SQLException_Exception(String message, ru.naumkin.tm.api.endpoint.SQLException sqlException, java.lang.Throwable cause) {
        super(message, cause);
        this.sqlException = sqlException;
    }

    public ru.naumkin.tm.api.endpoint.SQLException getFaultInfo() {
        return this.sqlException;
    }
}
