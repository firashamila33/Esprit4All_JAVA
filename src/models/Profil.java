/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author YACINE
 */
public class Profil {
    private int id;
    private User u;
    private String matiereC;
    private String description;
    private String classe;
    private String pathImg;
    private String pathCv;
    private String linkFb;
    private String linkId;
    private String linkG;
    private String linkWeb;
    private String tel;

    public Profil(int id, User u, String matiereC, String description, String classe, String pathImg, String pathCv, String linkFb, String linkId, String linkG, String linkWeb, String tel) {
        this.id = id;
        this.u = u;
        this.matiereC = matiereC;
        this.description = description;
        this.classe = classe;
        this.pathImg = pathImg;
        this.pathCv = pathCv;
        this.linkFb = linkFb;
        this.linkId = linkId;
        this.linkG = linkG;
        this.linkWeb = linkWeb;
        this.tel = tel;
    }
    
        public Profil(User u, String matiereC, String description, String classe, String pathImg, String pathCv, String linkFb, String linkId, String linkG, String linkWeb, String tel) {
        this.u = u;
        this.matiereC = matiereC;
        this.description = description;
        this.classe = classe;
        this.pathImg = pathImg;
        this.pathCv = pathCv;
        this.linkFb = linkFb;
        this.linkId = linkId;
        this.linkG = linkG;
        this.linkWeb = linkWeb;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public String getMatiereC() {
        return matiereC;
    }

    public void setMatiereC(String matiereC) {
        this.matiereC = matiereC;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }

    public String getPathCv() {
        return pathCv;
    }

    public void setPathCv(String pathCv) {
        this.pathCv = pathCv;
    }

    public String getLinkFb() {
        return linkFb;
    }

    public void setLinkFb(String linkFb) {
        this.linkFb = linkFb;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getLinkG() {
        return linkG;
    }

    public void setLinkG(String linkG) {
        this.linkG = linkG;
    }

    public String getLinkWeb() {
        return linkWeb;
    }

    public void setLinkWeb(String linkWeb) {
        this.linkWeb = linkWeb;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Profil{" + "id=" + id + ", User_id=" + u.getId() + ", matiereC=" + matiereC + ", description=" + description + ", classe=" + classe + ", pathImg=" + pathImg + ", pathCv=" + pathCv + ", linkFb=" + linkFb + ", linkId=" + linkId + ", linkG=" + linkG + ", linkWeb=" + linkWeb + ", tel=" + tel + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profil other = (Profil) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.matiereC, other.matiereC)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.classe, other.classe)) {
            return false;
        }
        if (!Objects.equals(this.pathImg, other.pathImg)) {
            return false;
        }
        if (!Objects.equals(this.pathCv, other.pathCv)) {
            return false;
        }
        if (!Objects.equals(this.linkFb, other.linkFb)) {
            return false;
        }
        if (!Objects.equals(this.linkId, other.linkId)) {
            return false;
        }
        if (!Objects.equals(this.linkG, other.linkG)) {
            return false;
        }
        if (!Objects.equals(this.linkWeb, other.linkWeb)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.u, other.u)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
