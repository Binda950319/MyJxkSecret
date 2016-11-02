package com.wbh.myjxksecret.javabean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class ShopBean {

    /**
     * id : null
     * success : true
     * reCode : null
     * message : null
     * obj : {"data":[{"name":"Shiseido/资生堂 安热沙防晒露 60ML","goodsPicture":"http://7xj1lw.com2.z0.glb.qiniucdn.com/q56lybyls26626q622566626y05e2s26","sellPrice":300,"lowestPrice":139,"attentionCount":264,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"79604bcdf05b45ee88c7165fa83b3b53"},{"name":"Kiehl's/科颜氏 高保湿霜   50ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FmRZ_DsiOLfwing9gdqTYBuLXi4h","sellPrice":300,"lowestPrice":148.77,"attentionCount":155,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"10061643"},{"name":"Lancome/兰蔻 清滢柔肤水400ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FuskMO_osGoWkLMuGOS03Q3Qoq2J","sellPrice":299,"lowestPrice":241.08,"attentionCount":175,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"10023302"},{"name":"YSL/圣罗兰 我的口红  #19 ","goodsPicture":"http://7xj1lw.com2.z0.glb.qiniucdn.com/2bs2ss69569s09es552555l5y9sl952s","sellPrice":230,"lowestPrice":211,"attentionCount":112,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"536372c55ea2453d91725e5a9ed1b76a"},{"name":"Dr.Ci:Labo/城野医生 超效毛孔对策化妆水    100ML","goodsPicture":"http://7xj1lw.com2.z0.glb.qiniucdn.com/50sqsq25q5q62966992q05l5yy6s9965","sellPrice":118,"lowestPrice":66.83,"attentionCount":199,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"10059360"},{"name":"SK-II 护肤精华露 330ml","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FsYs0SznL-kadyWtVqQdfFgIm0z3","sellPrice":1800,"lowestPrice":994.46,"attentionCount":129,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"1e42dba30fe54d139f0705118363cc98"},{"name":"Dior/迪奥 魅惑润唇膏（焕彩）  004 3,5G","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FnBUd17rBMEdz_RVtybNL65HZoFi","sellPrice":300,"lowestPrice":187.7,"attentionCount":141,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"ad5264d332ea4e5089eadcd25235a9cc"},{"name":"Giorgio Armani/阿玛尼 纯净持妆粉底液 05.5 30ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FoIjzeRxry4P3sr4wsVLnMAQtCQv","sellPrice":630,"lowestPrice":323.97,"attentionCount":108,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"5d1a8bbbfe6145ae8f62bbfb9c810260"},{"name":"Giorgio Armani/阿玛尼 臻致丝绒哑光唇釉 #400 Hollywood 6.5ml","goodsPicture":"http://www.sephora.fr/media/catalog_ProductCatalog/m6430805_263408_la.jpg","sellPrice":310,"lowestPrice":189,"attentionCount":156,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"10174095"},{"name":"Estee Lauder/雅诗兰黛 肌透修护眼部精华霜II 15ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FgBfSnpnVk55uxZRzetf59W15FVo","sellPrice":490,"lowestPrice":291.57,"attentionCount":106,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"ae2f4ce2314a44cc9e920781e9a6cb8a"},{"name":"SK-II 护肤精华露 \u201c神仙水\u201d 215ML","goodsPicture":"http://7xj1lw.com2.z0.glb.qiniucdn.com/55q652byes262sl9ysb209ys5099q02s","sellPrice":1270,"lowestPrice":615.62,"attentionCount":89,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"c59d9c082cbc408385f3d0a4ecda8ecd"},{"name":"Givenchy/纪梵希 香榭高定天鹅绒/高级定制唇膏 # 306法式红Carmin Escarpin","goodsPicture":"http://7xj1lw.com2.z0.glb.qiniucdn.com/95qb6yq956sybqlb26s522s65l0505ls","sellPrice":355,"lowestPrice":204.5,"attentionCount":94,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"74bd41d20e3b4c04b7a35ce68f5e1955"},{"name":"YSL/圣罗兰 莹亮纯魅口红  #12 Corail Incandescent 4.5g","goodsPicture":"http://www.sephora.fr/media/catalog_ProductCatalog/m5591246_263956_la.jpg","sellPrice":320,"lowestPrice":202.33,"attentionCount":121,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"70ec28f70f824c86ab22fe8a80dd65cc"},{"name":"YSL/圣罗兰 光舞沁蓝纯色唇釉 #12 6ml","goodsPicture":"http://7xj1lw.com2.z0.glb.qiniucdn.com/s6y2e59yb9qe205bl6qes96e0y0525q2","sellPrice":268,"lowestPrice":185.4,"attentionCount":110,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"c9630dd2241a44ddbe588a95290c8884"},{"name":"Banila co./芭妮兰 致柔卸妆膏100ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/Fn7brc_1zSZ4SDppYRHSf9GsiR5H","sellPrice":198,"lowestPrice":84.38,"attentionCount":125,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"3aab44ab32e845049cfcf4f02f51ea12"},{"name":"Cle de Peau Beaute/肌肤之钥 水磨美容液 170ml","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/Fg750bKdR_mNvQD4wYpA8LRjWRBq","sellPrice":0,"lowestPrice":569.5,"attentionCount":82,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"0a56eacfad9b4c3f806827983db147ee"},{"name":"Lancome/兰蔻 气垫CC霜（兰蔻气垫修颜隔离乳 SPF20 PA++）BO-01 14G","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/Fl3zQ0-X2KN2VaXMcDV8RAhytZ4O","sellPrice":420,"lowestPrice":193.8,"attentionCount":77,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"638144af1126465ebda482fe6e3ec8f7"},{"name":"Estee Lauder/雅诗兰黛 特润修护肌透精华露   100ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FujC2n-eu69yykwvox7yN9BrtlX4","sellPrice":0,"lowestPrice":769.75,"attentionCount":86,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"30102189"},{"name":"Avene/雅漾 舒护活泉喷雾 300ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FmpmnVAQIZVplImG9aXdh3P9ce96","sellPrice":185,"lowestPrice":68.02,"attentionCount":106,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"10082977"},{"name":"La Mer/海蓝之谜 全新修护精萃液   150ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/Fo5y5eZ22_i7QFeqs9escT5v5aAB","sellPrice":1100,"lowestPrice":643,"attentionCount":104,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"10037088"}],"pageNo":1,"dateObj":null,"hasNext":true}
     * script : false
     */

    private Object id;
    private boolean success;
    private Object reCode;
    private Object message;
    /**
     * data : [{"name":"Shiseido/资生堂 安热沙防晒露 60ML","goodsPicture":"http://7xj1lw.com2.z0.glb.qiniucdn.com/q56lybyls26626q622566626y05e2s26","sellPrice":300,"lowestPrice":139,"attentionCount":264,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"79604bcdf05b45ee88c7165fa83b3b53"},{"name":"Kiehl's/科颜氏 高保湿霜   50ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FmRZ_DsiOLfwing9gdqTYBuLXi4h","sellPrice":300,"lowestPrice":148.77,"attentionCount":155,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"10061643"},{"name":"Lancome/兰蔻 清滢柔肤水400ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FuskMO_osGoWkLMuGOS03Q3Qoq2J","sellPrice":299,"lowestPrice":241.08,"attentionCount":175,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"10023302"},{"name":"YSL/圣罗兰 我的口红  #19 ","goodsPicture":"http://7xj1lw.com2.z0.glb.qiniucdn.com/2bs2ss69569s09es552555l5y9sl952s","sellPrice":230,"lowestPrice":211,"attentionCount":112,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"536372c55ea2453d91725e5a9ed1b76a"},{"name":"Dr.Ci:Labo/城野医生 超效毛孔对策化妆水    100ML","goodsPicture":"http://7xj1lw.com2.z0.glb.qiniucdn.com/50sqsq25q5q62966992q05l5yy6s9965","sellPrice":118,"lowestPrice":66.83,"attentionCount":199,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"10059360"},{"name":"SK-II 护肤精华露 330ml","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FsYs0SznL-kadyWtVqQdfFgIm0z3","sellPrice":1800,"lowestPrice":994.46,"attentionCount":129,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"1e42dba30fe54d139f0705118363cc98"},{"name":"Dior/迪奥 魅惑润唇膏（焕彩）  004 3,5G","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FnBUd17rBMEdz_RVtybNL65HZoFi","sellPrice":300,"lowestPrice":187.7,"attentionCount":141,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"ad5264d332ea4e5089eadcd25235a9cc"},{"name":"Giorgio Armani/阿玛尼 纯净持妆粉底液 05.5 30ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FoIjzeRxry4P3sr4wsVLnMAQtCQv","sellPrice":630,"lowestPrice":323.97,"attentionCount":108,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"5d1a8bbbfe6145ae8f62bbfb9c810260"},{"name":"Giorgio Armani/阿玛尼 臻致丝绒哑光唇釉 #400 Hollywood 6.5ml","goodsPicture":"http://www.sephora.fr/media/catalog_ProductCatalog/m6430805_263408_la.jpg","sellPrice":310,"lowestPrice":189,"attentionCount":156,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"10174095"},{"name":"Estee Lauder/雅诗兰黛 肌透修护眼部精华霜II 15ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FgBfSnpnVk55uxZRzetf59W15FVo","sellPrice":490,"lowestPrice":291.57,"attentionCount":106,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"ae2f4ce2314a44cc9e920781e9a6cb8a"},{"name":"SK-II 护肤精华露 \u201c神仙水\u201d 215ML","goodsPicture":"http://7xj1lw.com2.z0.glb.qiniucdn.com/55q652byes262sl9ysb209ys5099q02s","sellPrice":1270,"lowestPrice":615.62,"attentionCount":89,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"c59d9c082cbc408385f3d0a4ecda8ecd"},{"name":"Givenchy/纪梵希 香榭高定天鹅绒/高级定制唇膏 # 306法式红Carmin Escarpin","goodsPicture":"http://7xj1lw.com2.z0.glb.qiniucdn.com/95qb6yq956sybqlb26s522s65l0505ls","sellPrice":355,"lowestPrice":204.5,"attentionCount":94,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"74bd41d20e3b4c04b7a35ce68f5e1955"},{"name":"YSL/圣罗兰 莹亮纯魅口红  #12 Corail Incandescent 4.5g","goodsPicture":"http://www.sephora.fr/media/catalog_ProductCatalog/m5591246_263956_la.jpg","sellPrice":320,"lowestPrice":202.33,"attentionCount":121,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"70ec28f70f824c86ab22fe8a80dd65cc"},{"name":"YSL/圣罗兰 光舞沁蓝纯色唇釉 #12 6ml","goodsPicture":"http://7xj1lw.com2.z0.glb.qiniucdn.com/s6y2e59yb9qe205bl6qes96e0y0525q2","sellPrice":268,"lowestPrice":185.4,"attentionCount":110,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"c9630dd2241a44ddbe588a95290c8884"},{"name":"Banila co./芭妮兰 致柔卸妆膏100ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/Fn7brc_1zSZ4SDppYRHSf9GsiR5H","sellPrice":198,"lowestPrice":84.38,"attentionCount":125,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"3aab44ab32e845049cfcf4f02f51ea12"},{"name":"Cle de Peau Beaute/肌肤之钥 水磨美容液 170ml","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/Fg750bKdR_mNvQD4wYpA8LRjWRBq","sellPrice":0,"lowestPrice":569.5,"attentionCount":82,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"0a56eacfad9b4c3f806827983db147ee"},{"name":"Lancome/兰蔻 气垫CC霜（兰蔻气垫修颜隔离乳 SPF20 PA++）BO-01 14G","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/Fl3zQ0-X2KN2VaXMcDV8RAhytZ4O","sellPrice":420,"lowestPrice":193.8,"attentionCount":77,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"638144af1126465ebda482fe6e3ec8f7"},{"name":"Estee Lauder/雅诗兰黛 特润修护肌透精华露   100ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FujC2n-eu69yykwvox7yN9BrtlX4","sellPrice":0,"lowestPrice":769.75,"attentionCount":86,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"30102189"},{"name":"Avene/雅漾 舒护活泉喷雾 300ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/FmpmnVAQIZVplImG9aXdh3P9ce96","sellPrice":185,"lowestPrice":68.02,"attentionCount":106,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"10082977"},{"name":"La Mer/海蓝之谜 全新修护精萃液   150ML","goodsPicture":"http://7xj1lw.com1.z0.glb.clouddn.com/Fo5y5eZ22_i7QFeqs9escT5v5aAB","sellPrice":1100,"lowestPrice":643,"attentionCount":104,"goodsStatus":999,"isLowPrice":0,"lowestCountry":null,"goodsId":"10037088"}]
     * pageNo : 1
     * dateObj : null
     * hasNext : true
     */

    private ObjBean obj;
    private boolean script;

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

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public boolean isScript() {
        return script;
    }

    public void setScript(boolean script) {
        this.script = script;
    }

    public static class ObjBean {
        private int pageNo;
        private Object dateObj;
        private boolean hasNext;
        /**
         * name : Shiseido/资生堂 安热沙防晒露 60ML
         * goodsPicture : http://7xj1lw.com2.z0.glb.qiniucdn.com/q56lybyls26626q622566626y05e2s26
         * sellPrice : 300.0
         * lowestPrice : 139.0
         * attentionCount : 264
         * goodsStatus : 999
         * isLowPrice : 0
         * lowestCountry : null
         * goodsId : 79604bcdf05b45ee88c7165fa83b3b53
         */

        private List<DataBean> data;

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public Object getDateObj() {
            return dateObj;
        }

        public void setDateObj(Object dateObj) {
            this.dateObj = dateObj;
        }

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String name;
            private String goodsPicture;
            private double sellPrice;
            private double lowestPrice;
            private int attentionCount;
            private int goodsStatus;
            private int isLowPrice;
            private Object lowestCountry;
            private String goodsId;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getGoodsPicture() {
                return goodsPicture;
            }

            public void setGoodsPicture(String goodsPicture) {
                this.goodsPicture = goodsPicture;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public double getLowestPrice() {
                return lowestPrice;
            }

            public void setLowestPrice(double lowestPrice) {
                this.lowestPrice = lowestPrice;
            }

            public int getAttentionCount() {
                return attentionCount;
            }

            public void setAttentionCount(int attentionCount) {
                this.attentionCount = attentionCount;
            }

            public int getGoodsStatus() {
                return goodsStatus;
            }

            public void setGoodsStatus(int goodsStatus) {
                this.goodsStatus = goodsStatus;
            }

            public int getIsLowPrice() {
                return isLowPrice;
            }

            public void setIsLowPrice(int isLowPrice) {
                this.isLowPrice = isLowPrice;
            }

            public Object getLowestCountry() {
                return lowestCountry;
            }

            public void setLowestCountry(Object lowestCountry) {
                this.lowestCountry = lowestCountry;
            }

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }
        }
    }
}
