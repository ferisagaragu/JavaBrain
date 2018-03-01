package iconsdoc;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author QualtopGroup
 */
public class Other {
    
    public static Bcon _0 = new Bcon(new ImageIcon(get("0")));
    public static URL _0_C = get("0_c");
    public static URL _1ST = get("1st");
    public static URL _1_3 = get("1_3");
    public static URL _2 = get("2");
    public static URL _3 = get("3");
    public static URL _3_C = get("3_c");
    public static URL _4 = get("4");
    public static URL _5 = get("5");
    public static URL _5_C = get("5_c");
    public static URL _6 = get("6");
    public static URL _7 = get("7");
    public static URL _7_C = get("7_c");
    public static URL _8 = get("8");
    public static URL _8_C = get("8_c");
    public static URL _9 = get("9");
    public static URL _9_C = get("9_c");
    public static URL ADJECTIVE = get("adjective");
    public static URL ADVERB = get("adverb");
    public static URL ALPHA = get("alpha");
    public static URL ASTERISK = get("asterisk");
    public static URL BETA = get("beta");
    public static URL CIRCLED_0_ = get("circled_0_");
    public static URL CIRCLED_0_C = get("circled_0_c");
    public static URL CIRCLED_2_C = get("circled_2_c");
    public static URL CIRCLED_3_ = get("circled_3_");
    public static URL CIRCLED_3_C = get("circled_3_c");
    public static URL CIRCLED_4 = get("circled_4");
    public static URL CIRCLED_4_C = get("circled_4_c");
    public static URL CIRCLED_5_ = get("circled_5_");
    public static URL CIRCLED_5_C = get("circled_5_c");
    public static URL CIRCLED_6_ = get("circled_6_");
    public static URL CIRCLED_6_C = get("circled_6_c");
    public static URL CIRCLED_7_ = get("circled_7_");
    public static URL CIRCLED_7_C_4 = get("circled_7_c_4");
    public static URL CIRCLED_8_ = get("circled_8_");
    public static URL CIRCLED_8_C = get("circled_8_c");
    public static URL CIRCLED_9_ = get("circled_9_");
    public static URL CIRCLED_9__C_4 = get("circled_9__c_4");
    public static URL DEFINITE_ARTICLE = get("definite_article");
    public static URL EXCLAMATION_MARK = get("exclamation_mark");
    public static URL GAMMA = get("gamma");
    public static URL INDEFINITE_ARTICLE_3 = get("indefinite_article_3");
    public static URL LAMBDA_4 = get("lambda_4");
    public static URL LEVEL_1 = get("level_1");
    public static URL MU_3 = get("mu_3");
    public static URL NOUN_3 = get("noun_3");
    public static URL NUMBER_1 = get("number_1");
    public static URL NUMBER_2 = get("number_2");
    public static URL NUMBER_4_ = get("number_4_");
    public static URL NUMBER_6 = get("number_6");
    public static URL OMEGA_3 = get("omega_3");
    public static URL PI = get("pi");
    public static URL PRONOUN = get("pronoun");
    public static URL QUESTION_MARK = get("question_mark");
    public static URL SIGMA = get("sigma");
    public static URL TENSES = get("tenses");
    public static URL VERB = get("verb");
    public static URL _CIRCLED_2 = get("_circled_2");
    
    private static URL get(String icon) {
        try {
            return new URL("http://javabrain2.webcindario.com/color_icons/alphabet/"+icon+".bcon");
        } catch (java.net.MalformedURLException e) {}
        return null;
    }
    
    
}
