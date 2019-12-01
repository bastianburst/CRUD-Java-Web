/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Familia
 */
@Entity
@Table(name = "asistente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistente.findAll", query = "SELECT a FROM Asistente a"),
    @NamedQuery(name = "Asistente.findById", query = "SELECT a FROM Asistente a WHERE a.id = :id"),
    @NamedQuery(name = "Asistente.findByNombres", query = "SELECT a FROM Asistente a WHERE a.nombres = :nombres"),
    @NamedQuery(name = "Asistente.findByApellidos", query = "SELECT a FROM Asistente a WHERE a.apellidos = :apellidos"),
    @NamedQuery(name = "Asistente.findByDocumento", query = "SELECT a FROM Asistente a WHERE a.documento = :documento"),
    @NamedQuery(name = "Asistente.findByTelefono", query = "SELECT a FROM Asistente a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Asistente.findByEmail", query = "SELECT a FROM Asistente a WHERE a.email = :email"),
    @NamedQuery(name = "Asistente.findByFechanac", query = "SELECT a FROM Asistente a WHERE a.fechanac = :fechanac"),
    @NamedQuery(name = "Asistente.findByEstado", query = "SELECT a FROM Asistente a WHERE a.estado = :estado")})
public class Asistente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "documento")
    private String documento;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechanac")
    @Temporal(TemporalType.DATE)
    private Date fechanac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public Asistente() {
    }

    public Asistente(Integer id) {
        this.id = id;
    }

    public Asistente(Integer id, String nombres, String apellidos, String documento, Date fechanac, boolean estado) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.fechanac = fechanac;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
        if (!(object instanceof Asistente)) {
            return false;
        }
        Asistente other = (Asistente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Asistente[ id=" + id + " ]";
    }
    
}
