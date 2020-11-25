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
@Table(name = "origem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Origem.findAll", query = "SELECT o FROM Origem o"),
    @NamedQuery(name = "Origem.findByIdorigem", query = "SELECT o FROM Origem o WHERE o.idorigem = :idorigem"),
    @NamedQuery(name = "Origem.findByTipo", query = "SELECT o FROM Origem o WHERE o.tipo = :tipo"),
    @NamedQuery(name = "Origem.findByNumero", query = "SELECT o FROM Origem o WHERE o.numero = :numero"),
    @NamedQuery(name = "Origem.findByNomeOrigem", query = "SELECT o FROM Origem o WHERE o.nomeOrigem = :nomeOrigem"),
    @NamedQuery(name = "Origem.findByDescricao", query = "SELECT o FROM Origem o WHERE o.descricao = :descricao"),
    @NamedQuery(name = "Origem.findByRespTec", query = "SELECT o FROM Origem o WHERE o.respTec = :respTec"),
    @NamedQuery(name = "Origem.findByLiderOperacao", query = "SELECT o FROM Origem o WHERE o.liderOperacao = :liderOperacao"),
    @NamedQuery(name = "Origem.findByDtPrevTermino", query = "SELECT o FROM Origem o WHERE o.dtPrevTermino = :dtPrevTermino"),
    @NamedQuery(name = "Origem.findByStatus", query = "SELECT o FROM Origem o WHERE o.status = :status"),
    @NamedQuery(name = "Origem.findByMotivo", query = "SELECT o FROM Origem o WHERE o.motivo = :motivo"),
    @NamedQuery(name = "Origem.findByDtOrigem", query = "SELECT o FROM Origem o WHERE o.dtOrigem = :dtOrigem")})
public class Origem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idorigem")
    private Integer idorigem;
    @Size(max = 30)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 100)
    @Column(name = "nome_origem")
    private String nomeOrigem;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 45)
    @Column(name = "resp_tec")
    private String respTec;
    @Size(max = 45)
    @Column(name = "lider_operacao")
    private String liderOperacao;
    @Column(name = "dt_prev_termino")
    @Temporal(TemporalType.DATE)
    private Date dtPrevTermino;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 100)
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "dt_origem")
    @Temporal(TemporalType.DATE)
    private Date dtOrigem;
    @JoinColumn(name = "sistema_idsistema", referencedColumnName = "idsistema")
    @ManyToOne(optional = false)
    private Sistema sistemaIdsistema;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origemIdorigem")
    private Collection<Runbook> runbookCollection;

    public Origem() {
    }

    public Origem(Integer idorigem) {
        this.idorigem = idorigem;
    }

    public Integer getIdorigem() {
        return idorigem;
    }

    public void setIdorigem(Integer idorigem) {
        this.idorigem = idorigem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNomeOrigem() {
        return nomeOrigem;
    }

    public void setNomeOrigem(String nomeOrigem) {
        this.nomeOrigem = nomeOrigem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRespTec() {
        return respTec;
    }

    public void setRespTec(String respTec) {
        this.respTec = respTec;
    }

    public String getLiderOperacao() {
        return liderOperacao;
    }

    public void setLiderOperacao(String liderOperacao) {
        this.liderOperacao = liderOperacao;
    }

    public Date getDtPrevTermino() {
        return dtPrevTermino;
    }

    public void setDtPrevTermino(Date dtPrevTermino) {
        this.dtPrevTermino = dtPrevTermino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getDtOrigem() {
        return dtOrigem;
    }

    public void setDtOrigem(Date dtOrigem) {
        this.dtOrigem = dtOrigem;
    }

    public Sistema getSistemaIdsistema() {
        return sistemaIdsistema;
    }

    public void setSistemaIdsistema(Sistema sistemaIdsistema) {
        this.sistemaIdsistema = sistemaIdsistema;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
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
        hash += (idorigem != null ? idorigem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Origem)) {
            return false;
        }
        Origem other = (Origem) object;
        if ((this.idorigem == null && other.idorigem != null) || (this.idorigem != null && !this.idorigem.equals(other.idorigem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Origem[ idorigem=" + idorigem + " ]";
    }
    
}
