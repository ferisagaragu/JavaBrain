import java.net.URL;

/**
 *
 * @author Fernando Isaías García Aguirre
 */
public class Arrows {
    
    public static URL ADVANCE = get("advance");
    public static URL ARROW = get("arrow");
    public static URL ARROW_POINTING_DOWN = get("arrow_pointing_down");
    public static URL ARROW_UP = get("arrow_up");
    public static URL BACK = get("back");
    public static URL BACK_ARROW = get("back_arrow");
    public static URL BACK_TO = get("back_to");
    public static URL BELOW = get("below");
    public static URL CHEVRON = get("chevron");
    public static URL CHEVRON_DOWN = get("chevron_down");
    public static URL CHEVRON_LEFT = get("chevron_left");
    public static URL CHEVRON_RIGHT = get("chevron_right");
    public static URL CHEVRON_UP = get("chevron_up");
    public static URL CIRCLED_DOWN_LEFT = get("circled_down_left");
    public static URL CIRCLED_DOWN_LEFT_2 = get("circled_down_left_2");
    public static URL CIRCLED_DOWN_RIGHT = get("circled_down_right");
    public static URL CIRCLED_DOWN_RIGHT_2 = get("circled_down_right_2");
    public static URL CIRCLED_RIGHT = get("circled_right");
    public static URL CIRCLED_UP_LEFT = get("circled_up_left");
    public static URL CIRCLED_UP_LEFT_2 = get("circled_up_left_2");
    public static URL CIRCLED_UP_RIGHT = get("circled_up_right");
    public static URL CIRCLED_UP_RIGHT_2 = get("circled_up_right_2");
    public static URL COLLAPSE_ARROW = get("collapse_arrow");
    public static URL COMPRESS = get("compress");
    public static URL CURVED_ARROW = get("curved_arrow");
    public static URL DIRECTION = get("direction");
    public static URL DIVIDER = get("divider");
    public static URL DOUBLE_DOWN = get("double_down");
    public static URL DOUBLE_LEFT = get("double_left");
    public static URL DOUBLE_RIGHT = get("double_right");
    public static URL DOUBLE_UP = get("double_up");
    public static URL DOWNWARD_ARROW = get("downward_arrow");
    public static URL DOWN_3 = get("down_3");
    public static URL DOWN_ARROW = get("down_arrow");
    public static URL DOWN_BUTTON = get("down_button");
    public static URL DOWN_LEFT = get("down_left");
    public static URL DOWN_LEFT_3 = get("down_left_3");
    public static URL DOWN_RIGHT = get("down_right");
    public static URL DOWN_RIGHT_3 = get("down_right_3");
    public static URL DRAG = get("drag");
    public static URL DROP_DOWN = get("drop_down");
    public static URL ENLARGE = get("enlarge");
    public static URL EXPAND_ARROW = get("expand_arrow");
    public static URL FORWARD = get("forward");
    public static URL FORWARD_ARROW_3 = get("forward_arrow_3");
    public static URL FORWARD_BUTTON = get("forward_button");
    public static URL GO_BACK = get("go_back");
    public static URL LEFT = get("left");
    public static URL LEFT_2 = get("left_2");
    public static URL LEFT_3 = get("left_3");
    public static URL LEFT_DOWN_2 = get("left_down_2");
    public static URL LONG_ARROW_LEFT = get("long_arrow_left");
    public static URL LONG_ARROW_UP = get("long_arrow_up");
    public static URL MERGE_HORIZONTAL = get("merge_horizontal");
    public static URL MERGE_VERTICAL = get("merge_vertical");
    public static URL NEXT_PAGE = get("next_page");
    public static URL PREV = get("prev");
    public static URL REDO = get("redo");
    public static URL REPLY_ALL_ARROW = get("reply_all_arrow");
    public static URL REPLY_ARROW = get("reply_arrow");
    public static URL RESIZE_HORIZONTAL = get("resize_horizontal");
    public static URL RESIZE_VERTICAL = get("resize_vertical");
    public static URL RETURN = get("return");
    public static URL RIGHT = get("right");
    public static URL RIGHT_2 = get("right_2");
    public static URL RIGHT_ARROW = get("right_arrow");
    public static URL RIGHT_BUTTON = get("right_button");
    public static URL RIGHT_UP_2 = get("right_up_2");
    public static URL SCROLL_DOWN = get("scroll_down");
    public static URL SCROLL_UP_3 = get("scroll_up_3");
    public static URL SLIDE_UP = get("slide_up");
    public static URL SORT = get("sort");
    public static URL SORT_DOWN = get("sort_down");
    public static URL SORT_LEFT = get("sort_left");
    public static URL SORT_RIGHT = get("sort_right");
    public static URL SORT_UP = get("sort_up");
    public static URL SPLIT_VERTICAL = get("split_vertical");
    public static URL TURN = get("turn");
    public static URL UNDO = get("undo");
    public static URL UP = get("up");
    public static URL UPWARD_ARROW_3 = get("upward_arrow_3");
    public static URL UP_2 = get("up_2");
    public static URL UP_3 = get("up_3");
    public static URL UP_DOWN_ARROW_ = get("up_down_arrow_");
    public static URL UP_LEFT = get("up_left");
    public static URL UP_LEFT_3 = get("up_left_3");
    public static URL UP_RIGHT = get("up_right");
    public static URL UP_RIGHT_3 = get("up_right_3");
    public static URL UP_SQUARED = get("up_squared");
    
    private static URL get(String icon) {
        try {
            return new URL("http://javabrain2.webcindario.com/color_icons/arrows/"+icon+".bcon");
        } catch (java.net.MalformedURLException e) {}
        return null;
    }
    
}