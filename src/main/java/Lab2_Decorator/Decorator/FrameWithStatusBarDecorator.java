package Lab2_Decorator.Decorator;

import Lab2_Decorator.FrameFactory.IFrameFactory;
import Lab2_Decorator.FrameFactory.Parameter.FrameParameters;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;

@Decorator
@AllArgsConstructor
@NoArgsConstructor
public class FrameWithStatusBarDecorator implements IFrameFactory {

    @Inject
    @Delegate
    private IFrameFactory frameFactory;

    private void addStatusBar(JFrame frame) {
        // Создание строки статуса
        JLabel statusBar = new JLabel("Статус: Готов");
        statusBar.setBorder(BorderFactory.createEtchedBorder());

        // Добавление строки статуса в нижнюю часть окна
        frame.getContentPane().add(statusBar, BorderLayout.SOUTH);
    }

    @Override
    public JFrame createFrame(FrameParameters parameters) {
        JFrame frame = frameFactory.createFrame(parameters);
        addStatusBar(frame);
        return frame;
    }
}
