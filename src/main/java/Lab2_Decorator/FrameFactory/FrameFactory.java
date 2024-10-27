package Lab2_Decorator.FrameFactory;

import Lab2_Decorator.FrameFactory.Parameter.FrameParameters;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Default;
import javax.swing.*;

@Default
@NoArgsConstructor
public class FrameFactory implements IFrameFactory {

    @Override
    public JFrame createFrame(FrameParameters params) {
        JFrame frame = new JFrame(params.getTitle());

        frame.setSize(params.getWidth(), params.getHeight());
        frame.setDefaultCloseOperation(params.getCloseOperation());
        frame.setVisible(params.isVisible());

        return frame;
    }
}
