package br.com.dudagiglioli.trabalhoBidu.repository.Filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContasAReceberFilter {

    @DateTimeFormat(pattern = "yyyy/MM/dd")

    private LocalDate data;
    private BigDecimal valorconta;

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
}
