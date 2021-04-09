/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auteur_finder;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "document", catalog = "", schema = "")
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
    , @NamedQuery(name = "Document.findById", query = "SELECT d FROM Document d WHERE d.id = :id")
    , @NamedQuery(name = "Document.findByAuteur", query = "SELECT d FROM Document d WHERE d.auteur = :auteur")
    , @NamedQuery(name = "Document.findByNomDocument", query = "SELECT d FROM Document d WHERE d.nomDocument = :nomDocument")
    , @NamedQuery(name = "Document.findByChempDocument", query = "SELECT d FROM Document d WHERE d.chempDocument = :chempDocument")})
public class Document implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "auteur")
    private String auteur;
    @Basic(optional = false)
    @Column(name = "nom_document")
    private String nomDocument;
    @Basic(optional = false)
    @Column(name = "chemp_document")
    private String chempDocument;

    public Document() {
    }

    public Document(Integer id) {
        this.id = id;
    }

    public Document(Integer id, String auteur, String nomDocument, String chempDocument) {
        this.id = id;
        this.auteur = auteur;
        this.nomDocument = nomDocument;
        this.chempDocument = chempDocument;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        String oldAuteur = this.auteur;
        this.auteur = auteur;
        changeSupport.firePropertyChange("auteur", oldAuteur, auteur);
    }

    public String getNomDocument() {
        return nomDocument;
    }

    public void setNomDocument(String nomDocument) {
        String oldNomDocument = this.nomDocument;
        this.nomDocument = nomDocument;
        changeSupport.firePropertyChange("nomDocument", oldNomDocument, nomDocument);
    }

    public String getChempDocument() {
        return chempDocument;
    }

    public void setChempDocument(String chempDocument) {
        String oldChempDocument = this.chempDocument;
        this.chempDocument = chempDocument;
        changeSupport.firePropertyChange("chempDocument", oldChempDocument, chempDocument);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "auteur_finder.Document[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
