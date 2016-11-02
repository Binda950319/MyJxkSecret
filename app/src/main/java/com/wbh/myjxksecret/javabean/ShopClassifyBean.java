package com.wbh.myjxksecret.javabean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class ShopClassifyBean {

    /**
     * id : null
     * success : true
     * reCode : null
     * message : null
     * obj : [{"categorypicUrl":"","isLowPrice":1,"categoryName":"其他","categoryId":"3e6438d6048199663d841e88c084175c-0d98c74797e49d00bcc4c17c9d557a2b"},{"categorypicUrl":"","isLowPrice":1,"categoryName":"香氛","categoryId":"3e6438d6048199663d841e88c084175c-2f370d39fb19eeb72deca0acb2aca91a"},{"categorypicUrl":"","isLowPrice":1,"categoryName":"彩妆","categoryId":"3e6438d6048199663d841e88c084175c-473ccbd6a6bc398e786ecc58c9535cc0"},{"categorypicUrl":"","isLowPrice":1,"categoryName":"基础护肤","categoryId":"3e6438d6048199663d841e88c084175c-4ed3455148de31bb569416b02c349da2"},{"categorypicUrl":"","isLowPrice":1,"categoryName":"洗护用品","categoryId":"3e6438d6048199663d841e88c084175c-6c4892362af0b1c01b04e66add59be88"},{"categorypicUrl":"","isLowPrice":1,"categoryName":"身体护理","categoryId":"3e6438d6048199663d841e88c084175c-a28d0ebea625f94dcc50fa30b1520522"},{"categorypicUrl":"","isLowPrice":1,"categoryName":"男士护理","categoryId":"3e6438d6048199663d841e88c084175c-cebb86cc21f69d53829a61b4ba9295d5"},{"categorypicUrl":"","isLowPrice":1,"categoryName":"礼品套装","categoryId":"3e6438d6048199663d841e88c084175c-d0143ee85ddcc8685dba6d0cd1dc6a4f"}]
     * script : false
     */

    private Object id;
    private boolean success;
    private Object reCode;
    private Object message;
    private boolean script;
    /**
     * categorypicUrl :
     * isLowPrice : 1
     * categoryName : 其他
     * categoryId : 3e6438d6048199663d841e88c084175c-0d98c74797e49d00bcc4c17c9d557a2b
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
