package pl.veganburger.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        BREAD, PROTEIN, VEGETABLE, VEGAN_CHEESE, SAUCE
    }

}
