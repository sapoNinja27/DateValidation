import org.example.DateUtil;
import org.example.DateValidation;
import org.example.model.Periodo;
import org.junit.Assert;
import org.junit.Test;

import java.time.YearMonth;
import java.util.List;

public class DateUtilTest {


    @Test
    public void test() {
        List<YearMonth> range = DateUtil.createRange(YearMonth.of(2021, 1), YearMonth.of(2021, 12));
        Assert.assertEquals(range.size(), 12);
    }

    @Test
    /*
     Verificar se o periodo de 01/2021 ate 12/2021 é concomitante com o periodo de 06/2021 ate 06/2022
     */
    public void verificarPeriodosConcomitantes() {
        Periodo periodo = new Periodo(YearMonth.of(2021, 1), YearMonth.of(2021, 12));
        Periodo periodo2 = new Periodo(YearMonth.of(2021, 6), YearMonth.of(2022, 6));

        Assert.assertTrue(DateValidation.periodosConcomitantes(periodo, periodo2));
    }

    @Test
    /*
     Verificar se o periodo de 01/2021 ate 12/2021 é concomitante com o periodo de 01/2022 ate 06/2022
     */
    public void verificarPeriodosNaoConcomitantes() {
        Periodo periodo = new Periodo(YearMonth.of(2021, 1), YearMonth.of(2021, 12));
        Periodo periodo2 = new Periodo(YearMonth.of(2022, 1), YearMonth.of(2022, 6));

        Assert.assertFalse(DateValidation.periodosConcomitantes(periodo, periodo2));
    }
}
