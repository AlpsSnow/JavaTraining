package com.wangxing;

public enum Week {
    Monday("星期一",1) ,
    Tuesday("星期二",2),
    Wednesday("星期三",3),
    Thursday("星期四",4),
    Friday("星期五",5),
    Saturday("星期六",6),
    Sunday("星期天",7);

    private String m_chinesename;
    private int m_value;

    Week(String chinesename, int value) {
        m_chinesename = chinesename;
        m_value = value;
    }

    public String getChineseName() {
        return m_chinesename;
    }

    public void setChineseName(String m_chinesename) {
        this.m_chinesename = m_chinesename;
    }

    public int getValue() {
        return m_value;
    }

    public void setValue(int m_value) {
        this.m_value = m_value;
    }

}
