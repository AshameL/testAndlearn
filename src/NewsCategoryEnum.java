import java.util.List;

/**
 * Created by thomas on 16-12-7.
 */
public enum NewsCategoryEnum {
    ALL(0, "全部"),
    MARKET(1, "市场"),
    POLICY(2, "政策"),
    LAND(3, "土地"),
    DATA(4, "数据"),
    ENTERPRISE(5, "企业"),
    INTERVIEW(6, "访谈"),
    PROJECT(7, "项目"),
    OTHERS(8, "其他"),

    HOME_WITHDRAW(11, "收房", 1),
    HOME_DESIGN(12, "设计"),
    HOME_BUDGET(13, "预算", 1),
    HOME_CONTRACT(14, "合同", 1),
    HOME_LOCATION(15, "风水"),

    HOME_MATERIAL(21, "选材"),
    HOME_APART(22, "拆改", 1),
    HOME_HYDROELECTRIC(23, "水电", 1),
    HOME_WOOD(24, "泥木", 1),
    HOME_PAINT(25, "油漆", 1),
    HOME_INSTALL(26, "安装", 1),
    HOME_CHECK(27, "验收", 1),

    HOME_ENVIRONMENT(31, "环保", 1),
    HOME_GUIDE(32, "导购"),
    HOME_ASSORT(33, "搭配", 1),
    HOME_LIVING(34, "入住", 1),

    HOME_INTELLIGENCE(41, "智能"),
    HOME_EVALUATE(42, "评测"),
    HOME_INFO(43, "新闻"),

    HOME_APPRECIATE(51, "鉴赏"),
    HOME_TATTLE(52, "杂谈", 1),

    HOME_GOOD(61, "好物"),
    HOME_HOLDER(62, "居家"),
    HOME_PET(63, "萌宠"),
    HOME_GARDEN(64, "园艺"),
    HOME_STRONG(65, "健身"),
    HOME_FOODS(66, "美食"),

    // 新增：wiki
    //（攻略-流程）
    HOME_LIVE(70, "直播"),
    //（攻略-功能）
    HOME_ACCEPT(71, "收纳"),
    HOME_VENTILATE(72, "通风"),
    HOME_AIR_CONDITION(73, "空调"),
    HOME_LIGHTING(74, "照明"),
    HOME_HEATING(75, "采暖"),
    HOME_FEED_WATER(76, "上水"),
    HOME_DRAIN_WATER(77, "排水"),
    HOME_FURRED_CEILING(78, "吊顶"),
    //  （攻略-产品）
    HOME_BATHROOM(79, "卫浴"),
    HOME_WARDROBE(80, "衣柜"),
    HOME_KTICHEN(81, "厨房"),
    HOME_HOUSEHOLD(82, "家电"),
    HOME_FURNITURE(83, "家具"),
    HOME_FLOOR(84, "地板"),
    HOME_CEILWALL(85, "顶墙"),
    HOME_DOOR_WINDOW(86, "五金门窗"),
    HOME_WATERPROOF(87, "防水"),
    HOME_AUXILIARY_MATERIAL(88, "铺材"),
    HOME_DECORATION(89, "装饰"),
    HOME_CERAMIC_TILE(90, "瓷砖"),
    //（资讯-新增）
    HOME_INDUSTRY_FOCUS(91, "行业聚焦"),
    HOME_CORPORATE_NEWS(92, "企业新闻"),
    HOME_DEEP_VIEW(93, "深度观点"),
    HOME_DECORATION_WINDOW(94, "家装视窗"),
    // 新增end

    HOME_HARD(100, "硬装"),
    HOME_SOFT(200, "软装"),


    HOME_DATE(1000, "日记大赛"),


    SECOND_HOUSE(2000, "二手房"),

    MICRO_ECONOMY(3000, "宏观经济"),

    FOREIGN(4000, "海外全部"),
    FOREIGN_AMERICA(4001, "美国"),
    FOREIGN_CANADA(4002, "加拿大"),
    FOREIGN_AUSTRALIA(4003, "澳大利亚"),
    FOREIGN_BRITAIN(4004, "英国"),
    FOREIGN_JAPAN(4005, "日本"),
    FOREIGN_THAILAND(4006, "泰国"),
    FOREIGN_GREECE(4007, "希腊"),
    FOREIGN_NEWZEALAND(4008, "新西兰"),
    FOREIGN_UAE(4009, "阿联酋"),
    FOREIGN_PHILIPPINES(4010, "菲律宾"),
    FOREIGN_MALAYSIA(4011, "马来西亚"),
    FOREIGN_GERMANY(4012, "德国"),
    FOREIGN_OTHERS(4013, "其他"),
    FOREIGN_END(4999, "海外结束标志位"),

