import org.example.DateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.time.YearMonth;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DateUtilTest {


    @Test
    public void test() {
        List<YearMonth> range = DateUtil.createRange(YearMonth.of(2021, 1), YearMonth.of(2021, 12));
        Assert.assertEquals(range.size(), 12);
    }

    @Test
    public void verificarPeriodosConcomitantes() {
        //verificar se o periodo de 01/2021 ate 12/2021 é concomitante com o periodo de 06/2021 ate 06/2022
        List<YearMonth> range = DateUtil.createRange(YearMonth.of(2021, 1), YearMonth.of(2021, 12));
        List<YearMonth> range2 = DateUtil.createRange(YearMonth.of(2021, 6), YearMonth.of(2022, 6));
        Set<YearMonth> periodosTotais = new HashSet<>(range);
        periodosTotais.addAll(range2);
        //Se o tamanho do set for diferente do tamanho das duas o periodo é concomitante
        Assert.assertNotEquals(periodosTotais.size(), range.size() + range2.size());
    }

    @Test
    public void verificarPeriodosNaoConcomitantes() {
        //verificar se o periodo de 01/2021 ate 12/2021 é concomitante com o periodo de 01/2022 ate 06/2022
        List<YearMonth> range = DateUtil.createRange(YearMonth.of(2021, 1), YearMonth.of(2021, 12));
        List<YearMonth> range2 = DateUtil.createRange(YearMonth.of(2022, 1), YearMonth.of(2022, 6));
        Set<YearMonth> periodosTotais = new HashSet<>(range);
        periodosTotais.addAll(range2);
        //Se o tamanho do set for igual ao tamanho das duas o periodo não é concomitante
        Assert.assertEquals(periodosTotais.size(), range.size() + range2.size());
    }
}
