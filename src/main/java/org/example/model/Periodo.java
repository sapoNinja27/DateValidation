package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.DateUtil;

import java.time.YearMonth;
import java.util.List;

@AllArgsConstructor
@Getter
public class Periodo {

    private YearMonth dataInicial;
    private YearMonth dataFinal;

    public List<YearMonth> getPeriodos() {
        return DateUtil.createRange(dataInicial, dataFinal);
    }
}
