package services;

public class Constants {
    public static final String REGEX_FOR_PAGES =  "\"Total URLs Encountered\",\"(\\d+)\",\"100\\.00%\",\"\\d+\",\"URLs Encountered\"";
    public static final String REGEX_FOR_TITLE_MISSING = "\"Page Titles\"[\\s\\S]*?\"Missing\",\"(\\d+)\"";
    public static final String REGEX_FOR_TITLE_DUPLICATE= "\"Page Titles\"[\\s\\S]*?\"Duplicate\",\"(\\d+)\"";
    public static final String REGEX_FOR_META_MISSING = "\"Meta Description\"[\\s\\S]*?\"Missing\",\"(\\d+)\"";
    public static final String REGEX_FOR_META_DUPLICATE = "\"Meta Description\"[\\s\\S]*?\"Duplicate\",\"(\\d+)\"";
    public static final String REGEX_FOR_H1_MISSING = "\"H1\"[\\s\\S]*?\"Missing\",\"(\\d+)\"";
    public static final String REGEX_FOR_H1_DUPLICATE = "\"H1\"[\\s\\S]*?\"Duplicate\",\"(\\d+)\"";
    public static final String REGEX_FOR_H2_MISSING = "\"H2\"[\\s\\S]*?\"Missing\",\"(\\d+)\"";
    public static final String REGEX_FOR_500 = "\"Server Error \\(5xx\\)\",\"(\\d+)\"";





}
