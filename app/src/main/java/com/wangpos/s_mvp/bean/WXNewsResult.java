package com.wangpos.s_mvp.bean;

import java.util.List;

/**
 * Created by qiyue on 2018/7/5.
 */

public class WXNewsResult {


    /**
     * reason : 请求成功
     * result : {"list":[{"id":"wechat_20180506012503","title":"30岁左右，手头有10几20万，这4台合资B级车是首选！","source":"有车以后","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933322.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012503"},{"id":"wechat_20180506012489","title":"一曲流连 | 张宇：这场戏的结局，一言难尽","source":"淘漉音乐","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933253.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012489"},{"id":"wechat_20180506012505","title":"惠若琪再受重用！大婚之后就敬业蜜月都不过，新工作太让人敬佩!","source":"懂小姐miss","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933361.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012505"},{"id":"wechat_20180506012499","title":"王家卫的电影，如果拿掉音乐会是什么样子？","source":"淘漉音乐","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933253.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012499"},{"id":"wechat_20180506012538","title":"别被坑了！车漆小划痕发黄其实你自己都能解决","source":"玩车教授","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933537.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012538"},{"id":"wechat_20180506012458","title":"只有加工资才能救中国经济！（深度好文）","source":"郎club","firstImg":"","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012458"},{"id":"wechat_20180506012481","title":"这些中国力量纷纷崛起，厉害了我的国！","source":"汽车之家","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933205.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012481"},{"id":"wechat_20180506012480","title":"\u201c25岁时，我的月薪是1000个馒头\u201d","source":"MBA智库","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933201.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012480"},{"id":"wechat_20180504035764","title":"海南楼市，一夜冰火：销售称遭灭顶之灾，地产商陷入群体性迷茫！","source":"金融行业网","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62932267.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180504035764"},{"id":"wechat_20180504035367","title":"夏天高温，车自燃都是这四个原因所致！","source":"车早茶","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62932204.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180504035367"}],"totalPage":23165,"ps":10,"pno":1}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * list : [{"id":"wechat_20180506012503","title":"30岁左右，手头有10几20万，这4台合资B级车是首选！","source":"有车以后","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933322.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012503"},{"id":"wechat_20180506012489","title":"一曲流连 | 张宇：这场戏的结局，一言难尽","source":"淘漉音乐","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933253.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012489"},{"id":"wechat_20180506012505","title":"惠若琪再受重用！大婚之后就敬业蜜月都不过，新工作太让人敬佩!","source":"懂小姐miss","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933361.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012505"},{"id":"wechat_20180506012499","title":"王家卫的电影，如果拿掉音乐会是什么样子？","source":"淘漉音乐","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933253.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012499"},{"id":"wechat_20180506012538","title":"别被坑了！车漆小划痕发黄其实你自己都能解决","source":"玩车教授","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933537.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012538"},{"id":"wechat_20180506012458","title":"只有加工资才能救中国经济！（深度好文）","source":"郎club","firstImg":"","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012458"},{"id":"wechat_20180506012481","title":"这些中国力量纷纷崛起，厉害了我的国！","source":"汽车之家","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933205.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012481"},{"id":"wechat_20180506012480","title":"\u201c25岁时，我的月薪是1000个馒头\u201d","source":"MBA智库","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933201.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012480"},{"id":"wechat_20180504035764","title":"海南楼市，一夜冰火：销售称遭灭顶之灾，地产商陷入群体性迷茫！","source":"金融行业网","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62932267.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180504035764"},{"id":"wechat_20180504035367","title":"夏天高温，车自燃都是这四个原因所致！","source":"车早茶","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62932204.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180504035367"}]
         * totalPage : 23165
         * ps : 10
         * pno : 1
         */

        private int totalPage;
        private int ps;
        private int pno;
        private List<ListBean> list;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPs() {
            return ps;
        }

        public void setPs(int ps) {
            this.ps = ps;
        }

        public int getPno() {
            return pno;
        }

        public void setPno(int pno) {
            this.pno = pno;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : wechat_20180506012503
             * title : 30岁左右，手头有10几20万，这4台合资B级车是首选！
             * source : 有车以后
             * firstImg : http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933322.static/640
             * mark :
             * url : http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012503
             */

            private String id;
            private String title;
            private String source;
            private String firstImg;
            private String mark;
            private String url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getFirstImg() {
                return firstImg;
            }

            public void setFirstImg(String firstImg) {
                this.firstImg = firstImg;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
