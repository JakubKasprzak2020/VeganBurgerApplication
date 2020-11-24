package pl.veganburger.Model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Order {

    @NotBlank(message = "the \"name and surname\" field is mandatory")
    private String name;
    @NotBlank(message = "the \"street\" field is mandatory")
    private String street;
    @NotBlank(message = "the \"city\" field is mandatory")
    private String city;
    @NotBlank(message = "the \"state\" field is mandatory")
    private String state;
    @NotBlank(message = "the \"zip code\" field is mandatory")
    private String zip;
    @CreditCardNumber(message = "this is not proper credit card number")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([0-9][0-9])$", message = "proper format is MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "this is not proper CVV code")
    private String ccCVV;
}
