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
import javax.persistence.Lob;
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
@Table(name = "runbook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Runbook.findAll", query = "SELECT r FROM Runbook r"),
    @NamedQuery(name = "Runbook.findByIdrunbook", query = "SELECT r FROM Runbook r WHERE r.idrunbook = :idrunbook"),
    @NamedQuery(name = "Runbook.findByVersao", query = "SELECT r FROM Runbook r WHERE r.versao = :versao"),
    @NamedQuery(name = "Runbook.findByNome", query = "SELECT r FROM Runbook r WHERE r.nome = :nome"),
    @NamedQuery(name = "Runbook.findByNomeCadeia", query = "SELECT r FROM Runbook r WHERE r.nomeCadeia = :nomeCadeia"),
    @NamedQuery(name = "Runbook.findByNomeAplic", query = "SELECT r FROM Runbook r WHERE r.nomeAplic = :nomeAplic"),
    @NamedQuery(name = "Runbook.findByObjetivoAplic", query = "SELECT r FROM Runbook r WHERE r.objetivoAplic = :objetivoAplic"),
    @NamedQuery(name = "Runbook.findByFuncAplic", query = "SELECT r FROM Runbook r WHERE r.funcAplic = :funcAplic"),
    @NamedQuery(name = "Runbook.findByEtapasAplic", query = "SELECT r FROM Runbook r WHERE r.etapasAplic = :etapasAplic"),
    @NamedQuery(name = "Runbook.findByRespTi", query = "SELECT r FROM Runbook r WHERE r.respTi = :respTi"),
    @NamedQuery(name = "Runbook.findByRespUsuario", query = "SELECT r FROM Runbook r WHERE r.respUsuario = :respUsuario"),
    @NamedQuery(name = "Runbook.findByAcordoServ", query = "SELECT r FROM Runbook r WHERE r.acordoServ = :acordoServ"),
    @NamedQuery(name = "Runbook.findByImpactoProd", query = "SELECT r FROM Runbook r WHERE r.impactoProd = :impactoProd"),
    @NamedQuery(name = "Runbook.findByEstruturaDir", query = "SELECT r FROM Runbook r WHERE r.estruturaDir = :estruturaDir"),
    @NamedQuery(name = "Runbook.findByStatus", query = "SELECT r FROM Runbook r WHERE r.status = :status"),
    @NamedQuery(name = "Runbook.findByDtRunbook", query = "SELECT r FROM Runbook r WHERE r.dtRunbook = :dtRunbook"),
    @NamedQuery(name = "Runbook.findByDtPrevImplant", query = "SELECT r FROM Runbook r WHERE r.dtPrevImplant = :dtPrevImplant"),
    @NamedQuery(name = "Runbook.findByLiderOperacao", query = "SELECT r FROM Runbook r WHERE r.liderOperacao = :liderOperacao")})
