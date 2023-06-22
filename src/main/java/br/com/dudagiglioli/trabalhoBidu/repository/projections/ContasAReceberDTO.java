package br.com.dudagiglioli.trabalhoBidu.repository.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContasAReceberDTO {

    private Integer id;
    private LocalDate data;
    private BigDecimal valorconta;

    //relacionamento
    private String nomecliente;

    public ContasAReceberDTO(Integer id, LocalDate data, BigDecimal valorconta, String nomecliente) {
        this.id = id;
        this.data = data;
        this.valorconta = valorconta;
        this.nomecliente = nomecliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValorconta() {
        return valorconta;
    }

    public void setValorconta(BigDecimal valorconta) {
        this.valorconta = valorconta;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }
}
