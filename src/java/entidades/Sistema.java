/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luciolima
 */
@Entity
@Table(name = "sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sistema.findAll", query = "SELECT s FROM Sistema s"),
    @NamedQuery(name = "Sistema.findByIdsistema", query = "SELECT s FROM Sistema s WHERE s.idsistema = :idsistema"),
    @NamedQuery(name = "Sistema.findByNome", query = "SELECT s FROM Sistema s WHERE s.nome = :nome"),
    @NamedQuery(name = "Sistema.findByStatus", query = "SELECT s FROM Sistema s WHERE s.status = :status"),
    @NamedQuery(name = "Sistema.findByDtSistema", query = "SELECT s FROM Sistema s WHERE s.dtSistema = :dtSistema")})
public class Sistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsistema")
    private Integer idsistema;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Column(name = "dt_sistema")
    @Temporal(TemporalType.DATE)
    private Date dtSistema;
    @JoinColumn(name = "gerencia_idgerencia", referencedColumnName = "idgerencia")
    @ManyToOne(optional = false)
    private Gerencia gerenciaIdgerencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sistemaIdsistema")
    private Collection<Origem> origemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sistemaIdsistema")
    private Collection<Runbook> runbookCollection;

    public Sistema() {
    }

    public Sistema(Integer idsistema) {
        this.idsistema = idsistema;
    }

    public Integer getIdsistema() {
        return idsistema;
    }

    public void setIdsistema(Integer idsistema) {
        this.idsistema = idsistema;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDtSistema() {
        return dtSistema;
    }

    public void setDtSistema(Date dtSistema) {
        this.dtSistema = dtSistema;
    }

    public Gerencia getGerenciaIdgerencia() {
        return gerenciaIdgerencia;
    }

    public void setGerenciaIdgerencia(Gerencia gerenciaIdgerencia) {
        this.gerenciaIdgerencia = gerenciaIdgerencia;
    }

    @XmlTransient
    public Collection<Origem> getOrigemCollection() {
        return origemCollection;
    }

    public void setOrigemCollection(Collection<Origem> origemCollection) {
        this.origemCollection = origemCollection;
    }

    @XmlTransient
    public Collection<Runbook> getRunbookCollection() {
        return runbookCollection;
    }

    public void setRunbookCollection(Collection<Runbook> runbookCollection) {
        this.runbookCollection = runbookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsistema != null ? idsistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.idsistema == null && other.idsistema != null) || (this.idsistema != null && !this.idsistema.equals(other.idsistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Sistema[ idsistema=" + idsistema + " ]";
    }
    
}
