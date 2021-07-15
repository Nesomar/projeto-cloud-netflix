package br.com.academy.hrpayroll.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerResponse implements Serializable {

    private static final long serialVersionUID = 6841086063001964835L;
    private Long id;
    private String name;
    private Double dailyIncome;
}
