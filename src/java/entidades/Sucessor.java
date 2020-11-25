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
@Table(name = "sucessor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucessor.findAll", query = "SELECT s FROM Sucessor s"),
    @NamedQuery(name = "Sucessor.findByIdsucessor", query = "SELECT s FROM Sucessor s WHERE s.idsucessor = :idsucessor"),
    @NamedQuery(name = "Sucessor.findByIdjobSucessor", query = "SELECT s FROM Sucessor s WHERE s.idjobSucessor = :idjobSucessor"),
    @NamedQuery(name = "Sucessor.findByNomeSucessor", query = "SELECT s FROM Sucessor s WHERE s.nomeSucessor = :nomeSucessor")})
public class Sucessor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsucessor")
    private Integer idsucessor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idjob_sucessor")
    private int idjobSucessor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome_sucessor")
    private String nomeSucessor;
    @JoinColumn(name = "job_idjob", referencedColumnName = "idjob")
    @ManyToOne(optional = false)
    private Job jobIdjob;

    public Sucessor() {
    }

    public Sucessor(Integer idsucessor) {
        this.idsucessor = idsucessor;
    }

    public Sucessor(Integer idsucessor, int idjobSucessor, String nomeSucessor) {
        this.idsucessor = idsucessor;
        this.idjobSucessor = idjobSucessor;
        this.nomeSucessor = nomeSucessor;
    }

    public Integer getIdsucessor() {
        return idsucessor;
    }

    public void setIdsucessor(Integer idsucessor) {
        this.idsucessor = idsucessor;
    }

    public int getIdjobSucessor() {
        return idjobSucessor;
    }

    public void setIdjobSucessor(int idjobSucessor) {
        this.idjobSucessor = idjobSucessor;
    }

    public String getNomeSucessor() {
        return nomeSucessor;
    }

    public void setNomeSucessor(String nomeSucessor) {
        this.nomeSucessor = nomeSucessor;
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
        hash += (idsucessor != null ? idsucessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucessor)) {
            return false;
        }
        Sucessor other = (Sucessor) object;
        if ((this.idsucessor == null && other.idsucessor != null) || (this.idsucessor != null && !this.idsucessor.equals(other.idsucessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Sucessor[ idsucessor=" + idsucessor + " ]";
    }
    
}
