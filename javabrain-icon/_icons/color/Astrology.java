import java.net.URL;

/**
 *
 * @author Fernando Isaías García Aguirre
 */
public class Astrology {
    
    public static URL AIR = get("air");
    public static URL AQUARIUS = get("aquarius");
    public static URL ARIES = get("aries");
    public static URL AUTUMN = get("autumn");
    public static URL CANCER = get("cancer");
    public static URL CAPRICORN = get("capricorn");
    public static URL CRYSTAL_BALL = get("crystal_ball");
    public static URL EARTH_ELEMENT = get("earth_element");
    public static URL FIRE = get("fire");
    public static URL FIRST_QUARTER = get("first_quarter");
    public static URL FORTUNE_TELLER = get("fortune_teller");
    public static URL FULL_MOON = get("full_moon");
    public static URL GALAXY = get("galaxy");
    public static URL GEMINI = get("gemini");
    public static URL LAST_QUARTER = get("last_quarter");
    public static URL LEO = get("leo");
    public static URL LIBRA = get("libra");
    public static URL MONKEY = get("monkey");
    public static URL NEW_MOON = get("new_moon");
    public static URL PISCES = get("pisces");
    public static URL RAT = get("rat");
    public static URL SAGITTARIUS = get("sagittarius");
    public static URL SCORPIO = get("scorpio");
    public static URL SPRING = get("spring");
    public static URL SUMMER = get("summer");
    public static URL SWINE = get("swine");
    public static URL TAURUS = get("taurus");
    public static URL VIRGO = get("virgo");
    public static URL WANING_CRESCENT = get("waning_crescent");
    public static URL WANING_GIBBOUS = get("waning_gibbous");
    public static URL WATER_ELEMENT = get("water_element");
    public static URL WAXING_CRESCENT = get("waxing_crescent");
    public static URL WAXING_GIBBOUS = get("waxing_gibbous");
    public static URL WINTER = get("winter");
    public static URL YEAR_OF_DOG = get("year_of_dog");
    public static URL YEAR_OF_DRAGON = get("year_of_dragon");
    public static URL YEAR_OF_GOAT = get("year_of_goat");
    public static URL YEAR_OF_HORSE = get("year_of_horse");
    public static URL YEAR_OF_OX = get("year_of_ox");
    public static URL YEAR_OF_RABBIT = get("year_of_rabbit");
    public static URL YEAR_OF_ROOSTER_3 = get("year_of_rooster_3");
    public static URL YEAR_OF_SNAKE = get("year_of_snake");
    public static URL YEAR_OF_TIGER = get("year_of_tiger");
    
    private static URL get(String icon) {
        try {
            return new URL("http://javabrain2.webcindario.com/color_icons/astrology/"+icon+".bcon");
        } catch (java.net.MalformedURLException e) {}
        return null;
    }
    
}