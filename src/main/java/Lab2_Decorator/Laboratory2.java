package Lab2_Decorator;

import Lab2_Decorator.FrameFactory.FrameFactoryBean;
import Lab2_Decorator.FrameFactory.Parameter.FrameParameters;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.swing.*;

public class Laboratory2 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {
            FrameFactoryBean frameFactoryBean = container.select(FrameFactoryBean.class).get();

            // Создание параметров для окна
            FrameParameters params = new FrameParameters("Окно", 400, 300, true, JFrame.EXIT_ON_CLOSE);

            // Создание окна
            JFrame frame = frameFactoryBean.createFrame(params);

        } finally {
            weld.shutdown();
        }
    }

}
