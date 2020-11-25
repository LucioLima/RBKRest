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
@Table(name = "gerencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerencia.findAll", query = "SELECT g FROM Gerencia g"),
    @NamedQuery(name = "Gerencia.findByIdgerencia", query = "SELECT g FROM Gerencia g WHERE g.idgerencia = :idgerencia"),
    @NamedQuery(name = "Gerencia.findByNomeGerencia", query = "SELECT g FROM Gerencia g WHERE g.nomeGerencia = :nomeGerencia"),
    @NamedQuery(name = "Gerencia.findByOperacoes", query = "SELECT g FROM Gerencia g WHERE g.operacoes = :operacoes"),
    @NamedQuery(name = "Gerencia.findByGestor", query = "SELECT g FROM Gerencia g WHERE g.gestor = :gestor"),
    @NamedQuery(name = "Gerencia.findByStatus", query = "SELECT g FROM Gerencia g WHERE g.status = :status"),
    @NamedQuery(name = "Gerencia.findByDtGerencia", query = "SELECT g FROM Gerencia g WHERE g.dtGerencia = :dtGerencia")})
public class Gerencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgerencia")
    private Integer idgerencia;
    @Size(max = 45)
    @Column(name = "nome_gerencia")
    private String nomeGerencia;
    @Column(name = "operacoes")
    private Boolean operacoes;
    @Size(max = 45)
    @Column(name = "gestor")
    private String gestor;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Column(name = "dt_gerencia")
    @Temporal(TemporalType.DATE)
    private Date dtGerencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gerenciaIdgerencia")
    private Collection<Sistema> sistemaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gerenciaIdgerencia")
    private Collection<Usuario> usuarioCollection;

    public Gerencia() {
    }

    public Gerencia(Integer idgerencia) {
        this.idgerencia = idgerencia;
    }

    public Integer getIdgerencia() {
        return idgerencia;
    }

    public void setIdgerencia(Integer idgerencia) {
        this.idgerencia = idgerencia;
    }

    public String getNomeGerencia() {
        return nomeGerencia;
    }

    public void setNomeGerencia(String nomeGerencia) {
        this.nomeGerencia = nomeGerencia;
    }

    public Boolean getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(Boolean operacoes) {
        this.operacoes = operacoes;
    }

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDtGerencia() {
        return dtGerencia;
    }

    public void setDtGerencia(Date dtGerencia) {
        this.dtGerencia = dtGerencia;
    }

    @XmlTransient
    public Collection<Sistema> getSistemaCollection() {
        return sistemaCollection;
    }

    public void setSistemaCollection(Collection<Sistema> sistemaCollection) {
        this.sistemaCollection = sistemaCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgerencia != null ? idgerencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerencia)) {
            return false;
        }
        Gerencia other = (Gerencia) object;
        if ((this.idgerencia == null && other.idgerencia != null) || (this.idgerencia != null && !this.idgerencia.equals(other.idgerencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Gerencia[ idgerencia=" + idgerencia + " ]";
    }
    
}
