import java.util.ArrayList;
import java.util.List;

// Interface for Meal Plans
interface MealPlan {
    String getMealType();
}

// Vegetarian Meal Implementation
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

// Vegan Meal Implementation
class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan Meal";
    }
}

// Keto Meal Implementation
class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto Meal";
    }
}

// High-Protein Meal Implementation
class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein Meal";
    }
}

// Generic Meal Class
class Meal<T extends MealPlan> {
    private String mealName;
    private T mealPlan;

    public Meal(String mealName, T mealPlan) {
        this.mealName = mealName;
        this.mealPlan = mealPlan;
    }

    public String getMealName() {
        return mealName;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealName='" + mealName + '\'' +
                ", mealPlan=" + mealPlan.getMealType() +
                '}';
    }
}

// Meal Plan Generator
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMeal(String mealName, T mealPlan) {
        // Validate the meal plan (for demonstration, we just check if it's not null)
        if (mealPlan == null) {
            throw new IllegalArgumentException("Invalid meal plan provided.");
        }
        return new Meal<>(mealName, mealPlan);
    }
}

// Main Class to Demonstrate Functionality
public class Personalized_Meal_Plan_Generator {
    public static void main(String[] args) {
        // Creating different meal plans
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMeal("Vegan Buddha Bowl", new VeganMeal());
        Meal<VegetarianMeal> vegetarianMeal = MealPlanGenerator.generateMeal("Vegetarian Pasta", new VegetarianMeal());
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMeal("Keto Chicken Salad", new KetoMeal());
        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMeal("High-Protein Quinoa Bowl", new HighProteinMeal());

        // Storing meals in a list
        List<Meal<? extends MealPlan>> mealList = new ArrayList<>();
        mealList.add(veganMeal);
        mealList.add(vegetarianMeal);
        mealList.add(ketoMeal);
        mealList.add(highProteinMeal);

        // Displaying the meal plans
        for (Meal<? extends MealPlan> meal : mealList) {
            System.out.println(meal);
        }
    }
}
