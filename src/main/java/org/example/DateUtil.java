package org.example;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class DateUtil {
    public static List<YearMonth> createRange(YearMonth dataInicial, YearMonth dataFinal) {
        List<YearMonth> list = new ArrayList<>();
        do {
            list.add(dataInicial);
            dataInicial = dataInicial.plusMonths(1);
        } while (dataInicial.isBefore(dataFinal.plusMonths(1)));
        return list;
    }
}
