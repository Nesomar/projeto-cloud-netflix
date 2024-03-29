package br.com.academy.hrpayroll.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment implements Serializable {

    private static final long serialVersionUID = -1464718790077228649L;

    private String name;
    private Double dailyIncome;
    private Integer days;

    public Double getTotal() {
        return this.days * dailyIncome;
    }
}
