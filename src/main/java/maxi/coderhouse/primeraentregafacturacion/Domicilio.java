package maxi.coderhouse.primeraentregafacturacion;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity 
@Table (name = "DOMICILIO")

public class Domicilio {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "CALLE")
    private String calle;

    @Column(name = "numero")
    private int numero;

    @Column (name = "PISO")
    private int piso;

    @Column (name = "DEPATAMENTO")
    private String departamento;

    @Column (name = "CP")
    private int cp;

    @Column (name = "LOCALIDAD")
    private String localidad;

    @Column (name = "PROVINCIA")
    private String provincia;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public Domicilio() {
    }

    public Domicilio(String calle, int numero, int cp, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((calle == null) ? 0 : calle.hashCode());
        result = prime * result + numero;
        result = prime * result + piso;
        result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
        result = prime * result + cp;
        result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
        result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Domicilio other = (Domicilio) obj;
        if (id != other.id)
            return false;
        if (calle == null) {
            if (other.calle != null)
                return false;
        } else if (!calle.equals(other.calle))
            return false;
        if (numero != other.numero)
            return false;
        if (piso != other.piso)
            return false;
        if (departamento == null) {
            if (other.departamento != null)
                return false;
        } else if (!departamento.equals(other.departamento))
            return false;
        if (cp != other.cp)
            return false;
        if (localidad == null) {
            if (other.localidad != null)
                return false;
        } else if (!localidad.equals(other.localidad))
            return false;
        if (provincia == null) {
            if (other.provincia != null)
                return false;
        } else if (!provincia.equals(other.provincia))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Domicilio [id=" + id + 
                ", calle=" + calle + 
                ", numero=" + numero + 
                ", piso=" + piso +
                ", departamento=" + departamento + 
                ", cp=" + cp + 
                ", localidad=" + localidad +
                ", provincia=" + provincia + "]";
    }

}