    // 之所以商业全部不是5000是填了海外分类的一个坑，主站那边已经把5000视为和海外有关了
    BUSINESS_NEWS(5001, "商业快讯"),
    BUSINESS_PERSON(5002, "热点人物"),
    BUSINESS_ACTIVITY(5003, "行业活动"),
    BUSINESS_SUBJECT(5004, "商业专题"),
    BUSINESS_DATA(5005, "商业数据"),
    BUSINESS_ALL(5006, "商业全部");


    private int type;
    private String desc;
    private int status;//采用Linux权限标识方法1-可读，2-可写，3-可读并可写

    NewsCategoryEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
        this.status = 3;
    }

    NewsCategoryEnum(int type, String desc, int status) {
        this(type, desc);
        this.status = status;
    }

    private final static List<Integer> allForeignCategoryList = Lists.newArrayList();
    private final static List<Integer> allHouseCategoryList = Lists.newArrayList();
    private final static List<Integer> allBusinessCategoryList = Lists.newArrayList();

    static {
        for (NewsCategoryEnum newsCategoryEnum : NewsCategoryEnum.values()) {
            if (newsCategoryEnum.getType() >= FOREIGN.type && newsCategoryEnum.getType() < FOREIGN_END.type) {
                allForeignCategoryList.add(newsCategoryEnum.getType());
            }
        }
    }

    static {
        for (NewsCategoryEnum newsCategoryEnum : NewsCategoryEnum.values()) {
            if (newsCategoryEnum.getType() >= BUSINESS_NEWS.type && newsCategoryEnum.getType() <= BUSINESS_ALL.type) {
                allBusinessCategoryList.add(newsCategoryEnum.getType());
            }
        }
    }

    static {
        for (NewsCategoryEnum newsCategoryEnum : NewsCategoryEnum.values()) {
            if (newsCategoryEnum.getType() >= ALL.type && newsCategoryEnum.getType() <= OTHERS.type) {
                allHouseCategoryList.add(newsCategoryEnum.getType());
            }
        }
    }

    public static List<Integer> getAllForeignCategoryList() {
        return allForeignCategoryList;
    }

    public static List<Integer> getAllBusinessCategoryList() {
        return allBusinessCategoryList;
    }

    public static List<Integer> getAllHouseCategoryList() {
        return allHouseCategoryList;
    }

    /**
     * @param type
     * @return
     */
    public static boolean hasCategory(Integer type) {

        boolean hasCategory = false;

        for (NewsCategoryEnum newsCategoryEnum : NewsCategoryEnum.values()) {
            if (type == newsCategoryEnum.getType() && (newsCategoryEnum.getStatus() & 2) != 0) {
                hasCategory = true;
                break;
            }
        }

        return hasCategory;
    }

    /**
     * @param type
     * @return
     */
    public static boolean hasHomeCategory(int type) {

        boolean hasCategory = false;

        for (NewsCategoryEnum newsCategoryEnum : NewsCategoryEnum.values()) {
            if (inHomeRange(type) && type == newsCategoryEnum.getType()
                    && (newsCategoryEnum.getStatus() & 2) != 0) {
                hasCategory = true;
                break;
            }
        }

        return hasCategory;
    }

    /**
     * 是否家居类型
     *
     * @param type
     * @return
     */
    public static boolean inHomeRange(int type) {
        boolean yes = false;
        if (type > OTHERS.getType() && type < SECOND_HOUSE.getType()) {
            yes = true;
        }
        return yes;
    }

    /**
     * 是否房产类型
     *
     * @param type
     * @return
     */
    public static boolean inHouseRange(int type) {
        boolean yes = false;
        if (type > 0 && type <= OTHERS.getType()) {
            yes = true;
        }
        return yes;
    }

    /**
     * 是否二手房类型
     *
     * @param type
     * @return
     */
    public static boolean inSecondHouseRange(int type) {
        return SECOND_HOUSE.getType() == type;
    }

    /**
     * 是否宏观经济类型
     *
     * @param type
     * @return
     */
    public static boolean inMicroEconomyRange(int type) {
        return MICRO_ECONOMY.getType() == type;
    }

    /**
     * 是否海外类型
     */
    public static boolean inForeignRange(int type) {
        boolean yes = false;
        if (type >= FOREIGN.getType() && type < FOREIGN_END.getType()) {
            yes = true;
        }
        return yes;
    }

    /**
     * 是否商业类型
     *
     * @param type
     * @return
     */
    public static boolean inBusinessRange(int type) {
        boolean yes = false;
        if (type >= BUSINESS_NEWS.getType() && type <= BUSINESS_DATA.getType()) {
            yes = true;
        }
        return yes;
    }

}
