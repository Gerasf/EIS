package Lab2_Decorator.Decorator;

import Lab2_Decorator.FrameFactory.IFrameFactory;
import Lab2_Decorator.FrameFactory.Parameter.FrameParameters;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.swing.*;

@Decorator
@AllArgsConstructor
@NoArgsConstructor
public class FrameWithMenuDecorator implements IFrameFactory {

    @Inject
    @Delegate
    private IFrameFactory frameFactory;

    private void addMenu(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();

        // Создание меню "Файл"
        JMenu fileMenu = new JMenu("Файл");

        // Добавление пунктов в меню
        for (int i = 1; i <= 5; i++) {
            // Можно добавить действия для каждого пункта, например, вывод сообщения
            final int menuIndex = i;
            JMenuItem menuItem = new JMenuItem("Пункт " + menuIndex);
            menuItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Вы выбрали Пункт " + menuIndex));
            fileMenu.add(menuItem);
        }

        // Добавление пункта выхода
        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        // Добавление меню в панель меню
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
    }

    @Override
    public JFrame createFrame(FrameParameters parameters) {
        JFrame frame = frameFactory.createFrame(parameters);
        addMenu(frame);
        return frame;
    }
}
