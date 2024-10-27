package Lab2_Decorator.FrameFactory;

import Lab2_Decorator.FrameFactory.Parameter.FrameParameters;

import javax.swing.*;

public interface IFrameFactory {
    JFrame createFrame(FrameParameters parameters);
}
