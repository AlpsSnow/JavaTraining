package com.wangxing;

import javax.xml.soap.SOAPPart;

public class Main {

    public static void main(String[] args) {
        System.out.println("输出Week枚举的所有成员的name：");
        for(Week w : Week.values()){
            System.out.println(w.name());
        }

        System.out.println("输出Week枚举的所有成员的下标(ordinal)：");
        for(Week w : Week.values()){
            System.out.println(w.ordinal());
        }

        System.out.println("输出Week枚举的所有成员的m_chinesename：");
        for(Week w : Week.values()){
            System.out.println(w.getChineseName());
        }

        System.out.println("输出Week枚举的所有成员的m_value：");
        for(Week w : Week.values()){
            System.out.println(w.getValue());
        }
    }
}
