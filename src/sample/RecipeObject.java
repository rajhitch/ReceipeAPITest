package sample;


/**
 * Name: Dustin Summers
 * Date: 11/06/2017
 * Description: Custom Recipe Object containing title of Recipe, URL, ID, and ImageURL for future reference
 */
public class RecipeObject {

    private String recipeTitle, recipeURL, recipeID, recipeImageURL;

    /**
     * Constructor for Recipe Object
     * @param recipeTitle
     * @param recipeID
     * @param recipeURL
     * @param recipeImageURL
     */
    public RecipeObject(String recipeTitle, String recipeID, String recipeURL, String recipeImageURL){
        this.recipeTitle = recipeTitle;
        this.recipeID = recipeID;
        this.recipeURL = recipeURL;
        this.recipeImageURL = recipeImageURL;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getRecipeURL() {
        return recipeURL;
    }

    public String getRecipeID() {
        return recipeID;
    }

    public String getRecipeImageURL() {
        return recipeImageURL;
    }
}
