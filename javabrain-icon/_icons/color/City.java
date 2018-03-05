import java.net.URL;

/**
 *
 * @author Fernando Isaías García Aguirre
 */
public class City {
    
    public static URL AIRPORT = get("airport");
    public static URL ARENA = get("arena");
    public static URL BANK = get("bank");
    public static URL BAR = get("bar");
    public static URL BASILICA = get("basilica");
    public static URL BENCH = get("bench");
    public static URL BIG_DROP = get("big_drop");
    public static URL BILLBOARD_3 = get("billboard_3");
    public static URL BOWING = get("bowing");
    public static URL BRIDGE = get("bridge");
    public static URL BUMPER_CAR = get("bumper_car");
    public static URL BUST = get("bust");
    public static URL CAFE = get("cafe");
    public static URL CAROUSEL = get("carousel");
    public static URL CATHEDRAL = get("cathedral");
    public static URL CATHEDRAL_OF_CHRIST_THE_SAVIOUR = get("cathedral_of_christ_the_saviour");
    public static URL CEMETERY = get("cemetery");
    public static URL CHAPEL = get("chapel");
    public static URL CIRCUS_TENT = get("circus_tent");
    public static URL CITY_CHURCH = get("city_church");
    public static URL CITY_HALL = get("city_hall");
    public static URL CITY_RAILWAY_STATION = get("city_railway_station");
    public static URL COTTON_CANDY = get("cotton_candy");
    public static URL COURTHOUSE = get("courthouse");
    public static URL DANGEROUS_CURRENT = get("dangerous_current");
    public static URL DINING = get("dining");
    public static URL DISPOSAL = get("disposal");
    public static URL DOG_PARK = get("dog_park");
    public static URL ELECTIONS = get("elections");
    public static URL EMBASSY = get("embassy");
    public static URL EQUESTRIAN_STATUE = get("equestrian_statue");
    public static URL FERRIS_WHEEL = get("ferris_wheel");
    public static URL FIRE_ALARM = get("fire_alarm");
    public static URL FIRE_HOSE = get("fire_hose");
    public static URL FIRE_HYDRANT = get("fire_hydrant");
    public static URL FIRE_STATION = get("fire_station");
    public static URL FOOD_SERVICE = get("food_service");
    public static URL FOUNTAIN = get("fountain");
    public static URL GARBAGE_TRUCK = get("garbage_truck");
    public static URL GAS_STATION = get("gas_station");
    public static URL HOSPITAL = get("hospital");
    public static URL HOSPITAL_SIGN = get("hospital_sign");
    public static URL HOTEL = get("hotel");
    public static URL HOTEL_BUILDING = get("hotel_building");
    public static URL HOTEL_STAR = get("hotel_star");
    public static URL JUMP = get("jump");
    public static URL LION_STATUE = get("lion_statue");
    public static URL MARKET_SQUARE = get("market_square");
    public static URL MEAL = get("meal");
    public static URL MERRY_GO_ROUND = get("merry_go_round");
    public static URL METAL_DETECTOR = get("metal_detector");
    public static URL MONASTERY = get("monastery");
    public static URL MONUMENT = get("monument");
    public static URL MOVE_SHIT_AROUND = get("move_shit_around");
    public static URL MUNICH_CATHEDRAL = get("munich_cathedral");
    public static URL NO_ALCOHOL = get("no_alcohol");
    public static URL NO_ANIMALS_3 = get("no_animals_3");
    public static URL NO_BAGGAGE = get("no_baggage");
    public static URL NO_BEVERAGES = get("no_beverages");
    public static URL NO_CAMERA = get("no_camera");
    public static URL NO_CASH = get("no_cash");
    public static URL NO_CREDIT_CARDS = get("no_credit_cards");
    public static URL NO_DIVING = get("no_diving");
    public static URL NO_DRUGS = get("no_drugs");
    public static URL NO_FOOD = get("no_food");
    public static URL NO_MOBILE = get("no_mobile");
    public static URL NO_RUNNING = get("no_running");
    public static URL NO_SCUBA_DIVING = get("no_scuba_diving");
    public static URL NO_SELFIE = get("no_selfie");
    public static URL NO_SELFIE_STICK = get("no_selfie_stick");
    public static URL NO_SHOES = get("no_shoes");
    public static URL NO_SMOKING = get("no_smoking");
    public static URL NO_SWIMMING = get("no_swimming");
    public static URL NO_WEAPONS = get("no_weapons");
    public static URL OBELISK = get("obelisk");
    public static URL ORTHODOX_CHURCH = get("orthodox_church");
    public static URL PAGODA = get("pagoda");
    public static URL PALACE = get("palace");
    public static URL PARLIAMENT = get("parliament");
    public static URL PARTY = get("party");
    public static URL PARTY_BALOONS = get("party_baloons");
    public static URL PARTY_HAT = get("party_hat");
    public static URL PAVILION = get("pavilion");
    public static URL PIAZZA = get("piazza");
    public static URL PLAYGROUND = get("playground");
    public static URL POLICE_STATION = get("police_station");
    public static URL POOP = get("poop");
    public static URL POSTER = get("poster");
    public static URL POST_OFFICE = get("post_office");
    public static URL PRISON = get("prison");
    public static URL RESERVATION = get("reservation");
    public static URL RESTAURANT = get("restaurant");
    public static URL RESTAURANT_BUILDING = get("restaurant_building");
    public static URL RESTAURANT_MENU = get("restaurant_menu");
    public static URL RESTAURANT_TABLE = get("restaurant_table");
    public static URL ROLLER_COASTER = get("roller_coaster");
    public static URL SCULPTURE = get("sculpture");
    public static URL SEESAW = get("seesaw");
    public static URL SEGWAY = get("segway");
    public static URL SHERIFF = get("sheriff");
    public static URL SKEEBALL = get("skeeball");
    public static URL SKYSCRAPERS = get("skyscrapers");
    public static URL SLIPPERY_FLOOR = get("slippery_floor");
    public static URL SMOKING = get("smoking");
    public static URL STADIUM = get("stadium");
    public static URL STAGE = get("stage");
    public static URL STATUE = get("statue");
    public static URL SWIMMING_POOL = get("swimming_pool");
    public static URL SWINGING_BOAT = get("swinging_boat");
    public static URL SYNAGOGUE = get("synagogue");
    public static URL TELESCOPE = get("telescope");
    public static URL TEMPLE = get("temple");
    public static URL TOLLBOOTH = get("tollbooth");
    public static URL VILLAGE = get("village");
    public static URL WAITER = get("waiter");
    public static URL WAREHOUSE = get("warehouse");
    public static URL WATCH_YOUR_STEP = get("watch_your_step");
    public static URL WATER_PARK = get("water_park");
    public static URL WATER_TOWER = get("water_tower");
    public static URL WHARF = get("wharf");
    
    private static URL get(String icon) {
        try {
            return new URL("http://javabrain2.webcindario.com/color_icons/city/"+icon+".bcon");
        } catch (java.net.MalformedURLException e) {}
        return null;
    }
    
}