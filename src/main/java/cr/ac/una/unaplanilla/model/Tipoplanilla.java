/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaplanilla.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "PLAM_TIPOPLANILLAS", schema = "una")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoplanilla.findAll", query = "SELECT t FROM Tipoplanilla t"),
    @NamedQuery(name = "Tipoplanilla.findByTplaId", query = "SELECT t FROM Tipoplanilla t WHERE t.id = :id"),
    /*@NamedQuery(name = "Tipoplanilla.findByTplaCodigo", query = "SELECT t FROM Tipoplanilla t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "Tipoplanilla.findByTplaDescripcion", query = "SELECT t FROM Tipoplanilla t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tipoplanilla.findByTplaPlaxmes", query = "SELECT t FROM Tipoplanilla t WHERE t.planillasMes = :planillasMes"),
    @NamedQuery(name = "Tipoplanilla.findByTplaAnoultpla", query = "SELECT t FROM Tipoplanilla t WHERE t.anoUltPla = :anoUltPla"),
    @NamedQuery(name = "Tipoplanilla.findByTplaMesultpla", query = "SELECT t FROM Tipoplanilla t WHERE t.mesUltPla = :mesUltPla"),
    @NamedQuery(name = "Tipoplanilla.findByTplaNumultpla", query = "SELECT t FROM Tipoplanilla t WHERE t.numUltPla = :numUltPla"),
    @NamedQuery(name = "Tipoplanilla.findByTplaEstado", query = "SELECT t FROM Tipoplanilla t WHERE t.estado = :estado"),
    @NamedQuery(name = "Tipoplanilla.findByTplaVersion", query = "SELECT t FROM Tipoplanilla t WHERE t.version = :version")*/})
public class Tipoplanilla implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "PLAM_TIPOPLANILLA_TPLA_ID_GENERATOR", sequenceName = "una.PLAM_TIPOPLANILLA_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAM_TIPOPLANILLA_TPLA_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "TPLA_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "TPLA_CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "TPLA_DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "TPLA_PLAXMES")
    private Integer planillasMes;
    @Column(name = "TPLA_ANOULTPLA")
    private Integer anoUltPla;
    @Column(name = "TPLA_MESULTPLA")
    private Integer mesUltPla;
    @Column(name = "TPLA_NUMULTPLA")
    private Integer numUltPla;
    @Basic(optional = false)
    @Column(name = "TPLA_ESTADO")
    private String estado;
    @Version
    @Basic(optional = false)
    @Column(name = "TPLA_VERSION")
    private Integer version;
    @JoinTable(name = "PLAM_EMPLEADOSPLANILLA", joinColumns = {
        @JoinColumn(name = "EXP_IDTPLA", referencedColumnName = "TPLA_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "EXP_IDEMP", referencedColumnName = "EMP_ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Empleado> empleados;

    public Tipoplanilla() {
    }

    public Tipoplanilla(Long tplaId) {
        this.id = tplaId;
    }

    public Tipoplanilla(Long tplaId, String tplaCodigo, String tplaDescripcion, Integer tplaPlaxmes, String tplaEstado) {
        this.id = tplaId;
        this.codigo = tplaCodigo;
        this.descripcion = tplaDescripcion;
        this.planillasMes = tplaPlaxmes;
        this.estado = tplaEstado;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPlanillasMes() {
        return planillasMes;
    }

    public void setPlanillasMes(Integer planillasMes) {
        this.planillasMes = planillasMes;
    }

    public Integer getAnoUltPla() {
        return anoUltPla;
    }

    public void setAnoUltPla(Integer anoUltPla) {
        this.anoUltPla = anoUltPla;
    }

    public Integer getMesUltPla() {
        return mesUltPla;
    }

    public void setMesUltPla(Integer mesUltPla) {
        this.mesUltPla = mesUltPla;
    }

    public Integer getNumUltPla() {
        return numUltPla;
    }

    public void setNumUltPla(Integer numUltPla) {
        this.numUltPla = numUltPla;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @XmlTransient
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
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
        if (!(object instanceof Tipoplanilla)) {
            return false;
        }
        Tipoplanilla other = (Tipoplanilla) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.unaplanilla.model.Tipoplanilla[ tplaId=" + id + " ]";
    }
    
}
