/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luciolima
 */
@Entity
@Table(name = "acoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acoes.findAll", query = "SELECT a FROM Acoes a"),
    @NamedQuery(name = "Acoes.findByIdcodigoAcoes", query = "SELECT a FROM Acoes a WHERE a.idcodigoAcoes = :idcodigoAcoes"),
    @NamedQuery(name = "Acoes.findByTipo", query = "SELECT a FROM Acoes a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "Acoes.findByCodigo", query = "SELECT a FROM Acoes a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Acoes.findByMensagem", query = "SELECT a FROM Acoes a WHERE a.mensagem = :mensagem"),
    @NamedQuery(name = "Acoes.findByAcao", query = "SELECT a FROM Acoes a WHERE a.acao = :acao"),
    @NamedQuery(name = "Acoes.findByDtAcoes", query = "SELECT a FROM Acoes a WHERE a.dtAcoes = :dtAcoes")})
public class Acoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcodigo_acoes")
    private Integer idcodigoAcoes;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 255)
    @Column(name = "mensagem")
    private String mensagem;
    @Size(max = 255)
    @Column(name = "acao")
    private String acao;
    @Column(name = "dt_acoes")
    @Temporal(TemporalType.DATE)
    private Date dtAcoes;
    @JoinColumn(name = "job_idjob", referencedColumnName = "idjob")
    @ManyToOne(optional = false)
    private Job jobIdjob;

    public Acoes() {
    }

    public Acoes(Integer idcodigoAcoes) {
        this.idcodigoAcoes = idcodigoAcoes;
    }

    public Integer getIdcodigoAcoes() {
        return idcodigoAcoes;
    }

    public void setIdcodigoAcoes(Integer idcodigoAcoes) {
        this.idcodigoAcoes = idcodigoAcoes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Date getDtAcoes() {
        return dtAcoes;
    }

    public void setDtAcoes(Date dtAcoes) {
        this.dtAcoes = dtAcoes;
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
        hash += (idcodigoAcoes != null ? idcodigoAcoes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acoes)) {
            return false;
        }
        Acoes other = (Acoes) object;
        if ((this.idcodigoAcoes == null && other.idcodigoAcoes != null) || (this.idcodigoAcoes != null && !this.idcodigoAcoes.equals(other.idcodigoAcoes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Acoes[ idcodigoAcoes=" + idcodigoAcoes + " ]";
    }
    
}
