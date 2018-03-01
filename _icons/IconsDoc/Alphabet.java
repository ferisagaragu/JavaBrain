import java.net.URL;

/**
 *
 * @author Fernando Isaías García Aguirre
 */
public class Alphabet {
    
    public static String _0 = "0";
    public static String _0_C = "0_c";
    public static String _1ST = "1st";
    public static String _1_3 = "1_3";
    public static String _2 = "2";
    public static String _3 = "3";
    public static String _3_C = "3_c";
    public static String _4 = "4";
    public static String _5 = "5";
    public static String _5_C = "5_c";
    public static String _6 = "6";
    public static String _7 = "7";
    public static String _7_C = "7_c";
    public static String _8 = "8";
    public static String _8_C = "8_c";
    public static String _9 = "9";
    public static String _9_C = "9_c";
    public static String ADJECTIVE = "adjective";
    public static String ADVERB = "adverb";
    public static String ALPHA = "alpha";
    public static String ASTERISK = "asterisk";
    public static String BETA = "beta";
    public static String CIRCLED_0_ = "circled_0_";
    public static String CIRCLED_0_C = "circled_0_c";
    public static String CIRCLED_2_C = "circled_2_c";
    public static String CIRCLED_3_ = "circled_3_";
    public static String CIRCLED_3_C = "circled_3_c";
    public static String CIRCLED_4 = "circled_4";
    public static String CIRCLED_4_C = "circled_4_c";
    public static String CIRCLED_5_ = "circled_5_";
    public static String CIRCLED_5_C = "circled_5_c";
    public static String CIRCLED_6_ = "circled_6_";
    public static String CIRCLED_6_C = "circled_6_c";
    public static String CIRCLED_7_ = "circled_7_";
    public static String CIRCLED_7_C_4 = "circled_7_c_4";
    public static String CIRCLED_8_ = "circled_8_";
    public static String CIRCLED_8_C = "circled_8_c";
    public static String CIRCLED_9_ = "circled_9_";
    public static String CIRCLED_9__C_4 = "circled_9__c_4";
    public static String DEFINITE_ARTICLE = "definite_article";
    public static String EXCLAMATION_MARK = "exclamation_mark";
    public static String GAMMA = "gamma";
    public static String INDEFINITE_ARTICLE_3 = "indefinite_article_3";
    public static String LAMBDA_4 = "lambda_4";
    public static String LEVEL_1 = "level_1";
    public static String MU_3 = "mu_3";
    public static String NOUN_3 = "noun_3";
    public static String NUMBER_1 = "number_1";
    public static String NUMBER_2 = "number_2";
    public static String NUMBER_4_ = "number_4_";
    public static String NUMBER_6 = "number_6";
    public static String OMEGA_3 = "omega_3";
    public static String PI = "pi";
    public static String PRONOUN = "pronoun";
    public static String QUESTION_MARK = "question_mark";
    public static String SIGMA = "sigma";
    public static String TENSES = "tenses";
    public static String VERB = "verb";
    public static String _CIRCLED_2 = "_circled_2";
    
    public URL get(String icon) {
        try {
            return new URL("http://javabrain2.webcindario.com/color_icons/alphabet/"+icon+".bcon");
        } catch (java.net.MalformedURLException e) {}
        return null;
    }
    
}