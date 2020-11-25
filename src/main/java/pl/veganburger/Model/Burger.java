package pl.veganburger.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Burger {

    @NotNull
    @Size(min=4, message = "Name of your Burger should have at least 4 characters.")
    private String name;

    @Size(min=1, message = "Your burger needs at least one ingredient.")
    private List<String> ingredients;
}
