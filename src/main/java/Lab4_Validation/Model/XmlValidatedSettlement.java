package Lab4_Validation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class XmlValidatedSettlement {

    private String name;
    private String postalCode;
    private String region;
    private String country;
    private int foundationYear;
}
