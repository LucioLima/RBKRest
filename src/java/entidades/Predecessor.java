/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luciolima
 */
@Entity
@Table(name = "predecessor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predecessor.findAll", query = "SELECT p FROM Predecessor p"),
    @NamedQuery(name = "Predecessor.findByIdpredecessor", query = "SELECT p FROM Predecessor p WHERE p.idpredecessor = :idpredecessor"),
    @NamedQuery(name = "Predecessor.findByIdjobPredecessor", query = "SELECT p FROM Predecessor p WHERE p.idjobPredecessor = :idjobPredecessor"),
    @NamedQuery(name = "Predecessor.findByNomePredecessor", query = "SELECT p FROM Predecessor p WHERE p.nomePredecessor = :nomePredecessor")})
public class Predecessor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpredecessor")
    private Integer idpredecessor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idjob_predecessor")
    private int idjobPredecessor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome_predecessor")
    private String nomePredecessor;
    @JoinColumn(name = "job_idjob", referencedColumnName = "idjob")
    @ManyToOne(optional = false)
    private Job jobIdjob;

    public Predecessor() {
    }

    public Predecessor(Integer idpredecessor) {
        this.idpredecessor = idpredecessor;
    }

    public Predecessor(Integer idpredecessor, int idjobPredecessor, String nomePredecessor) {
        this.idpredecessor = idpredecessor;
        this.idjobPredecessor = idjobPredecessor;
        this.nomePredecessor = nomePredecessor;
    }

    public Integer getIdpredecessor() {
        return idpredecessor;
    }

    public void setIdpredecessor(Integer idpredecessor) {
        this.idpredecessor = idpredecessor;
    }

    public int getIdjobPredecessor() {
        return idjobPredecessor;
    }

    public void setIdjobPredecessor(int idjobPredecessor) {
        this.idjobPredecessor = idjobPredecessor;
    }

    public String getNomePredecessor() {
        return nomePredecessor;
    }

    public void setNomePredecessor(String nomePredecessor) {
        this.nomePredecessor = nomePredecessor;
    }

    public Job getJobIdjob() {
        return jobIdjob;
    }

    public void setJobIdjob(Job jobIdjob) {
        this.jobIdjob = jobIdjob;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpredecessor != null ? idpredecessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predecessor)) {
            return false;
        }
        Predecessor other = (Predecessor) object;
        if ((this.idpredecessor == null && other.idpredecessor != null) || (this.idpredecessor != null && !this.idpredecessor.equals(other.idpredecessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Predecessor[ idpredecessor=" + idpredecessor + " ]";
    }
    
}
