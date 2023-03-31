package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "contasareceber")

public class ContasAReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @OneToMany
    //relaciona - junta as tabelas
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name= "idcontasareceber")
    private ContasAReceber contasareceber;

    private int id;
    private Date data;
    private BigDecimal valorconta ;
    private int idcliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValorconta() {
        return valorconta;
    }

    public void setValorconta(BigDecimal valorconta) {
        this.valorconta = valorconta;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContasAReceber that = (ContasAReceber) o;
        return id == that.id && idcliente == that.idcliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idcliente);
    }
}
