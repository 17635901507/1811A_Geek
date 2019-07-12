package com.example.geek.base;

import com.example.geek.bean.gold.GoldTabBean;
import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static List<GoldTabBean> tabGoldList = new ArrayList<>();
    //        {"Android", "iOS", "前端", "后端", "设计", "产品", "阅读", "工具资源"};
    static{
        tabGoldList.add(new GoldTabBean("Android",true,0));
        tabGoldList.add(new GoldTabBean("iOS",true,1));
        tabGoldList.add(new GoldTabBean("前端",true,2));
        tabGoldList.add(new GoldTabBean("后端",true,3));
        tabGoldList.add(new GoldTabBean("设计",false,4));
        tabGoldList.add(new GoldTabBean("产品",false,5));
        tabGoldList.add(new GoldTabBean("阅读",false,6));
        tabGoldList.add(new GoldTabBean("工具资源",false,7));
    }
}
