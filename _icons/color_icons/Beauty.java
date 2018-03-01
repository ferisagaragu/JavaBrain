import java.net.URL;

/**
 *
 * @author Fernando Isaías García Aguirre
 */
public class Beauty {
    
    public static URL AROMATIC_STICK = get("aromatic_stick");
    public static URL BARBERSHOP = get("barbershop");
    public static URL BARBER_CHAIR = get("barber_chair");
    public static URL BARBER_POLE_3 = get("barber_pole_3");
    public static URL BARBER_SCISSORS = get("barber_scissors");
    public static URL BEARD = get("beard");
    public static URL COMB_3 = get("comb_3");
    public static URL COSMETIC_BRUSH = get("cosmetic_brush");
    public static URL ENGLISH_MUSTACHE = get("english_mustache");
    public static URL FACE_POWDER = get("face_powder");
    public static URL FOUNDATION_MAKEUP = get("foundation_makeup");
    public static URL GOATEE = get("goatee");
    public static URL HAIR_BRUSH = get("hair_brush");
    public static URL HAIR_CLIP = get("hair_clip");
    public static URL HAIR_DRYER = get("hair_dryer");
    public static URL HAIR_WASHING_SINK = get("hair_washing_sink");
    public static URL HEADBAND = get("headband");
    public static URL LIPS = get("lips");
    public static URL LIPSTICK = get("lipstick");
    public static URL LIP_GLOSS = get("lip_gloss");
    public static URL MAKEUP = get("makeup");
    public static URL MASCARA = get("mascara");
    public static URL MIRROR = get("mirror");
    public static URL MUSTACHE = get("mustache");
    public static URL NAILS = get("nails");
    public static URL NAIL_POLISH = get("nail_polish");
    public static URL PERFUME_BOTTLE = get("perfume_bottle");
    public static URL REFLECTION = get("reflection");
    public static URL SCRUNCHY = get("scrunchy");
    public static URL SHORT_BEARD = get("short_beard");
    public static URL SIDEBURNS = get("sideburns");
    public static URL SPA_CANDLE = get("spa_candle");
    public static URL SPA_FLOWER = get("spa_flower");
    public static URL SPRAY = get("spray");
    public static URL STONES = get("stones");
    public static URL STUBBLE = get("stubble");
    public static URL TUBE = get("tube");
    public static URL VAN_DYKE = get("van_dyke");
    public static URL WOMANS_HAIR = get("womans_hair");
    
    private static URL get(String icon) {
        try {
            return new URL("http://javabrain2.webcindario.com/color_icons/beauty/"+icon+".bcon");
        } catch (java.net.MalformedURLException e) {}
        return null;
    }
    
}