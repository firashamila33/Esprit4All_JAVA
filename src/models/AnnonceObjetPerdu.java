/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author kadhem
 */
public class AnnonceObjetPerdu extends Annonce {
    private String objetDescription;
    private Date lossDate;
    private String lossLocation;

    public String getObjetDescription() {
        return objetDescription;
    }

    public void setObjetDescription(String objetDescription) {
        this.objetDescription = objetDescription;
    }

    public Date getLossDate() {
        return lossDate;
    }

    public void setLossDate(Date lossDate) {
        this.lossDate = lossDate;
    }

    public String getLossLocation() {
        return lossLocation;
    }

    public void setLossLocation(String lossLocation) {
        this.lossLocation = lossLocation;
    }
    
    public AnnonceObjetPerdu(String objetDescription, Date lossDate, String losslocation, User owner, Date creationDate, Date ExpirationDate) {
        super("Objet Perdu", "", owner, creationDate, ExpirationDate);
        this.objetDescription = objetDescription;
        this.lossDate = lossDate;
        this.lossLocation = losslocation;
    }
    public AnnonceObjetPerdu(String objetDescription, Date lossDate, String losslocation, String name, String description, User owner, Date creationDate, Date ExpirationDate) {
        super(name, description, owner, creationDate, ExpirationDate);
        this.objetDescription = objetDescription;
        this.lossDate = lossDate;
        this.lossLocation = losslocation;
    }
    
    
}
