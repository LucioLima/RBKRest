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
@Table(name = "job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "Job.findByIdjob", query = "SELECT j FROM Job j WHERE j.idjob = :idjob"),
    @NamedQuery(name = "Job.findByNome", query = "SELECT j FROM Job j WHERE j.nome = :nome"),
    @NamedQuery(name = "Job.findByNomePrograma", query = "SELECT j FROM Job j WHERE j.nomePrograma = :nomePrograma"),
    @NamedQuery(name = "Job.findByObjetivo", query = "SELECT j FROM Job j WHERE j.objetivo = :objetivo"),
    @NamedQuery(name = "Job.findByTipo", query = "SELECT j FROM Job j WHERE j.tipo = :tipo"),
    @NamedQuery(name = "Job.findByDiretorio", query = "SELECT j FROM Job j WHERE j.diretorio = :diretorio"),
    @NamedQuery(name = "Job.findByProgAssoc", query = "SELECT j FROM Job j WHERE j.progAssoc = :progAssoc"),
    @NamedQuery(name = "Job.findByUserExecProc", query = "SELECT j FROM Job j WHERE j.userExecProc = :userExecProc"),
    @NamedQuery(name = "Job.findByServExecProc", query = "SELECT j FROM Job j WHERE j.servExecProc = :servExecProc"),
    @NamedQuery(name = "Job.findByPeriodicidade", query = "SELECT j FROM Job j WHERE j.periodicidade = :periodicidade"),
    @NamedQuery(name = "Job.findByFrequencia", query = "SELECT j FROM Job j WHERE j.frequencia = :frequencia"),
    @NamedQuery(name = "Job.findByHoraInicio", query = "SELECT j FROM Job j WHERE j.horaInicio = :horaInicio"),
    @NamedQuery(name = "Job.findByHoraLimite", query = "SELECT j FROM Job j WHERE j.horaLimite = :horaLimite"),
    @NamedQuery(name = "Job.findByProcExecExtra", query = "SELECT j FROM Job j WHERE j.procExecExtra = :procExecExtra"),
    @NamedQuery(name = "Job.findByInconpatibilidades", query = "SELECT j FROM Job j WHERE j.inconpatibilidades = :inconpatibilidades"),
    @NamedQuery(name = "Job.findByParamChamada", query = "SELECT j FROM Job j WHERE j.paramChamada = :paramChamada"),
    @NamedQuery(name = "Job.findByDtJob", query = "SELECT j FROM Job j WHERE j.dtJob = :dtJob"),
    @NamedQuery(name = "Job.findByTipoJob", query = "SELECT j FROM Job j WHERE j.tipoJob = :tipoJob"),
    @NamedQuery(name = "Job.findByFormaEnvio", query = "SELECT j FROM Job j WHERE j.formaEnvio = :formaEnvio"),
    @NamedQuery(name = "Job.findByServOrigem", query = "SELECT j FROM Job j WHERE j.servOrigem = :servOrigem"),
    @NamedQuery(name = "Job.findByServDestino", query = "SELECT j FROM Job j WHERE j.servDestino = :servDestino"),
    @NamedQuery(name = "Job.findByCaminhoOrigem", query = "SELECT j FROM Job j WHERE j.caminhoOrigem = :caminhoOrigem"),
    @NamedQuery(name = "Job.findByCaminhoDestino", query = "SELECT j FROM Job j WHERE j.caminhoDestino = :caminhoDestino"),
    @NamedQuery(name = "Job.findByAcaoPosTrans", query = "SELECT j FROM Job j WHERE j.acaoPosTrans = :acaoPosTrans"),
    @NamedQuery(name = "Job.findByUserControl", query = "SELECT j FROM Job j WHERE j.userControl = :userControl"),
    @NamedQuery(name = "Job.findByMascaraOrigem", query = "SELECT j FROM Job j WHERE j.mascaraOrigem = :mascaraOrigem"),
    @NamedQuery(name = "Job.findByMascaraDestino", query = "SELECT j FROM Job j WHERE j.mascaraDestino = :mascaraDestino"),
    @NamedQuery(name = "Job.findByTamanhoRegistro", query = "SELECT j FROM Job j WHERE j.tamanhoRegistro = :tamanhoRegistro"),
    @NamedQuery(name = "Job.findByNode", query = "SELECT j FROM Job j WHERE j.node = :node"),
    @NamedQuery(name = "Job.findByAplicacao", query = "SELECT j FROM Job j WHERE j.aplicacao = :aplicacao")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjob")
    private Integer idjob;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "nome_programa")
    private String nomePrograma;
    @Size(max = 255)
    @Column(name = "objetivo")
    private String objetivo;
    @Size(max = 255)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 255)
    @Column(name = "diretorio")
    private String diretorio;
    @Size(max = 255)
    @Column(name = "prog_assoc")
    private String progAssoc;
    @Lob
    @Size(max = 65535)
    @Column(name = "proc_antec")
    private String procAntec;
    @Lob
    @Size(max = 65535)
    @Column(name = "proc_suces")
    private String procSuces;
    @Size(max = 45)
    @Column(name = "user_exec_proc")
    private String userExecProc;
    @Size(max = 45)
    @Column(name = "serv_exec_proc")
    private String servExecProc;
    @Size(max = 45)
    @Column(name = "periodicidade")
    private String periodicidade;
    @Size(max = 45)
    @Column(name = "frequencia")
    private String frequencia;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_limite")
    @Temporal(TemporalType.TIME)
    private Date horaLimite;
    @Size(max = 45)
    @Column(name = "proc_exec_extra")
    private String procExecExtra;
    @Size(max = 255)
    @Column(name = "inconpatibilidades")
    private String inconpatibilidades;
    @Size(max = 255)
    @Column(name = "param_chamada")
    private String paramChamada;
    @Column(name = "dt_job")
    @Temporal(TemporalType.DATE)
    private Date dtJob;
    @Size(max = 45)
    @Column(name = "tipo_job")
    private String tipoJob;
    @Size(max = 45)
    @Column(name = "forma_envio")
    private String formaEnvio;
    @Size(max = 45)
    @Column(name = "serv_origem")
    private String servOrigem;
    @Size(max = 45)
    @Column(name = "serv_destino")
    private String servDestino;
    @Size(max = 100)
    @Column(name = "caminho_origem")
    private String caminhoOrigem;
    @Size(max = 100)
    @Column(name = "caminho_destino")
    private String caminhoDestino;
    @Size(max = 45)
    @Column(name = "acao_pos_trans")
    private String acaoPosTrans;
    @Size(max = 45)
    @Column(name = "user_control")
    private String userControl;
    @Size(max = 100)
    @Column(name = "mascara_origem")
    private String mascaraOrigem;
    @Size(max = 100)
    @Column(name = "mascara_destino")
    private String mascaraDestino;
    @Size(max = 45)
    @Column(name = "tamanho_registro")
    private String tamanhoRegistro;
    @Size(max = 45)
    @Column(name = "node")
    private String node;
    @Size(max = 45)
    @Column(name = "aplicacao")
    private String aplicacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobIdjob")
    private Collection<Sucessor> sucessorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobIdjob")
    private Collection<Predecessor> predecessorCollection;
    @JoinColumn(name = "runbook_idrunbook", referencedColumnName = "idrunbook")
    @ManyToOne(optional = false)
    private Runbook runbookIdrunbook;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobIdjob")
    private Collection<Acoes> acoesCollection;

    public Job() {
    }

    public Job(Integer idjob) {
        this.idjob = idjob;
    }

    public Integer getIdjob() {
        return idjob;
    }

    public void setIdjob(Integer idjob) {
        this.idjob = idjob;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomePrograma() {
        return nomePrograma;
    }

    public void setNomePrograma(String nomePrograma) {
        this.nomePrograma = nomePrograma;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public String getProgAssoc() {
        return progAssoc;
    }

    public void setProgAssoc(String progAssoc) {
        this.progAssoc = progAssoc;
    }

    public String getProcAntec() {
        return procAntec;
    }

    public void setProcAntec(String procAntec) {
        this.procAntec = procAntec;
    }

    public String getProcSuces() {
        return procSuces;
    }

    public void setProcSuces(String procSuces) {
        this.procSuces = procSuces;
    }

    public String getUserExecProc() {
        return userExecProc;
    }

    public void setUserExecProc(String userExecProc) {
        this.userExecProc = userExecProc;
    }

    public String getServExecProc() {
        return servExecProc;
    }

    public void setServExecProc(String servExecProc) {
        this.servExecProc = servExecProc;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraLimite() {
        return horaLimite;
    }

    public void setHoraLimite(Date horaLimite) {
        this.horaLimite = horaLimite;
    }

    public String getProcExecExtra() {
        return procExecExtra;
    }

    public void setProcExecExtra(String procExecExtra) {
        this.procExecExtra = procExecExtra;
    }

    public String getInconpatibilidades() {
        return inconpatibilidades;
    }

    public void setInconpatibilidades(String inconpatibilidades) {
        this.inconpatibilidades = inconpatibilidades;
    }

    public String getParamChamada() {
        return paramChamada;
    }

    public void setParamChamada(String paramChamada) {
        this.paramChamada = paramChamada;
    }

    public Date getDtJob() {
        return dtJob;
    }

    public void setDtJob(Date dtJob) {
        this.dtJob = dtJob;
    }

    public String getTipoJob() {
        return tipoJob;
    }

    public void setTipoJob(String tipoJob) {
        this.tipoJob = tipoJob;
    }

    public String getFormaEnvio() {
        return formaEnvio;
    }

    public void setFormaEnvio(String formaEnvio) {
        this.formaEnvio = formaEnvio;
    }

    public String getServOrigem() {
        return servOrigem;
    }

    public void setServOrigem(String servOrigem) {
        this.servOrigem = servOrigem;
    }

    public String getServDestino() {
        return servDestino;
    }

    public void setServDestino(String servDestino) {
        this.servDestino = servDestino;
    }

    public String getCaminhoOrigem() {
        return caminhoOrigem;
    }

    public void setCaminhoOrigem(String caminhoOrigem) {
        this.caminhoOrigem = caminhoOrigem;
    }

    public String getCaminhoDestino() {
        return caminhoDestino;
    }

    public void setCaminhoDestino(String caminhoDestino) {
        this.caminhoDestino = caminhoDestino;
    }

    public String getAcaoPosTrans() {
        return acaoPosTrans;
    }

    public void setAcaoPosTrans(String acaoPosTrans) {
        this.acaoPosTrans = acaoPosTrans;
    }

    public String getUserControl() {
        return userControl;
    }

    public void setUserControl(String userControl) {
        this.userControl = userControl;
    }

    public String getMascaraOrigem() {
        return mascaraOrigem;
    }

    public void setMascaraOrigem(String mascaraOrigem) {
        this.mascaraOrigem = mascaraOrigem;
    }

    public String getMascaraDestino() {
        return mascaraDestino;
    }

    public void setMascaraDestino(String mascaraDestino) {
        this.mascaraDestino = mascaraDestino;
    }

    public String getTamanhoRegistro() {
        return tamanhoRegistro;
    }

    public void setTamanhoRegistro(String tamanhoRegistro) {
        this.tamanhoRegistro = tamanhoRegistro;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        this.aplicacao = aplicacao;
    }

    @XmlTransient
    public Collection<Sucessor> getSucessorCollection() {
        return sucessorCollection;
    }

    public void setSucessorCollection(Collection<Sucessor> sucessorCollection) {
        this.sucessorCollection = sucessorCollection;
    }

    @XmlTransient
    public Collection<Predecessor> getPredecessorCollection() {
        return predecessorCollection;
    }

    public void setPredecessorCollection(Collection<Predecessor> predecessorCollection) {
        this.predecessorCollection = predecessorCollection;
    }

    public Runbook getRunbookIdrunbook() {
        return runbookIdrunbook;
    }

    public void setRunbookIdrunbook(Runbook runbookIdrunbook) {
        this.runbookIdrunbook = runbookIdrunbook;
    }

    @XmlTransient
    public Collection<Acoes> getAcoesCollection() {
        return acoesCollection;
    }

    public void setAcoesCollection(Collection<Acoes> acoesCollection) {
        this.acoesCollection = acoesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjob != null ? idjob.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.idjob == null && other.idjob != null) || (this.idjob != null && !this.idjob.equals(other.idjob))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Job[ idjob=" + idjob + " ]";
    }
    
}
