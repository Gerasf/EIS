package Lab2_Decorator.FrameFactory;

import Lab2_Decorator.FrameFactory.Parameter.FrameParameters;

import javax.inject.Inject;
import javax.swing.*;

public class FrameFactoryBean {

    @Inject
    private IFrameFactory frameFactory;

    public JFrame createFrame(FrameParameters frameParameters) {
        return frameFactory.createFrame(frameParameters);
    }
}
