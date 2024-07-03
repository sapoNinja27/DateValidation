package org.example;

import org.example.model.Periodo;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DateValidation {
    public static boolean periodosConcomitantes(Periodo periodo1, Periodo periodo2) {
        Set<YearMonth> periodos = new HashSet<>(periodo1.getPeriodos());
        periodos.addAll(periodo2.getPeriodos());
        return periodos.size() != periodo1.getPeriodos().size() + periodo2.getPeriodos().size();
    }
}
