package org.lle.palabres.action;

import com.opensymphony.xwork2.ActionSupport;

import org.example.palabres.model.exception.FunctionalException;
import org.example.palabres.model.exception.NotFoundException;
import org.example.palabres.model.exception.TechnicalException;


/**
 * Action de démo pour la gestion des exceptions
 */
public class ExceptionAction extends ActionSupport {


    public String doTechnicalException() throws TechnicalException {
        throw new TechnicalException("Une TechnicalException pour la démo...");
    }


    public String doNotFoundException() throws NotFoundException {
        throw new NotFoundException("Une NotFoundException pour la démo...");
    }


    public String doFunctionalException() throws FunctionalException {
        throw new FunctionalException("Une FunctionalException pour la démo...");
    }
}