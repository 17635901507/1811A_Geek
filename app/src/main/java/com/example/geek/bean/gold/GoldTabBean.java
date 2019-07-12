package com.example.geek.bean.gold;

public class GoldTabBean {
    private String title;
    private boolean isFlag;
    private int index;

    public GoldTabBean(String title, boolean isFlag, int index) {
        this.title = title;
        this.isFlag = isFlag;
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
