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
public class FrameWithSidebarDecorator implements IFrameFactory {

    @Inject
    @Delegate
    private IFrameFactory frameFactory;

    private void addSidebar(JFrame frame) {
        // Создание боковой панели
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS)); // Вертикальное расположение

        // Добавление кнопок в боковую панель
        for (int i = 1; i <= 5; i++) {
            final int menuIndex = i;
            JButton button = new JButton("Кнопка " + menuIndex);
            button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Вы нажали Кнопку " + menuIndex));
            sidebar.add(button);
        }

        // Добавление боковой панели к фрейму
        frame.getContentPane().add(sidebar, BorderLayout.WEST); // Боковая панель слева
    }

    @Override
    public JFrame createFrame(FrameParameters parameters) {
        JFrame frame = frameFactory.createFrame(parameters);
        addSidebar(frame);
        return frame;
    }
}
