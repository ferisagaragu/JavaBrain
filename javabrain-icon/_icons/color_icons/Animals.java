import java.net.URL;

/**
 *
 * @author Fernando Isaías García Aguirre
 */
public class Animals {
    
    public static URL ALLIGATOR = get("alligator");
    public static URL ANT = get("ant");
    public static URL AQUARIUM = get("aquarium");
    public static URL BADGER = get("badger");
    public static URL BAT_FACE = get("bat_face");
    public static URL BEAR = get("bear");
    public static URL BEAR_FOOTPRINT = get("bear_footprint");
    public static URL BEAVER = get("beaver");
    public static URL BEE = get("bee");
    public static URL BIRD = get("bird");
    public static URL BUMBLEBEE = get("bumblebee");
    public static URL BUTTERFLY = get("butterfly");
    public static URL CAT = get("cat");
    public static URL CATERPILLAR_3 = get("caterpillar_3");
    public static URL CAT_FOOTPRINT = get("cat_footprint");
    public static URL CHICKEN = get("chicken");
    public static URL CHICKEN_LADDER_3 = get("chicken_ladder_3");
    public static URL CLOWN_FISH = get("clown_fish");
    public static URL CORAL = get("coral");
    public static URL CORGI = get("corgi");
    public static URL COW = get("cow");
    public static URL CRAB = get("crab");
    public static URL DEER = get("deer");
    public static URL DINOSAUR = get("dinosaur");
    public static URL DOG = get("dog");
    public static URL DOG_BONE_4 = get("dog_bone_4");
    public static URL DOG_BOWL = get("dog_bowl");
    public static URL DOG_HOUSE = get("dog_house");
    public static URL DOG_LEASH = get("dog_leash");
    public static URL DOG_PAW = get("dog_paw");
    public static URL DOLPHIN = get("dolphin");
    public static URL DOVE = get("dove");
    public static URL DRAGONFLY = get("dragonfly");
    public static URL DUCK = get("duck");
    public static URL EARTH_WORM = get("earth_worm");
    public static URL ELEPHANT = get("elephant");
    public static URL FALCON = get("falcon");
    public static URL FARM_HOUSE_3 = get("farm_house_3");
    public static URL FENIX = get("fenix");
    public static URL FISH = get("fish");
    public static URL FLY = get("fly");
    public static URL FOX = get("fox");
    public static URL FROG = get("frog");
    public static URL GERMAN_SHEPHERD = get("german_shepherd");
    public static URL GIRAFFE = get("giraffe");
    public static URL GORILLA = get("gorilla");
    public static URL GRASSHOPPER = get("grasshopper");
    public static URL HIVE_3 = get("hive_3");
    public static URL HORNET_3 = get("hornet_3");
    public static URL HORSE = get("horse");
    public static URL HUMMINGBIRD = get("hummingbird");
    public static URL INSECT_3 = get("insect_3");
    public static URL KANGAROO = get("kangaroo");
    public static URL KIWI_BIRD = get("kiwi_bird");
    public static URL KOI_FISH_3 = get("koi_fish_3");
    public static URL LADYBIRD = get("ladybird");
    public static URL LAMB = get("lamb");
    public static URL LEOPARD = get("leopard");
    public static URL LION = get("lion");
    public static URL LLAMA = get("llama");
    public static URL MACHAON_BUTTERFLY = get("machaon_butterfly");
    public static URL MITE_3 = get("mite_3");
    public static URL MONARCH_BUTTERFLY = get("monarch_butterfly");
    public static URL MOSQUITO_3 = get("mosquito_3");
    public static URL OCTOPUS = get("octopus");
    public static URL OSTRICH_HEAD_IN_SAND_3 = get("ostrich_head_in_sand_3");
    public static URL OWL = get("owl");
    public static URL PANDA = get("panda");
    public static URL PARANTICA_SITA_BUTTERFLY = get("parantica_sita_butterfly");
    public static URL PARROT = get("parrot");
    public static URL PEACOCK = get("peacock");
    public static URL PELICAN = get("pelican");
    public static URL PIG = get("pig");
    public static URL PIG_WITH_LIPSTICK = get("pig_with_lipstick");
    public static URL PRAWN = get("prawn");
    public static URL PUFFIN_BIRD = get("puffin_bird");
    public static URL PUG = get("pug");
    public static URL RABBIT = get("rabbit");
    public static URL RHINOCEROS = get("rhinoceros");
    public static URL RUNNING_RABBIT = get("running_rabbit");
    public static URL SEAHORSE = get("seahorse");
    public static URL SHARK = get("shark");
    public static URL SHEEP = get("sheep");
    public static URL SHEEP_ON_BIKE = get("sheep_on_bike");
    public static URL SHIBA_INU = get("shiba_inu");
    public static URL SLOTH = get("sloth");
    public static URL SLUG = get("slug");
    public static URL SLUG_EATING = get("slug_eating");
    public static URL SNAIL = get("snail");
    public static URL STARFISH = get("starfish");
    public static URL STONED_BAT = get("stoned_bat");
    public static URL SURICATE_LUNETTE = get("suricate_lunette");
    public static URL SWAN = get("swan");
    public static URL TAIL_OF_WHALE = get("tail_of_whale");
    public static URL TENTACLES = get("tentacles");
    public static URL TIGER_BUTTERFLY = get("tiger_butterfly");
    public static URL TRASH_DOVE = get("trash_dove");
    public static URL TRILOBITE_3 = get("trilobite_3");
    public static URL TURTLE = get("turtle");
    public static URL WASP = get("wasp");
    public static URL WHALE = get("whale");
    public static URL WOLF = get("wolf");
    public static URL YORKSHIRE_TERRIER_3 = get("yorkshire_terrier_3");
    public static URL ZEBRA_3 = get("zebra_3");
    
    private static URL get(String icon) {
        try {
            return new URL("http://javabrain2.webcindario.com/color_icons/animals/"+icon+".bcon");
        } catch (java.net.MalformedURLException e) {}
        return null;
    }
    
}