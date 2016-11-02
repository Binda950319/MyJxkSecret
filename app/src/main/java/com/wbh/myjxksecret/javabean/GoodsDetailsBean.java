package com.wbh.myjxksecret.javabean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/29.
 */
public class GoodsDetailsBean {

    /**
     * id : null
     * success : true
     * reCode : null
     * message : null
     * obj : {"goods":{"name":" Trockenwürzmischung \"Spaghetti al Aglio Peperocini\", 130 g","attentionCount":0,"brandId":"karstadt@Essig, Öl & Co.","sellPrice":37.55474,"originalPrice":4.99,"inLandPrice":0,"goodsPicture":"http://demandware.edgesuite.net/sits_pod24/dw/image/v2/karstadt/derivates/1/001/661/449/SProdukt_03_103029320.jpg?sw=1200&sh=1200&sm=fit&","picList":["http://demandware.edgesuite.net/sits_pod24/dw/image/v2/karstadt/derivates/1/001/661/449/SProdukt_03_103029320.jpg?sw=1200&sh=1200&sm=fit&"],"priceList":[{"priceTypeName":"店面价","inLandPrice":37.55474,"originalPrice":4.99,"currencyType":"欧元"}],"goodsDesc":"<img src=\"http://demandware.edgesuite.net/sits_pod24/dw/image/v2/karstadt/derivates/1/001/661/449/SProdukt_03_103029320.jpg?sw=1200&sh=1200&sm=fit\" style=\"height:100%;width:100%;\"/>","country":"德国","mallId":"karstadt","mallName":"卡尔施泰特","isFavorite":0,"commentCount":0,"interimProp":[],"deputyGoods":[],"goBuyUrl":"http://www.karstadt.de/Essig-Oel-Co-Trockenwuerzmischung-Spaghetti-al-Aglio-Peperocini-130-g/31211085.html?pid=127","goodsId":"8aae2462523ec92701526715b26d2ac7","currencyType":"欧元","goodsStatus":999},"goodsComment":[],"couponCount":0,"couponList":[]}
     * script : false
     */

    private Object id;
    private boolean success;
    private Object reCode;
    private Object message;
    /**
     * goods : {"name":" Trockenwürzmischung \"Spaghetti al Aglio Peperocini\", 130 g","attentionCount":0,"brandId":"karstadt@Essig, Öl & Co.","sellPrice":37.55474,"originalPrice":4.99,"inLandPrice":0,"goodsPicture":"http://demandware.edgesuite.net/sits_pod24/dw/image/v2/karstadt/derivates/1/001/661/449/SProdukt_03_103029320.jpg?sw=1200&sh=1200&sm=fit&","picList":["http://demandware.edgesuite.net/sits_pod24/dw/image/v2/karstadt/derivates/1/001/661/449/SProdukt_03_103029320.jpg?sw=1200&sh=1200&sm=fit&"],"priceList":[{"priceTypeName":"店面价","inLandPrice":37.55474,"originalPrice":4.99,"currencyType":"欧元"}],"goodsDesc":"<img src=\"http://demandware.edgesuite.net/sits_pod24/dw/image/v2/karstadt/derivates/1/001/661/449/SProdukt_03_103029320.jpg?sw=1200&sh=1200&sm=fit\" style=\"height:100%;width:100%;\"/>","country":"德国","mallId":"karstadt","mallName":"卡尔施泰特","isFavorite":0,"commentCount":0,"interimProp":[],"deputyGoods":[],"goBuyUrl":"http://www.karstadt.de/Essig-Oel-Co-Trockenwuerzmischung-Spaghetti-al-Aglio-Peperocini-130-g/31211085.html?pid=127","goodsId":"8aae2462523ec92701526715b26d2ac7","currencyType":"欧元","goodsStatus":999}
     * goodsComment : []
     * couponCount : 0
     * couponList : []
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
        /**
         * name :  Trockenwürzmischung "Spaghetti al Aglio Peperocini", 130 g
         * attentionCount : 0
         * brandId : karstadt@Essig, Öl & Co.
         * sellPrice : 37.55474
         * originalPrice : 4.99
         * inLandPrice : 0.0
         * goodsPicture : http://demandware.edgesuite.net/sits_pod24/dw/image/v2/karstadt/derivates/1/001/661/449/SProdukt_03_103029320.jpg?sw=1200&sh=1200&sm=fit&
         * picList : ["http://demandware.edgesuite.net/sits_pod24/dw/image/v2/karstadt/derivates/1/001/661/449/SProdukt_03_103029320.jpg?sw=1200&sh=1200&sm=fit&"]
         * priceList : [{"priceTypeName":"店面价","inLandPrice":37.55474,"originalPrice":4.99,"currencyType":"欧元"}]
         * goodsDesc : <img src="http://demandware.edgesuite.net/sits_pod24/dw/image/v2/karstadt/derivates/1/001/661/449/SProdukt_03_103029320.jpg?sw=1200&sh=1200&sm=fit" style="height:100%;width:100%;"/>
         * country : 德国
         * mallId : karstadt
         * mallName : 卡尔施泰特
         * isFavorite : 0
         * commentCount : 0
         * interimProp : []
         * deputyGoods : []
         * goBuyUrl : http://www.karstadt.de/Essig-Oel-Co-Trockenwuerzmischung-Spaghetti-al-Aglio-Peperocini-130-g/31211085.html?pid=127
         * goodsId : 8aae2462523ec92701526715b26d2ac7
         * currencyType : 欧元
         * goodsStatus : 999
         */

