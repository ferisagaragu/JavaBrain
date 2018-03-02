import java.net.URL;

/**
 *
 * @author Fernando Isaías García Aguirre
 */
public class Baby {
    
    public static URL ABC = get("abc");
    public static URL BABY = get("baby");
    public static URL BABY_APP = get("baby_app");
    public static URL BABY_BOTTLE = get("baby_bottle");
    public static URL BABY_FACE = get("baby_face");
    public static URL BABY_FEET = get("baby_feet");
    public static URL BABY_POTTY = get("baby_potty");
    public static URL BIB = get("bib");
    public static URL BOY = get("boy");
    public static URL BREASTFEEDING = get("breastfeeding");
    public static URL BREAST_PUMP = get("breast_pump");
    public static URL BRICK = get("brick");
    public static URL CHEBURASHKA_3 = get("cheburashka_3");
    public static URL CHILD = get("child");
    public static URL CHILDREN = get("children");
    public static URL CRIB = get("crib");
    public static URL CRYING_BABY = get("crying_baby");
    public static URL FAIRYTALE = get("fairytale");
    public static URL FAMILY = get("family");
    public static URL FATHER = get("father");
    public static URL FLYING_STORK = get("flying_stork");
    public static URL FLYING_STORK_WITH_BUNDLE = get("flying_stork_with_bundle");
    public static URL GIRL = get("girl");
    public static URL HEART_BALLOON = get("heart_balloon");
    public static URL KEEP_AWAY_FROM_CHILDREN = get("keep_away_from_children");
    public static URL KITE = get("kite");
    public static URL LEGO_HEAD = get("lego_head");
    public static URL MOTHER = get("mother");
    public static URL MOTHERS_HEALTH = get("mothers_health");
    public static URL NAPPY = get("nappy");
    public static URL NERF_GUN = get("nerf_gun");
    public static URL NOT_SUITABLE_FOR_CHILDREN_UNDER_AGE_X = get("not_suitable_for_children_under_age_x");
    public static URL NUMBERS = get("numbers");
    public static URL PACIFIER = get("pacifier");
    public static URL PAPER_PLANE = get("paper_plane");
    public static URL PARTY_BALOON = get("party_baloon");
    public static URL PINWHEEL = get("pinwheel");
    public static URL POKEBALL = get("pokeball");
    public static URL POWDER = get("powder");
    public static URL PREGNANT = get("pregnant");
    public static URL RATTLE_3 = get("rattle_3");
    public static URL ROMPER = get("romper");
    public static URL SANDBOX = get("sandbox");
    public static URL SIPPY_CUP = get("sippy_cup");
    public static URL STORK = get("stork");
    public static URL STORK_WITH_BUNDLE = get("stork_with_bundle");
    public static URL STROLLER = get("stroller");
    public static URL SWINGSET = get("swingset");
    public static URL TEDDY_BEAR = get("teddy_bear");
    public static URL TRICYCLE = get("tricycle");
    
    private static URL get(String icon) {
        try {
            return new URL("http://javabrain2.webcindario.com/color_icons/baby/"+icon+".bcon");
        } catch (java.net.MalformedURLException e) {}
        return null;
    }
    
}