public class Runbook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrunbook")
    private Integer idrunbook;
    @Column(name = "versao")
    private Integer versao;
    @Lob
    @Size(max = 65535)
    @Column(name = "modificacoes")
    private String modificacoes;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "nome_cadeia")
    private String nomeCadeia;
    @Size(max = 45)
    @Column(name = "nome_aplic")
    private String nomeAplic;
    @Size(max = 255)
    @Column(name = "objetivo_aplic")
    private String objetivoAplic;
    @Size(max = 255)
    @Column(name = "func_aplic")
    private String funcAplic;
    @Size(max = 255)
    @Column(name = "etapas_aplic")
    private String etapasAplic;
    @Size(max = 100)
    @Column(name = "resp_ti")
    private String respTi;
    @Size(max = 100)
    @Column(name = "resp_usuario")
    private String respUsuario;
    @Size(max = 255)
    @Column(name = "acordo_serv")
    private String acordoServ;
    @Size(max = 255)
    @Column(name = "impacto_prod")
    private String impactoProd;
    @Size(max = 255)
    @Column(name = "estrutura_dir")
    private String estruturaDir;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Column(name = "dt_runbook")
    @Temporal(TemporalType.DATE)
    private Date dtRunbook;
    @Column(name = "dt_prev_implant")
    @Temporal(TemporalType.DATE)
    private Date dtPrevImplant;
    @Size(max = 45)
    @Column(name = "lider_operacao")
    private String liderOperacao;
    @Lob
    @Size(max = 65535)
    @Column(name = "historico")
    private String historico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "runbookIdrunbook")
    private Collection<Job> jobCollection;
    @JoinColumn(name = "origem_idorigem", referencedColumnName = "idorigem")
    @ManyToOne(optional = false)
    private Origem origemIdorigem;
    @JoinColumn(name = "sistema_idsistema", referencedColumnName = "idsistema")
    @ManyToOne(optional = false)
    private Sistema sistemaIdsistema;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;

    public Runbook() {
    }

    public Runbook(Integer idrunbook) {
        this.idrunbook = idrunbook;
    }

    public Integer getIdrunbook() {
        return idrunbook;
    }

    public void setIdrunbook(Integer idrunbook) {
        this.idrunbook = idrunbook;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    public String getModificacoes() {
        return modificacoes;
    }

    public void setModificacoes(String modificacoes) {
        this.modificacoes = modificacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCadeia() {
        return nomeCadeia;
    }

    public void setNomeCadeia(String nomeCadeia) {
        this.nomeCadeia = nomeCadeia;
    }

    public String getNomeAplic() {
        return nomeAplic;
    }

    public void setNomeAplic(String nomeAplic) {
        this.nomeAplic = nomeAplic;
    }

    public String getObjetivoAplic() {
        return objetivoAplic;
    }

    public void setObjetivoAplic(String objetivoAplic) {
        this.objetivoAplic = objetivoAplic;
    }

    public String getFuncAplic() {
        return funcAplic;
    }

    public void setFuncAplic(String funcAplic) {
        this.funcAplic = funcAplic;
    }

    public String getEtapasAplic() {
        return etapasAplic;
    }

    public void setEtapasAplic(String etapasAplic) {
        this.etapasAplic = etapasAplic;
    }

    public String getRespTi() {
        return respTi;
    }

    public void setRespTi(String respTi) {
        this.respTi = respTi;
    }

    public String getRespUsuario() {
        return respUsuario;
    }

    public void setRespUsuario(String respUsuario) {
        this.respUsuario = respUsuario;
    }

    public String getAcordoServ() {
        return acordoServ;
    }

    public void setAcordoServ(String acordoServ) {
        this.acordoServ = acordoServ;
    }

    public String getImpactoProd() {
        return impactoProd;
    }

    public void setImpactoProd(String impactoProd) {
        this.impactoProd = impactoProd;
    }

    public String getEstruturaDir() {
        return estruturaDir;
    }

    public void setEstruturaDir(String estruturaDir) {
        this.estruturaDir = estruturaDir;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDtRunbook() {
        return dtRunbook;
    }

    public void setDtRunbook(Date dtRunbook) {
        this.dtRunbook = dtRunbook;
    }

    public Date getDtPrevImplant() {
        return dtPrevImplant;
    }

    public void setDtPrevImplant(Date dtPrevImplant) {
        this.dtPrevImplant = dtPrevImplant;
    }

    public String getLiderOperacao() {
        return liderOperacao;
    }

    public void setLiderOperacao(String liderOperacao) {
        this.liderOperacao = liderOperacao;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    @XmlTransient
    public Collection<Job> getJobCollection() {
        return jobCollection;
    }

    public void setJobCollection(Collection<Job> jobCollection) {
        this.jobCollection = jobCollection;
    }

    public Origem getOrigemIdorigem() {
        return origemIdorigem;
    }

    public void setOrigemIdorigem(Origem origemIdorigem) {
        this.origemIdorigem = origemIdorigem;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrunbook != null ? idrunbook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Runbook)) {
            return false;
        }
        Runbook other = (Runbook) object;
        if ((this.idrunbook == null && other.idrunbook != null) || (this.idrunbook != null && !this.idrunbook.equals(other.idrunbook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Runbook[ idrunbook=" + idrunbook + " ]";
    }
    
}
