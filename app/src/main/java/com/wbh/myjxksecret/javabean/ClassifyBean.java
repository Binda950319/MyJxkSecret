package com.wbh.myjxksecret.javabean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class ClassifyBean {

    /**
     * id : null
     * success : true
     * reCode : null
     * message : null
     * obj : [{"categorypicUrl":"http://7xloyz.com2.z0.glb.qiniucdn.com/globalprice_sort_beauty.png","isLowPrice":1,"categoryName":"个护美妆","categoryId":"3e6438d6048199663d841e88c084175c"},{"categorypicUrl":"http://7xloyz.com2.z0.glb.qiniucdn.com/globalprice_sort_bags.png%402x_1.png","isLowPrice":0,"categoryName":"箱包","categoryId":"394559e68ea10969b012e16713c3d58b"},{"categorypicUrl":"http://7xloyz.com2.z0.glb.qiniucdn.com/globalprice_sort_accessories2.png","isLowPrice":0,"categoryName":"配饰","categoryId":"e2c47183cbd12f68cb959a43b676cae2"},{"categorypicUrl":"http://7xloyz.com2.z0.glb.qiniucdn.com/globalpricesortelectronics.png","isLowPrice":0,"categoryName":"电子产品","categoryId":"cdce861f8e0123644ff6c0a124cfc69a"},{"categorypicUrl":"http://7xloyz.com2.z0.glb.qiniucdn.com/globalprice_sort_cigawinefood.png","isLowPrice":0,"categoryName":"烟酒食品","categoryId":"2f5935bf37b40b71ef1a5e6241085614"}]
     * script : false
     */

    private Object id;
    private boolean success;
    private Object reCode;
    private Object message;
    private boolean script;
    /**
     * categorypicUrl : http://7xloyz.com2.z0.glb.qiniucdn.com/globalprice_sort_beauty.png
     * isLowPrice : 1
     * categoryName : 个护美妆
     * categoryId : 3e6438d6048199663d841e88c084175c
     */

    private List<ObjBean> obj;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getReCode() {
        return reCode;
    }

    public void setReCode(Object reCode) {
        this.reCode = reCode;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public boolean isScript() {
        return script;
    }

    public void setScript(boolean script) {
        this.script = script;
    }

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        private String categorypicUrl;
        private int isLowPrice;
        private String categoryName;
        private String categoryId;

        public String getCategorypicUrl() {
            return categorypicUrl;
        }

        public void setCategorypicUrl(String categorypicUrl) {
            this.categorypicUrl = categorypicUrl;
        }

        public int getIsLowPrice() {
            return isLowPrice;
        }

        public void setIsLowPrice(int isLowPrice) {
            this.isLowPrice = isLowPrice;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }
    }
}
