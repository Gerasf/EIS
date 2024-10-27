package Lab1_CDI;

import Lab1_CDI.Component.NumberConverter;
import lombok.NoArgsConstructor;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

@NoArgsConstructor
public class Laboratory1 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {

            NumberConverter numberConverter = container.select(NumberConverter.class).get();

            int decimalToConvert = 10;

            System.out.println(numberConverter.convert(decimalToConvert));

        } finally {
            weld.shutdown();
        }
    }
}
