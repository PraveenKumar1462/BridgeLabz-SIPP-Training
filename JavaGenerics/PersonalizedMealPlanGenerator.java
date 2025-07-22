package JavaGenerics;

interface MealPlan {}

class VegetarianMeal implements MealPlan {}
class VeganMeal implements MealPlan {}
class KetoMeal implements MealPlan {}
class HighProteinMeal implements MealPlan {}

class Meal<T extends MealPlan> {
    private T mealPlan;
    public Meal(T mealPlan) { this.mealPlan = mealPlan; }
    public T getMealPlan() { return mealPlan; }
}

class MealPlanUtils {
    public static <T extends MealPlan> boolean validateMealPlan(T mealPlan) {
        // Simple validation example
        return mealPlan != null;
    }
}
