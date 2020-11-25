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
import javax.persistence.FetchType;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"),
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByTelefone", query = "SELECT u FROM Usuario u WHERE u.telefone = :telefone"),
    @NamedQuery(name = "Usuario.findByEmpresa", query = "SELECT u FROM Usuario u WHERE u.empresa = :empresa"),
    @NamedQuery(name = "Usuario.findByStatus", query = "SELECT u FROM Usuario u WHERE u.status = :status"),
    @NamedQuery(name = "Usuario.findByDtUsuario", query = "SELECT u FROM Usuario u WHERE u.dtUsuario = :dtUsuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Size(max = 45)
    @Column(name = "login")
    private String login;
    @Size(max = 45)
    @Column(name = "senha")
    private String senha;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 45)
    @Column(name = "empresa")
    private String empresa;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Column(name = "dt_usuario")
    @Temporal(TemporalType.DATE)
    private Date dtUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdusuario")
    private Collection<Origem> origemCollection;
    @JoinColumn(name = "gerencia_idgerencia", referencedColumnName = "idgerencia")
    @ManyToOne(optional = false)
    private Gerencia gerenciaIdgerencia;
    @JoinColumn(name = "perfil_idperfil", referencedColumnName = "idperfil")
    @ManyToOne(optional = false)
    private Perfil perfilIdperfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdusuario")
    private Collection<Runbook> runbookCollection;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDtUsuario() {
        return dtUsuario;
    }

    public void setDtUsuario(Date dtUsuario) {
        this.dtUsuario = dtUsuario;
    }

    @XmlTransient
    public Collection<Origem> getOrigemCollection() {
        return origemCollection;
    }

    public void setOrigemCollection(Collection<Origem> origemCollection) {
        this.origemCollection = origemCollection;
    }

    public Gerencia getGerenciaIdgerencia() {
        return gerenciaIdgerencia;
    }

    public void setGerenciaIdgerencia(Gerencia gerenciaIdgerencia) {
        this.gerenciaIdgerencia = gerenciaIdgerencia;
    }

    public Perfil getPerfilIdperfil() {
        return perfilIdperfil;
    }

    public void setPerfilIdperfil(Perfil perfilIdperfil) {
        this.perfilIdperfil = perfilIdperfil;
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
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
