package Lab2_Decorator.FrameFactory.Parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FrameParameters {
    private String title;
    private int height;
    private int width;
    private boolean isVisible;
    private int closeOperation;

}
