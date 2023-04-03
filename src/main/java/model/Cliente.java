package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cliente")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nomecliente;

    @OneToMany(mappedBy = "cliente")
    private List<Cliente> clientecontasareceber = new ArrayList<>();

  public List<Cliente> getClientecontasareceber() {
    return clientecontasareceber;
  }

  public void setClientecontasareceber(List<Cliente> clientecontasareceber) {
    this.clientecontasareceber = clientecontasareceber;
  }

  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

