/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author kadhem
 */
public class AnnonceObjetPerdu extends Annonce {
    private String objetDescription;
    private Date lossDate;
    private String losslocation;
    
    public AnnonceObjetPerdu(String objetDescription, Date lossDate, String losslocation, User owner, Date creationDate, Date ExpirationDate) {
        super("Objet Perdu", "", owner, creationDate, ExpirationDate);
        this.objetDescription = objetDescription;
        this.lossDate = lossDate;
        this.losslocation = losslocation;
    }
    public AnnonceObjetPerdu(String objetDescription, Date lossDate, String losslocation, String name, String description, User owner, Date creationDate, Date ExpirationDate) {
        super(name, description, owner, creationDate, ExpirationDate);
        this.objetDescription = objetDescription;
        this.lossDate = lossDate;
        this.losslocation = losslocation;
    }
    
    
}
