package sample;

import javafx.fxml.FXML;
import java.net.InetAddress;
import java.util.ArrayList;

/**
 * Name: Dustin Summers
 * Date: 11/06/2017
 * Description:
 *
 * Controller for GUI.
 *
 */
public class RecipeFinderController {

    /**
     * findRecipes()
     * Button Controller.  Couple of steps here:
     * 1) Check To make sure we have internet
     * 2) If we have internet, pull in the recipe list from our desired URL
     *
     * TODO:
     * At this time, the URL is a hardcoded String.  Build in functionality to adjust this dynamically based on
     * user criteria/ingredients.
     */
    @FXML
    private void findRecipes(){
    System.out.println("Finding recipes!");
    String recipeURL = "https://food2fork.com/api/search?key=304840c6b26d5a8c28da4ff2661b8e85&q=egg,milk,floursort=r";
        try {

            //Standard Internet Poll.  We should determine if this is the best method to check internet connectivity.
            InetAddress address = InetAddress.getByName("www.google.com");

            //Do a standard internet query to determine if we have network access.
            //This essentially sends a "ping" request to the site given
            if(address.isReachable(200)){
                System.out.println("Passing in RecipeURL: " + recipeURL);

                //Extract Recipes from Given URL
                ArrayList<RecipeObject> recipes = RecipesQuery.extractRecipes(recipeURL);

                //Ensure Recipes were returned
                if(recipes.size() <= 0){
                    System.out.println("NO recipes returned!");
                } else {

                    /*TODO:
                        Display these to an appropriate GUI Interface, which allows users to select which actual recipe
                        they would like to display based on this list**/
                    for(int i = 0; i < recipes.size(); i++){
                        RecipeObject tempRecipe = recipes.get(i);
                        System.out.println("Article " + (i+1) + ": " + tempRecipe.getRecipeTitle());
                    }
                }
            } else {
                System.out.println("No network access!");
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        /*TODO:  Add in ability to select which recipe you want from this list, and perform a separate query*/
        System.out.println("Which recipe would you like to see the instructions for?");
    }
}
