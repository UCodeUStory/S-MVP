package com.wangpos.s_mvp.bean;

import java.util.List;

/**
 * Created by qiyue on 2018/7/10.
 */

public class MeiziResult {


    private String showapi_res_error;
    private int showapi_res_code;
    private ShowapiResBodyBean showapi_res_body;

    @Override
    public String toString() {
        return "MeiziResult{" +
                "showapi_res_error='" + showapi_res_error + '\'' +
                ", showapi_res_code=" + showapi_res_code +
                ", showapi_res_body=" + showapi_res_body +
                '}';
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {

        private int ret_code;
        private PagebeanBean pagebean;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public PagebeanBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PagebeanBean pagebean) {
            this.pagebean = pagebean;
        }

        public static class PagebeanBean {

            private int allPages;
            private int currentPage;
            private int allNum;
            private int maxResult;
            private List<ContentlistBean> contentlist;

            public int getAllPages() {
                return allPages;
            }

            public void setAllPages(int allPages) {
                this.allPages = allPages;
            }

            public int getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(int currentPage) {
                this.currentPage = currentPage;
            }

            public int getAllNum() {
                return allNum;
            }

            public void setAllNum(int allNum) {
                this.allNum = allNum;
            }

            public int getMaxResult() {
                return maxResult;
            }

            @Override
            public String toString() {
                return "PagebeanBean{" +
                        "allPages=" + allPages +
                        ", currentPage=" + currentPage +
                        ", allNum=" + allNum +
                        ", maxResult=" + maxResult +
                        ", contentlist=" + contentlist +
                        '}';
            }

            public void setMaxResult(int maxResult) {
                this.maxResult = maxResult;
            }

            public List<ContentlistBean> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<ContentlistBean> contentlist) {
                this.contentlist = contentlist;
            }

            public static class ContentlistBean {


                private String typeName;
                private String title;
                private int type;
                private String itemId;
                private String ct;
                private List<ListBean> list;

                public String getTypeName() {
                    return typeName;
                }

                public void setTypeName(String typeName) {
                    this.typeName = typeName;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getItemId() {
                    return itemId;
                }

                public void setItemId(String itemId) {
                    this.itemId = itemId;
                }

                public String getCt() {
                    return ct;
                }

                public void setCt(String ct) {
                    this.ct = ct;
                }

                public List<ListBean> getList() {
                    return list;
                }

                public void setList(List<ListBean> list) {
                    this.list = list;
                }

                public static class ListBean {
                    /**
                     * big : http://image.tianjimedia.com/uploadImages/2015/162/24/9T0H9OF8B26M.jpg
                     * middle : http://image.tianjimedia.com/uploadImages/2015/162/24/9T0H9OF8B26M_680x500.jpg
                     * small : http://image.tianjimedia.com/uploadImages/2015/162/24/9T0H9OF8B26M_113.jpg
                     */

                    private String big;

                    @Override
                    public String toString() {
                        return "ListBean{" +
                                "big='" + big + '\'' +
                                ", middle='" + middle + '\'' +
                                ", small='" + small + '\'' +
                                '}';
                    }

                    private String middle;
                    private String small;

                    public String getBig() {
                        return big;
                    }

                    public void setBig(String big) {
                        this.big = big;
                    }

                    public String getMiddle() {
                        return middle;
                    }

                    public void setMiddle(String middle) {
                        this.middle = middle;
                    }

                    public String getSmall() {
                        return small;
                    }

                    public void setSmall(String small) {
                        this.small = small;
                    }
                }
            }
        }

        @Override
        public String toString() {
            return "ShowapiResBodyBean{" +
                    "ret_code=" + ret_code +
                    ", pagebean=" + pagebean +
                    '}';
        }
    }
}
