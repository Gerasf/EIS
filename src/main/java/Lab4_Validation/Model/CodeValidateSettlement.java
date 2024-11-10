package Lab4_Validation.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeValidateSettlement {

    @NotNull(message = "Название не должно быть пустым")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё\\s]+$", message = "Название должно содержать только буквы и пробелы")
    private String name;

    @NotNull(message = "Почтовый индекс не должен быть пустым")
    @Pattern(regexp = "^\\d{6}$", message = "Почтовый индекс должен состоять из 6 цифр")
    private String postalCode;

    @NotNull(message = "Регион не должен быть пустым")
    private String region;

    @NotNull(message = "Страна не должна быть пустой")
    private String country;

    @Min(value = 1000, message = "Год основания должен быть не раньше 1000")
    @Max(value = 2100, message = "Год основания не может быть больше 2100")
    private int foundationYear;
}
