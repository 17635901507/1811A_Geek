package com.example.geek.bean.zhihu;

import java.util.List;

public class PaperBean {


    /**
     * date : 20190707
     * stories : [{"images":["https://pic4.zhimg.com/v2-fdc0a533340cf8ccbb0979035a06e35f.jpg"],"type":0,"id":9713001,"ga_prefix":"070720","title":"原生动物是如何演化成后生动物的？"},{"images":["https://pic2.zhimg.com/v2-a259c55ff27233e785fcb420848daa39.jpg"],"type":0,"id":9713137,"ga_prefix":"070716","title":"为什么有时候吃了油炸物就会喉咙痛？"},{"images":["https://pic1.zhimg.com/v2-1be723a6477cea643b241339f61f23b8.jpg"],"type":0,"id":9713119,"ga_prefix":"070709","title":"挑选优质的牛仔裤，首先了解牛仔布是怎么制成的"},{"images":["https://pic2.zhimg.com/v2-d174188f9460443dbee192c2f24d3ee5.jpg"],"type":0,"id":9713124,"ga_prefix":"070707","title":"人体哪个器官或者部位最委屈？"}]
     * top_stories : [{"image":"https://pic3.zhimg.com/v2-0561e05c2cdc1e230884967e5b3d0692.jpg","type":0,"id":9713084,"ga_prefix":"070409","title":"垃圾分类的难点，不仅是学会分类而已"},{"image":"https://pic4.zhimg.com/v2-6e440ce3443c435c0db5e57a30df9bbb.jpg","type":0,"id":9713146,"ga_prefix":"070620","title":"《长安十二时辰》中的望楼是什么？"},{"image":"https://pic3.zhimg.com/v2-7f708d55176cf8861b3cfce6bb4136fe.jpg","type":0,"id":9713072,"ga_prefix":"070306","title":"瞎扯 · 如何正确地吐槽"},{"image":"https://pic1.zhimg.com/v2-c832deb3af1576e5a490d2ab3d605744.jpg","type":0,"id":9712952,"ga_prefix":"063020","title":"为什么现在的建筑不盖成古代那样了？"},{"image":"https://pic4.zhimg.com/v2-e93a312f674d01e57bca0e0abe897547.jpg","type":0,"id":9712644,"ga_prefix":"061914","title":"自己人的广告 · 终极问题的终极答案"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-fdc0a533340cf8ccbb0979035a06e35f.jpg"]
         * type : 0
         * id : 9713001
         * ga_prefix : 070720
         * title : 原生动物是如何演化成后生动物的？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic3.zhimg.com/v2-0561e05c2cdc1e230884967e5b3d0692.jpg
         * type : 0
         * id : 9713084
         * ga_prefix : 070409
         * title : 垃圾分类的难点，不仅是学会分类而已
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
