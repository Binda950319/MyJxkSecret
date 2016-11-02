package com.wbh.myjxksecret.javabean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/29.
 */
public class ShowUpdataCouBean {

    /**
     * id : null
     * success : true
     * reCode : null
     * message : null
     * obj : {"countryId":"Japan","countryName":"日本","mallName":"激安の殿堂","couponCode":"JPN2016020004","type":"现金券","typeValue":"500日元","condition":"满减","conditionValue":"购满1万日元（不含税）以上，可享500日元折扣。","startTime":"2016-05-01 13:37:34","endTime":"2017-05-31 13:37:43","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FsLK0EMuk5mcltBG0IIDTw8Hec_n","webLink":"","useScene":"持护照前往，在唐吉訶德任意店内购满1万日元（不含税）以上，可享500日元折扣。","useWay":"结算时出示护照和优惠券。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FqUQujz1dDIRQVPoWBYMY0LlgiPH","advertisementOrder":1,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052aa661b0152aacf48e80135"}
     * script : false
     */

    private Object id;
    private boolean success;
    private Object reCode;
    private Object message;
    /**
     * countryId : Japan
     * countryName : 日本
     * mallName : 激安の殿堂
     * couponCode : JPN2016020004
     * type : 现金券
     * typeValue : 500日元
     * condition : 满减
     * conditionValue : 购满1万日元（不含税）以上，可享500日元折扣。
     * startTime : 2016-05-01 13:37:34
     * endTime : 2017-05-31 13:37:43
     * trialObject : 全场通用
     * trialObjectValue : 全场通用
     * usageMode : 仅线下
     * status : 1
     * couponPicUrl : http://7xnfai.com1.z0.glb.clouddn.com/FsLK0EMuk5mcltBG0IIDTw8Hec_n
     * webLink :
     * useScene : 持护照前往，在唐吉訶德任意店内购满1万日元（不含税）以上，可享500日元折扣。
     * useWay : 结算时出示护照和优惠券。
     * isAdvertisement : 1
     * advertisementPicUrl : http://7xnfai.com1.z0.glb.clouddn.com/FqUQujz1dDIRQVPoWBYMY0LlgiPH
     * advertisementOrder : 1
     * haveReceived : false
     * receiveCodeList : []
     * couponSource : 0
     * couponName : null
     * isPrivate : 0
     * couponNamePic :
     * thirdCouponCode : null
     * thirdCouponCodeList : []
     * isGroup : 0
     * remark : null
     * couponId : 8aae246052aa661b0152aacf48e80135
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
        private String countryId;
        private String countryName;
        private String mallName;
        private String couponCode;
        private String type;
        private String typeValue;
        private String condition;
        private String conditionValue;
        private String startTime;
        private String endTime;
        private String trialObject;
        private String trialObjectValue;
        private String usageMode;
        private int status;
        private String couponPicUrl;
        private String webLink;
        private String useScene;
        private String useWay;
        private String isAdvertisement;
        private String advertisementPicUrl;
        private int advertisementOrder;
        private boolean haveReceived;
        private int couponSource;
        private Object couponName;
        private int isPrivate;
        private String couponNamePic;
        private Object thirdCouponCode;
        private int isGroup;
        private Object remark;
        private String couponId;
        private List<?> receiveCodeList;
        private List<?> thirdCouponCodeList;

        public String getCountryId() {
            return countryId;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getMallName() {
            return mallName;
        }

        public void setMallName(String mallName) {
            this.mallName = mallName;
        }

        public String getCouponCode() {
            return couponCode;
        }

        public void setCouponCode(String couponCode) {
            this.couponCode = couponCode;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTypeValue() {
            return typeValue;
        }

        public void setTypeValue(String typeValue) {
            this.typeValue = typeValue;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getConditionValue() {
            return conditionValue;
        }

        public void setConditionValue(String conditionValue) {
            this.conditionValue = conditionValue;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getTrialObject() {
            return trialObject;
        }

        public void setTrialObject(String trialObject) {
            this.trialObject = trialObject;
        }

        public String getTrialObjectValue() {
            return trialObjectValue;
        }

        public void setTrialObjectValue(String trialObjectValue) {
            this.trialObjectValue = trialObjectValue;
        }

        public String getUsageMode() {
            return usageMode;
        }

        public void setUsageMode(String usageMode) {
            this.usageMode = usageMode;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCouponPicUrl() {
            return couponPicUrl;
        }

        public void setCouponPicUrl(String couponPicUrl) {
            this.couponPicUrl = couponPicUrl;
        }

        public String getWebLink() {
            return webLink;
        }

        public void setWebLink(String webLink) {
            this.webLink = webLink;
        }

        public String getUseScene() {
            return useScene;
        }

        public void setUseScene(String useScene) {
            this.useScene = useScene;
        }

        public String getUseWay() {
            return useWay;
        }

        public void setUseWay(String useWay) {
            this.useWay = useWay;
        }

        public String getIsAdvertisement() {
            return isAdvertisement;
        }

        public void setIsAdvertisement(String isAdvertisement) {
            this.isAdvertisement = isAdvertisement;
        }

        public String getAdvertisementPicUrl() {
            return advertisementPicUrl;
        }

        public void setAdvertisementPicUrl(String advertisementPicUrl) {
            this.advertisementPicUrl = advertisementPicUrl;
        }

        public int getAdvertisementOrder() {
            return advertisementOrder;
        }

        public void setAdvertisementOrder(int advertisementOrder) {
            this.advertisementOrder = advertisementOrder;
        }

        public boolean isHaveReceived() {
            return haveReceived;
        }

        public void setHaveReceived(boolean haveReceived) {
            this.haveReceived = haveReceived;
        }

        public int getCouponSource() {
            return couponSource;
        }

        public void setCouponSource(int couponSource) {
            this.couponSource = couponSource;
        }

        public Object getCouponName() {
            return couponName;
        }

        public void setCouponName(Object couponName) {
            this.couponName = couponName;
        }

        public int getIsPrivate() {
            return isPrivate;
        }

        public void setIsPrivate(int isPrivate) {
            this.isPrivate = isPrivate;
        }

        public String getCouponNamePic() {
            return couponNamePic;
        }

        public void setCouponNamePic(String couponNamePic) {
            this.couponNamePic = couponNamePic;
        }

        public Object getThirdCouponCode() {
            return thirdCouponCode;
        }

        public void setThirdCouponCode(Object thirdCouponCode) {
            this.thirdCouponCode = thirdCouponCode;
        }

        public int getIsGroup() {
            return isGroup;
        }

        public void setIsGroup(int isGroup) {
            this.isGroup = isGroup;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public String getCouponId() {
            return couponId;
        }

        public void setCouponId(String couponId) {
            this.couponId = couponId;
        }

        public List<?> getReceiveCodeList() {
            return receiveCodeList;
        }

        public void setReceiveCodeList(List<?> receiveCodeList) {
            this.receiveCodeList = receiveCodeList;
        }

        public List<?> getThirdCouponCodeList() {
            return thirdCouponCodeList;
        }

        public void setThirdCouponCodeList(List<?> thirdCouponCodeList) {
            this.thirdCouponCodeList = thirdCouponCodeList;
        }
    }
}
