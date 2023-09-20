import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DatabaseTest {
    @Test
    public void testSearchHeroByName() {
        // Create a new database instance
        Database database = new Database();

        // Create some heroes and add them to the database
        Hero hero1 = new Hero("Superman", "Clark Kent", "Super strength", 1938, "No", 9999);
        Hero hero2 = new Hero("Spider-Man", "Peter Parker", "Web-shooting", 1962, "Yes", 629);
        Hero hero3 = new Hero("Batman", "Bruce Wayne", "Rich guy", 1939, "Yes", 10);

        database.addHero(hero1);
        database.addHero(hero2);
        database.addHero(hero3);

        // Test searching for heroes by name
        ArrayList<Hero> searchResult1 = database.searchHeroByName("Superman");
        assertEquals(1, searchResult1.size());
        assertEquals("Superman", searchResult1.get(0).getName());

        ArrayList<Hero> searchResult2 = database.searchHeroByName("Peter");
        assertEquals(1, searchResult2.size());
        assertEquals("Spider-Man", searchResult2.get(0).getName());

        // Test searching for heroes by real name
        ArrayList<Hero> searchResult3 = database.searchHeroByName("Bruce Wayne");
        assertEquals(1, searchResult3.size());
        assertEquals("Batman", searchResult3.get(0).getName());

        // Test searching for a name that does not exist
        ArrayList<Hero> searchResult4 = database.searchHeroByName("Wonder Woman");
        assertEquals(0, searchResult4.size());
    }
    /*@Test
    public void testAddHero() {
        // Create a new database instance
        Database database = new Database();

        // Create a hero to add
        Hero heroToAdd = new Hero("Wonder Woman", "Diana Prince", "Super strength, lasso of truth", 1941, "Yes", 800);

        // Add the hero to the database
        database.addHero(heroToAdd);

        // Retrieve the heroes from the database
        ArrayList<Hero> heroes = database.getHeroes("");

        // Assert that the hero has been added to the database
        assertEquals(1, heroes.size()); // Expecting one hero in the database

        // Assert the details of the added hero
        Hero addedHero = heroes.get(0);
        assertEquals("Wonder Woman", addedHero.getName());
        assertEquals("Diana Prince", addedHero.getRealName());
        assertEquals("Super strength, lasso of truth", addedHero.getSuperpower());
        assertEquals(1941, addedHero.getYearCreated());
        assertEquals("Yes", addedHero.getIsHuman());
        assertEquals(800, addedHero.getStrength());
    }*/

    @Test
    public void testToString() {
        // Create a Hero instance
        Hero hero = new Hero("Wonder Woman", "Diana Prince", "Super strength, lasso of truth", 1941, "Yes", 800);

        // Get the expected string representation
        String expected = "\nYour Hero is ready to fight crime!\n" +
                "Name: Wonder Woman\n" +
                "Secret identity: Diana Prince\n" +
                "Superpower: Super strength, lasso of truth\n" +
                "Year of creation: 1941\n" +
                "Is a Human: Yes\n" +
                "Strength: 800\n";

        // Call the toString method and compare with the expected string
        assertEquals(expected, hero.toString());
    }
}