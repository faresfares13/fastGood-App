package haitham.kinneret.fastgoodfood.BackgroundWorkAndAdapters;
/**
 * Created by Haitham + Fares on 1/30/2018.
 */


public class  Food {

    private String recipe;
    private byte[] image;
    private String cookingStyle;
    private String steps;

    Food(String recipe, byte[] image, String cookingStyle, String steps) {
        this.recipe = recipe;
        this.image = image;
        this.cookingStyle = cookingStyle;
        this.steps = steps;
    }

    String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCookingStyle() {
        return cookingStyle;
    }

    public void setCookingStyle(String cookingStyle) {
        this.cookingStyle = cookingStyle;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}