        private GoodsBean goods;
        private int couponCount;
        private List<?> goodsComment;
        private List<?> couponList;

        public GoodsBean getGoods() {
            return goods;
        }

        public void setGoods(GoodsBean goods) {
            this.goods = goods;
        }

        public int getCouponCount() {
            return couponCount;
        }

        public void setCouponCount(int couponCount) {
            this.couponCount = couponCount;
        }

        public List<?> getGoodsComment() {
            return goodsComment;
        }

        public void setGoodsComment(List<?> goodsComment) {
            this.goodsComment = goodsComment;
        }

        public List<?> getCouponList() {
            return couponList;
        }

        public void setCouponList(List<?> couponList) {
            this.couponList = couponList;
        }

        public static class GoodsBean {
            private String name;
            private int attentionCount;
            private String brandId;
            private double sellPrice;
            private double originalPrice;
            private double inLandPrice;
            private String goodsPicture;
            private String goodsDesc;
            private String country;
            private String mallId;
            private String mallName;
            private int isFavorite;
            private int commentCount;
            private String goBuyUrl;
            private String goodsId;
            private String currencyType;
            private int goodsStatus;
            private List<String> picList;
            /**
             * priceTypeName : 店面价
             * inLandPrice : 37.55474
             * originalPrice : 4.99
             * currencyType : 欧元
             */

            private List<PriceListBean> priceList;
            private List<?> interimProp;
            private List<?> deputyGoods;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAttentionCount() {
                return attentionCount;
            }

            public void setAttentionCount(int attentionCount) {
                this.attentionCount = attentionCount;
            }

            public String getBrandId() {
                return brandId;
            }

            public void setBrandId(String brandId) {
                this.brandId = brandId;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public double getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(double originalPrice) {
                this.originalPrice = originalPrice;
            }

            public double getInLandPrice() {
                return inLandPrice;
            }

            public void setInLandPrice(double inLandPrice) {
                this.inLandPrice = inLandPrice;
            }

            public String getGoodsPicture() {
                return goodsPicture;
            }

            public void setGoodsPicture(String goodsPicture) {
                this.goodsPicture = goodsPicture;
            }

            public String getGoodsDesc() {
                return goodsDesc;
            }

            public void setGoodsDesc(String goodsDesc) {
                this.goodsDesc = goodsDesc;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getMallId() {
                return mallId;
            }

            public void setMallId(String mallId) {
                this.mallId = mallId;
            }

            public String getMallName() {
                return mallName;
            }

            public void setMallName(String mallName) {
                this.mallName = mallName;
            }

            public int getIsFavorite() {
                return isFavorite;
            }

            public void setIsFavorite(int isFavorite) {
                this.isFavorite = isFavorite;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public String getGoBuyUrl() {
                return goBuyUrl;
            }

            public void setGoBuyUrl(String goBuyUrl) {
                this.goBuyUrl = goBuyUrl;
            }

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }

            public String getCurrencyType() {
                return currencyType;
            }

            public void setCurrencyType(String currencyType) {
                this.currencyType = currencyType;
            }

            public int getGoodsStatus() {
                return goodsStatus;
            }

            public void setGoodsStatus(int goodsStatus) {
                this.goodsStatus = goodsStatus;
            }

            public List<String> getPicList() {
                return picList;
            }

            public void setPicList(List<String> picList) {
                this.picList = picList;
            }

            public List<PriceListBean> getPriceList() {
                return priceList;
            }

            public void setPriceList(List<PriceListBean> priceList) {
                this.priceList = priceList;
            }

            public List<?> getInterimProp() {
                return interimProp;
            }

            public void setInterimProp(List<?> interimProp) {
                this.interimProp = interimProp;
            }

            public List<?> getDeputyGoods() {
                return deputyGoods;
            }

            public void setDeputyGoods(List<?> deputyGoods) {
                this.deputyGoods = deputyGoods;
            }

            public static class PriceListBean {
                private String priceTypeName;
                private double inLandPrice;
                private double originalPrice;
                private String currencyType;

                public String getPriceTypeName() {
                    return priceTypeName;
                }

                public void setPriceTypeName(String priceTypeName) {
                    this.priceTypeName = priceTypeName;
                }

                public double getInLandPrice() {
                    return inLandPrice;
                }

                public void setInLandPrice(double inLandPrice) {
                    this.inLandPrice = inLandPrice;
                }

                public double getOriginalPrice() {
                    return originalPrice;
                }

                public void setOriginalPrice(double originalPrice) {
                    this.originalPrice = originalPrice;
                }

                public String getCurrencyType() {
                    return currencyType;
                }

                public void setCurrencyType(String currencyType) {
                    this.currencyType = currencyType;
                }
            }
        }
    }
}
