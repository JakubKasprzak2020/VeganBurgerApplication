package pl.veganburger.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.veganburger.Model.Burger;
import pl.veganburger.Model.Ingredient;
import pl.veganburger.Model.Ingredient.Type;

import javax.validation.Valid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignBurgerController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("WHEAT", "wheat bread", Ingredient.Type.BREAD),
                new Ingredient("RYE", "rye bread", Ingredient.Type.BREAD),
                new Ingredient("LENT", "lentils", Ingredient.Type.PROTEIN),
                new Ingredient("MUSH", "oyster mushroom", Ingredient.Type.PROTEIN),
                new Ingredient("TOMT", "tomato", Ingredient.Type.VEGETABLE),
                new Ingredient("LETT", "lettuce", Ingredient.Type.VEGETABLE),
                new Ingredient("POTCH", "potato cheese", Ingredient.Type.VEGAN_CHEESE),
                new Ingredient("TOFU", "tofu gouda", Ingredient.Type.VEGAN_CHEESE),
                new Ingredient("MAYO", "vegan mayonnaise", Ingredient.Type.SAUCE),
                new Ingredient("KETCH", "ketchup", Ingredient.Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Burger());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }


}
