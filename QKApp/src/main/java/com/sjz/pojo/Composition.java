package com.sjz.pojo;

public class Composition {
    private int cid;
    private String type;    //类型
    private String title;   //标题
    private String chinese; //中文翻译
    private String english; //英文翻译
    private String image;   //图片
    private int likeNum;    //点赞数
    private String phrase;  //词组

    public Composition() {
    }

    public Composition(String type, String title, String chinese, String english, String image, int likeNum, String phrase) {
        this.type = type;
        this.title = title;
        this.chinese = chinese;
        this.english = english;
        this.image = image;
        this.likeNum = likeNum;
        this.phrase = phrase;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
