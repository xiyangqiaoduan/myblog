package com.ycb.blog.model;

/**
 * 字典信息
 *
 * @author yangcb
 * @create 2017-05-11 10:11
 **/
public class Option {

    /**
     * 字典key
     */
    private String optionKey;
    /**
     * 字典value
     */
    private String optionValue;
    private String optionCategory;

    public String getOptionKey() {
        return optionKey;
    }

    public void setOptionKey(String optionKey) {
        this.optionKey = optionKey;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public String getOptionCategory() {
        return optionCategory;
    }

    public void setOptionCategory(String optionCategory) {
        this.optionCategory = optionCategory;
    }


    @Override
    public String toString() {
        return "Option{" +
                "optionKey='" + optionKey + '\'' +
                ", optionValue='" + optionValue + '\'' +
                ", optionCategory='" + optionCategory + '\'' +
                '}';
    }
}
