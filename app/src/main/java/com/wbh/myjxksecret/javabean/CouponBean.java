package com.wbh.myjxksecret.javabean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
public class CouponBean implements Parcelable {

    /**
     * id : null
     * success : true
     * reCode : null
     * message : null
     * obj : {"data":[{"countryId":"Japan","countryName":"日本","mallName":"东急百货","couponCode":"JPN2016090145","type":"折扣券","typeValue":"最高87折优惠","condition":"立减","conditionValue":"5%优惠+8%免税","startTime":"2016-09-12 09:45:12","endTime":"2017-03-31 09:45:13","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fvhfoigjt_yU_TH6sP5ZGdo5Xsxn","webLink":"","useScene":"适用于以下店铺：\r\n1、东京银座地铁站东急广场银座3-5F\r\n2、涩谷·本店\r\n3、涩谷 Hikarie ShinQs 店\r\n4、札幌店\r\n5、新千岁机场店 \r\n6、吉祥寺店\r\n7、涩谷站·东横店","useWay":"1、消费满3240日元（含税）以上可享用\r\n2、不可和其他优惠同时使用\r\n3、部分品牌不参与活动\r\n4、仅限外国客人使用","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fs6d9PpR31ItinO__IQNa9tUhsqk","advertisementOrder":1,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"ff80808156bb1a3e01571c174cba17bd"},{"countryId":"Japan","countryName":"日本","mallName":"松本清","couponCode":"JPN2016010001","type":"折扣券","typeValue":"5%off","condition":"其他","conditionValue":"最高优惠5%","startTime":"2016-09-01 13:58:41","endTime":"2017-03-31 23:59:59","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Flma2AXFaKJOH-jgC9ZWoFufG9k-","webLink":"","useScene":"消费1万-3万日元，享受97折；消费3万日元以上，享受95折。\r\n不得同时参与其他优惠活动","useWay":"在收银台结算时出示此券","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fr_jo7QpE1CEvT9r6ELYdcTwPVhs","advertisementOrder":2,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052447653015244d3b59d0068"},{"countryId":"Japan","countryName":"日本","mallName":"Marumie Plaza","couponCode":"JPN2016080129","type":"折扣券","typeValue":"最高13%优惠","condition":"立减","conditionValue":"5%折扣+8%退税","startTime":"2016-08-22 10:54:54","endTime":"2016-12-31 10:54:54","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"线上可用","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fn-ZQfVKD6aWPPac0dAUQnyipV1P","webLink":"","useScene":"1. 可在官网预定，机场取货\r\n2. 可直邮回中国","useWay":"","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FvQvcJGCIPgc_PZCrbwkCNe917iE","advertisementOrder":3,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"ff80808156b007d40156b02e620c010c"},{"countryId":"Japan","countryName":"日本","mallName":"京王百货店新宿店","couponCode":"JPN2016020012","type":"折扣券","typeValue":"最高87折优惠","condition":"立减","conditionValue":"5%优惠+7%退税","startTime":"2016-03-01 14:31:31","endTime":"2017-05-31 23:59:50","trialObject":"全场通用","trialObjectValue":"京王百货新宿店","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FsvjZGa9GJujjtGfmoV6q9QnSowA","webLink":"","useScene":"食品、特价品等部分商品除外\r\n","useWay":"购物前请到2楼外国顾客服务台办理手续","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FhpJCF4sNBaOjrCXOHzTnkbjXrxB","advertisementOrder":2,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052e894f90152e8cc8b5c1628"},{"countryId":"Japan","countryName":"日本","mallName":"三浦珠宝","couponCode":"JPN2016060077","type":"折扣券","typeValue":"7%优惠+8%退税","condition":"立减","conditionValue":"7%优惠+8%退税","startTime":"2016-06-01 10:48:31","endTime":"2017-08-31 23:48:43","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FgsMfJ_RZMSZafQIWIotGRQXunAK","webLink":"","useScene":"结账时出示优惠券","useWay":"部分商品不参与折扣","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FgouzWijIwQJqzjTYWR6d-6iVJDo","advertisementOrder":2,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"ff8080815543b7040155571f8acd3656"},{"countryId":"Japan","countryName":"日本","mallName":"近铁百货","couponCode":"JPN2016060073","type":"折扣券","typeValue":"5%Off","condition":"立减","conditionValue":"5%Off","startTime":"2016-06-01 11:07:52","endTime":"2016-12-31 23:59:55","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FmFxtuPv_6k2pNBLjMTG4BeiI3PL","webLink":"","useScene":"购物满2000日元（不含税）以上时使用\r\n不可同时使用其他优惠券\r\n食品、特价品、指定店等不参与折扣","useWay":"阿倍野HARUKAA近铁本店，上本町店，奈良店，和歌山店，四日市店，草津店，橿原店\r\n","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fm-WS3BpQM-TO_WI4WZKQceUjm9e","advertisementOrder":1,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246054ec241b015509f813e57394"},{"countryId":"Japan","countryName":"日本","mallName":"激安の殿堂","couponCode":"JPN2016020004","type":"现金券","typeValue":"500日元","condition":"满减","conditionValue":"购满1万日元（不含税）以上，可享500日元折扣。","startTime":"2016-05-01 13:37:34","endTime":"2017-05-31 13:37:43","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FsLK0EMuk5mcltBG0IIDTw8Hec_n","webLink":"","useScene":"持护照前往，在唐吉訶德任意店内购满1万日元（不含税）以上，可享500日元折扣。","useWay":"结算时出示护照和优惠券。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FqUQujz1dDIRQVPoWBYMY0LlgiPH","advertisementOrder":1,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052aa661b0152aacf48e80135"},{"countryId":"Japan","countryName":"日本","mallName":"山田电机","couponCode":"JPN2016040066","type":"折扣券","typeValue":"最高85折优惠","condition":"其他","conditionValue":"8%免税+7%优惠","startTime":"2016-04-01 16:04:12","endTime":"2016-12-31 16:04:23","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FuRk1Q1H-6vl80KNL38IxT9kP4AM","webLink":"","useScene":"","useWay":"","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fooqo5OXSWM3an22sGWxVEDE-0sB","advertisementOrder":4,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae2460544b293001544c74491c00c0"},{"countryId":"Japan","countryName":"日本","mallName":"成田机场JapanDutyFree","couponCode":"JPN2016040065","type":"折扣券","typeValue":"九五折优惠","condition":"其他","conditionValue":"5%Off","startTime":"2016-04-01 15:53:37","endTime":"2016-12-31 15:53:43","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FtrbF3kcMP5fI912NgMvYc-AsXWu","webLink":"","useScene":"此券仅限在成天国际机场Japan Duty Free使用。\r\n名牌店不可以使用。\r\n一部分上没有折扣。香奈儿、资生堂、SK-II、表、电器商品、食品、其他及烟酒以外的国外商品。","useWay":"在结账时请向店员出示此券。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FuMTM87Smsqr63IGzS8A_mfQ-_GS","advertisementOrder":5,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae2460544b293001544c6ecdba009c"},{"countryId":"Japan","countryName":"日本","mallName":"福冈天神免税店","couponCode":"JPN2016040063","type":"折扣券","typeValue":"97折优惠","condition":"其他","conditionValue":"97折优惠","startTime":"2016-01-01 15:32:59","endTime":"2016-12-31 15:33:02","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fs4Ms8qjGpU0EbVIGqeTrX3uD30W","webLink":"","useScene":"部分商品除外，请以店内详情为准。","useWay":"结账时出示优惠券。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FpKDegZS_6iHukyH69ytOD-9oanN","advertisementOrder":6,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae2460544b293001544c5967f20018"},{"countryId":"Japan","countryName":"日本","mallName":"Laox","couponCode":"JPN2016040062","type":"折扣券","typeValue":"最高87折优惠","condition":"其他","conditionValue":"8%免税+5%优惠","startTime":"2016-04-25 15:05:56","endTime":"2016-12-31 23:59:59","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FhF6ORG7YEyXc7fAiCYpVWMPJWWB","webLink":"","useScene":"本券适用于LAOX所有门店（新宿手表专卖店WATCH除外）。\r\n本券不能与其他优惠券同时使用。\r\n游戏机、苹果手机及相关产品，名牌箱包，药品和部分指定商品除外。","useWay":"请在付款时出示本优惠券。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FnyW3mTRw5rqPfK8O51Ifed7nQCo","advertisementOrder":6,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae2460544b293001544c4c217d7fe6"},{"countryId":"Japan","countryName":"日本","mallName":"SONOKO莊能子日本银座总店","couponCode":"JPN2016040056","type":"折扣券","typeValue":"5%off","condition":"立减","conditionValue":"5%off+8%免税","startTime":"2016-04-01 11:58:10","endTime":"2017-01-31 11:58:21","trialObject":"全场通用","trialObjectValue":"全场通用（日本银座总店）","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FuCAAuPzlWUM0UvYg1zsu0wB1y6L","webLink":"","useScene":"SONOKO品牌所有商品（非SONOKO商品除外）。","useWay":"请到2F收银台付款前出示本图。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FvpYlz9aeSC8d9nsbORog_TguL6L","advertisementOrder":4,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246053cb7f9b0154037b46365872"},{"countryId":"Japan","countryName":"日本","mallName":"SAKUGA商会","couponCode":"JPN2016040055","type":"折扣券","typeValue":"2%off","condition":"立减","conditionValue":"批发价+2%优惠+8%免税","startTime":"2016-04-01 11:51:25","endTime":"2016-11-30 11:51:31","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Flzubt7mEfTD_4eYfzBYUn_Tvwys","webLink":"","useScene":"店内所有商品。","useWay":"进店请出示本图（电子版、打印版均可）。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FhJvT8ay2UBMt7dtvyW0l6n-lG89","advertisementOrder":3,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246053cb7f9b01540376338f5863"},{"countryId":"Japan","countryName":"日本","mallName":"KIX关西机场","couponCode":"JPN2016010007","type":"折扣券","typeValue":"5%off","condition":"立减","conditionValue":"5%off","startTime":"2016-04-01 17:37:58","endTime":"2017-03-31 17:38:00","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fu4-X7PN5v8NnDDNHxb-GRF9_AVw","webLink":"","useScene":"食品等一部分商品不在折扣范围内。","useWay":"请打印并出示此券以享优惠。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FsRWxZW1haBJnZDPuFT5pa0BiyzB","advertisementOrder":6,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae24605276d12001527836927b0169"},{"countryId":"Japan","countryName":"日本","mallName":"北海道永旺累加立减优惠券","couponCode":"JPN2016030047","type":"折扣券","typeValue":"400日元减免","condition":"满减","conditionValue":"购物满2000日元或以上可立即获减200日元，购物满4000日元或以上可立即获减400日元，以此类推。","startTime":"2016-03-10 16:02:10","endTime":"2016-12-31 16:02:26","trialObject":"全场通用","trialObjectValue":"北海道永旺各大分店，详情见\u201c优惠券使用范围\u201d。","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fm1LAL90KNWuCmiy-HTM9U17FblU","webLink":"","useScene":"1.日本以外国家或地区发行的JCB信用卡均可参与此活动。\r\n2.本次活动仅限选择JCB网络通道支付时才可参与。\r\n3.本优惠不可与店内其他优惠折扣合并使用。\r\n4.每人每卡可多次参与。\r\n5.本活动不适用于部分商品及专卖店。\r\n6.JCB国际信用卡公司在法律允许的条件下对本次活动持有最终解释权。","useWay":"1.在购物前出示电子版或者打印版优惠券。\r\n2.使用JCB信用卡，并通过JCB结算通道支付。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FpEiRc-6HgUft1uo8ZlVPfVgoJ_n","advertisementOrder":6,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae24605363d428015364bb186f606b"},{"countryId":"Japan","countryName":"日本","mallName":"Sofmap","couponCode":"JPN2016020005","type":"折扣券","typeValue":"最高86折优惠","condition":"立减","conditionValue":"8%免税+6%优惠","startTime":"2016-03-01 11:34:47","endTime":"2017-03-31 11:34:54","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FrQNlewP6KFm0KJP5ZPlfjc7SCS1","webLink":"","useScene":"","useWay":"请出示护照","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fh9TpIx0w_i8U81AykHBD4wJQj96","advertisementOrder":3,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052e2e6f60152e303994f0f72"},{"countryId":"Japan","countryName":"日本","mallName":"BIC CAMERA","couponCode":"JPN2016020006","type":"折扣券","typeValue":"最高86折优惠","condition":"立减","conditionValue":"8%免税+6%优惠","startTime":"2016-03-01 00:00:00","endTime":"2017-03-31 23:59:59","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FrQNlewP6KFm0KJP5ZPlfjc7SCS1","webLink":"","useScene":"使用条件：短期再留旅行者（签证6个月以内）\r\n适用范围：符合免税条件的商品。书籍、游戏机、啤酒、易耗品、一部分特价品不可使用。\r\n无折扣商品：劳力士手表、书籍、苹果产品\r\n部分必酷酒类（易拉罐酒类等）必酷药妆店（药品、日用品等）","useWay":"使用时请出示护照。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Flxw8DEWvtp3BKHB5EhJVoyCGBCN","advertisementOrder":2,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052e2e6f60152e30ea1da0fe7"},{"countryId":"Japan","countryName":"日本","mallName":"小岛","couponCode":"JPN2016020007","type":"折扣券","typeValue":"最高86折优惠","condition":"立减","conditionValue":"免税8%+优惠6%","startTime":"2016-03-01 00:00:00","endTime":"2017-03-31 23:59:59","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FrQNlewP6KFm0KJP5ZPlfjc7SCS1","webLink":"","useScene":"使用时请出示护照，扫描条形码打折。","useWay":"使用时请出示护照，扫描条形码打折。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fi-6WdE4sdd82pKLx7tPlebKXZN8","advertisementOrder":6,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052e311030152e31e67a60619"},{"countryId":"Japan","countryName":"日本","mallName":"松屋银座","couponCode":"JPN2016020013","type":"折扣券","typeValue":"最高9折优惠","condition":"立减","conditionValue":"2%优惠+8%免税","startTime":"2016-02-16 14:55:15","endTime":"2016-11-30 23:55:24","trialObject":"全场通用","trialObjectValue":"本馆1-7层，マロニエ通馆1-3层，别馆（一小部分商品除外）","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FtmJ7GkwTpurV8ODA4S5dXDbE6zG","webLink":"","useScene":"本馆1-7层，マロニエ通馆1-3层，别馆（一小部分商品除外）\r\n特价商品以及LV,卡地亚，劳力士，三宅一生等数家品牌除外。\r\n","useWay":"购物前，请持本优惠券到本馆地下一层免税柜台办理手续。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FnZXv8IBrXdCGtllzm_MaXaANh7z","advertisementOrder":2,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052e894f90152e8e3fa6b167f"},{"countryId":"Japan","countryName":"日本","mallName":"AAS免税店","couponCode":"JPN2016020002","type":"折扣券","typeValue":"7% OFF","condition":"立减","conditionValue":"93折优惠","startTime":"2016-02-01 18:35:02","endTime":"2017-06-30 18:35:12","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fp2RpQKXTeMx4bpjd6G4Vq42GiRW","webLink":"","useScene":"部分商品除外","useWay":"结账时请出示优惠券","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FhBhf3_Kscy3xbU8lOhnUk1cufto","advertisementOrder":6,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052a14a860152a1932921015d"}],"pageNo":1,"dateObj":null,"hasNext":true}
     * script : false
     */

    private Object id;
    private boolean success;
    private Object reCode;
    private Object message;
    /**
     * data : [{"countryId":"Japan","countryName":"日本","mallName":"东急百货","couponCode":"JPN2016090145","type":"折扣券","typeValue":"最高87折优惠","condition":"立减","conditionValue":"5%优惠+8%免税","startTime":"2016-09-12 09:45:12","endTime":"2017-03-31 09:45:13","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fvhfoigjt_yU_TH6sP5ZGdo5Xsxn","webLink":"","useScene":"适用于以下店铺：\r\n1、东京银座地铁站东急广场银座3-5F\r\n2、涩谷·本店\r\n3、涩谷 Hikarie ShinQs 店\r\n4、札幌店\r\n5、新千岁机场店 \r\n6、吉祥寺店\r\n7、涩谷站·东横店","useWay":"1、消费满3240日元（含税）以上可享用\r\n2、不可和其他优惠同时使用\r\n3、部分品牌不参与活动\r\n4、仅限外国客人使用","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fs6d9PpR31ItinO__IQNa9tUhsqk","advertisementOrder":1,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"ff80808156bb1a3e01571c174cba17bd"},{"countryId":"Japan","countryName":"日本","mallName":"松本清","couponCode":"JPN2016010001","type":"折扣券","typeValue":"5%off","condition":"其他","conditionValue":"最高优惠5%","startTime":"2016-09-01 13:58:41","endTime":"2017-03-31 23:59:59","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Flma2AXFaKJOH-jgC9ZWoFufG9k-","webLink":"","useScene":"消费1万-3万日元，享受97折；消费3万日元以上，享受95折。\r\n不得同时参与其他优惠活动","useWay":"在收银台结算时出示此券","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fr_jo7QpE1CEvT9r6ELYdcTwPVhs","advertisementOrder":2,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052447653015244d3b59d0068"},{"countryId":"Japan","countryName":"日本","mallName":"Marumie Plaza","couponCode":"JPN2016080129","type":"折扣券","typeValue":"最高13%优惠","condition":"立减","conditionValue":"5%折扣+8%退税","startTime":"2016-08-22 10:54:54","endTime":"2016-12-31 10:54:54","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"线上可用","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fn-ZQfVKD6aWPPac0dAUQnyipV1P","webLink":"","useScene":"1. 可在官网预定，机场取货\r\n2. 可直邮回中国","useWay":"","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FvQvcJGCIPgc_PZCrbwkCNe917iE","advertisementOrder":3,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"ff80808156b007d40156b02e620c010c"},{"countryId":"Japan","countryName":"日本","mallName":"京王百货店新宿店","couponCode":"JPN2016020012","type":"折扣券","typeValue":"最高87折优惠","condition":"立减","conditionValue":"5%优惠+7%退税","startTime":"2016-03-01 14:31:31","endTime":"2017-05-31 23:59:50","trialObject":"全场通用","trialObjectValue":"京王百货新宿店","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FsvjZGa9GJujjtGfmoV6q9QnSowA","webLink":"","useScene":"食品、特价品等部分商品除外\r\n","useWay":"购物前请到2楼外国顾客服务台办理手续","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FhpJCF4sNBaOjrCXOHzTnkbjXrxB","advertisementOrder":2,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052e894f90152e8cc8b5c1628"},{"countryId":"Japan","countryName":"日本","mallName":"三浦珠宝","couponCode":"JPN2016060077","type":"折扣券","typeValue":"7%优惠+8%退税","condition":"立减","conditionValue":"7%优惠+8%退税","startTime":"2016-06-01 10:48:31","endTime":"2017-08-31 23:48:43","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FgsMfJ_RZMSZafQIWIotGRQXunAK","webLink":"","useScene":"结账时出示优惠券","useWay":"部分商品不参与折扣","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FgouzWijIwQJqzjTYWR6d-6iVJDo","advertisementOrder":2,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"ff8080815543b7040155571f8acd3656"},{"countryId":"Japan","countryName":"日本","mallName":"近铁百货","couponCode":"JPN2016060073","type":"折扣券","typeValue":"5%Off","condition":"立减","conditionValue":"5%Off","startTime":"2016-06-01 11:07:52","endTime":"2016-12-31 23:59:55","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FmFxtuPv_6k2pNBLjMTG4BeiI3PL","webLink":"","useScene":"购物满2000日元（不含税）以上时使用\r\n不可同时使用其他优惠券\r\n食品、特价品、指定店等不参与折扣","useWay":"阿倍野HARUKAA近铁本店，上本町店，奈良店，和歌山店，四日市店，草津店，橿原店\r\n","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fm-WS3BpQM-TO_WI4WZKQceUjm9e","advertisementOrder":1,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246054ec241b015509f813e57394"},{"countryId":"Japan","countryName":"日本","mallName":"激安の殿堂","couponCode":"JPN2016020004","type":"现金券","typeValue":"500日元","condition":"满减","conditionValue":"购满1万日元（不含税）以上，可享500日元折扣。","startTime":"2016-05-01 13:37:34","endTime":"2017-05-31 13:37:43","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FsLK0EMuk5mcltBG0IIDTw8Hec_n","webLink":"","useScene":"持护照前往，在唐吉訶德任意店内购满1万日元（不含税）以上，可享500日元折扣。","useWay":"结算时出示护照和优惠券。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FqUQujz1dDIRQVPoWBYMY0LlgiPH","advertisementOrder":1,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052aa661b0152aacf48e80135"},{"countryId":"Japan","countryName":"日本","mallName":"山田电机","couponCode":"JPN2016040066","type":"折扣券","typeValue":"最高85折优惠","condition":"其他","conditionValue":"8%免税+7%优惠","startTime":"2016-04-01 16:04:12","endTime":"2016-12-31 16:04:23","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FuRk1Q1H-6vl80KNL38IxT9kP4AM","webLink":"","useScene":"","useWay":"","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fooqo5OXSWM3an22sGWxVEDE-0sB","advertisementOrder":4,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae2460544b293001544c74491c00c0"},{"countryId":"Japan","countryName":"日本","mallName":"成田机场JapanDutyFree","couponCode":"JPN2016040065","type":"折扣券","typeValue":"九五折优惠","condition":"其他","conditionValue":"5%Off","startTime":"2016-04-01 15:53:37","endTime":"2016-12-31 15:53:43","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FtrbF3kcMP5fI912NgMvYc-AsXWu","webLink":"","useScene":"此券仅限在成天国际机场Japan Duty Free使用。\r\n名牌店不可以使用。\r\n一部分上没有折扣。香奈儿、资生堂、SK-II、表、电器商品、食品、其他及烟酒以外的国外商品。","useWay":"在结账时请向店员出示此券。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FuMTM87Smsqr63IGzS8A_mfQ-_GS","advertisementOrder":5,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae2460544b293001544c6ecdba009c"},{"countryId":"Japan","countryName":"日本","mallName":"福冈天神免税店","couponCode":"JPN2016040063","type":"折扣券","typeValue":"97折优惠","condition":"其他","conditionValue":"97折优惠","startTime":"2016-01-01 15:32:59","endTime":"2016-12-31 15:33:02","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fs4Ms8qjGpU0EbVIGqeTrX3uD30W","webLink":"","useScene":"部分商品除外，请以店内详情为准。","useWay":"结账时出示优惠券。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FpKDegZS_6iHukyH69ytOD-9oanN","advertisementOrder":6,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae2460544b293001544c5967f20018"},{"countryId":"Japan","countryName":"日本","mallName":"Laox","couponCode":"JPN2016040062","type":"折扣券","typeValue":"最高87折优惠","condition":"其他","conditionValue":"8%免税+5%优惠","startTime":"2016-04-25 15:05:56","endTime":"2016-12-31 23:59:59","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FhF6ORG7YEyXc7fAiCYpVWMPJWWB","webLink":"","useScene":"本券适用于LAOX所有门店（新宿手表专卖店WATCH除外）。\r\n本券不能与其他优惠券同时使用。\r\n游戏机、苹果手机及相关产品，名牌箱包，药品和部分指定商品除外。","useWay":"请在付款时出示本优惠券。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FnyW3mTRw5rqPfK8O51Ifed7nQCo","advertisementOrder":6,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae2460544b293001544c4c217d7fe6"},{"countryId":"Japan","countryName":"日本","mallName":"SONOKO莊能子日本银座总店","couponCode":"JPN2016040056","type":"折扣券","typeValue":"5%off","condition":"立减","conditionValue":"5%off+8%免税","startTime":"2016-04-01 11:58:10","endTime":"2017-01-31 11:58:21","trialObject":"全场通用","trialObjectValue":"全场通用（日本银座总店）","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FuCAAuPzlWUM0UvYg1zsu0wB1y6L","webLink":"","useScene":"SONOKO品牌所有商品（非SONOKO商品除外）。","useWay":"请到2F收银台付款前出示本图。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FvpYlz9aeSC8d9nsbORog_TguL6L","advertisementOrder":4,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246053cb7f9b0154037b46365872"},{"countryId":"Japan","countryName":"日本","mallName":"SAKUGA商会","couponCode":"JPN2016040055","type":"折扣券","typeValue":"2%off","condition":"立减","conditionValue":"批发价+2%优惠+8%免税","startTime":"2016-04-01 11:51:25","endTime":"2016-11-30 11:51:31","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Flzubt7mEfTD_4eYfzBYUn_Tvwys","webLink":"","useScene":"店内所有商品。","useWay":"进店请出示本图（电子版、打印版均可）。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FhJvT8ay2UBMt7dtvyW0l6n-lG89","advertisementOrder":3,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246053cb7f9b01540376338f5863"},{"countryId":"Japan","countryName":"日本","mallName":"KIX关西机场","couponCode":"JPN2016010007","type":"折扣券","typeValue":"5%off","condition":"立减","conditionValue":"5%off","startTime":"2016-04-01 17:37:58","endTime":"2017-03-31 17:38:00","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fu4-X7PN5v8NnDDNHxb-GRF9_AVw","webLink":"","useScene":"食品等一部分商品不在折扣范围内。","useWay":"请打印并出示此券以享优惠。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FsRWxZW1haBJnZDPuFT5pa0BiyzB","advertisementOrder":6,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae24605276d12001527836927b0169"},{"countryId":"Japan","countryName":"日本","mallName":"北海道永旺累加立减优惠券","couponCode":"JPN2016030047","type":"折扣券","typeValue":"400日元减免","condition":"满减","conditionValue":"购物满2000日元或以上可立即获减200日元，购物满4000日元或以上可立即获减400日元，以此类推。","startTime":"2016-03-10 16:02:10","endTime":"2016-12-31 16:02:26","trialObject":"全场通用","trialObjectValue":"北海道永旺各大分店，详情见\u201c优惠券使用范围\u201d。","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fm1LAL90KNWuCmiy-HTM9U17FblU","webLink":"","useScene":"1.日本以外国家或地区发行的JCB信用卡均可参与此活动。\r\n2.本次活动仅限选择JCB网络通道支付时才可参与。\r\n3.本优惠不可与店内其他优惠折扣合并使用。\r\n4.每人每卡可多次参与。\r\n5.本活动不适用于部分商品及专卖店。\r\n6.JCB国际信用卡公司在法律允许的条件下对本次活动持有最终解释权。","useWay":"1.在购物前出示电子版或者打印版优惠券。\r\n2.使用JCB信用卡，并通过JCB结算通道支付。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FpEiRc-6HgUft1uo8ZlVPfVgoJ_n","advertisementOrder":6,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae24605363d428015364bb186f606b"},{"countryId":"Japan","countryName":"日本","mallName":"Sofmap","couponCode":"JPN2016020005","type":"折扣券","typeValue":"最高86折优惠","condition":"立减","conditionValue":"8%免税+6%优惠","startTime":"2016-03-01 11:34:47","endTime":"2017-03-31 11:34:54","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FrQNlewP6KFm0KJP5ZPlfjc7SCS1","webLink":"","useScene":"","useWay":"请出示护照","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fh9TpIx0w_i8U81AykHBD4wJQj96","advertisementOrder":3,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052e2e6f60152e303994f0f72"},{"countryId":"Japan","countryName":"日本","mallName":"BIC CAMERA","couponCode":"JPN2016020006","type":"折扣券","typeValue":"最高86折优惠","condition":"立减","conditionValue":"8%免税+6%优惠","startTime":"2016-03-01 00:00:00","endTime":"2017-03-31 23:59:59","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FrQNlewP6KFm0KJP5ZPlfjc7SCS1","webLink":"","useScene":"使用条件：短期再留旅行者（签证6个月以内）\r\n适用范围：符合免税条件的商品。书籍、游戏机、啤酒、易耗品、一部分特价品不可使用。\r\n无折扣商品：劳力士手表、书籍、苹果产品\r\n部分必酷酒类（易拉罐酒类等）必酷药妆店（药品、日用品等）","useWay":"使用时请出示护照。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Flxw8DEWvtp3BKHB5EhJVoyCGBCN","advertisementOrder":2,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052e2e6f60152e30ea1da0fe7"},{"countryId":"Japan","countryName":"日本","mallName":"小岛","couponCode":"JPN2016020007","type":"折扣券","typeValue":"最高86折优惠","condition":"立减","conditionValue":"免税8%+优惠6%","startTime":"2016-03-01 00:00:00","endTime":"2017-03-31 23:59:59","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FrQNlewP6KFm0KJP5ZPlfjc7SCS1","webLink":"","useScene":"使用时请出示护照，扫描条形码打折。","useWay":"使用时请出示护照，扫描条形码打折。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fi-6WdE4sdd82pKLx7tPlebKXZN8","advertisementOrder":6,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052e311030152e31e67a60619"},{"countryId":"Japan","countryName":"日本","mallName":"松屋银座","couponCode":"JPN2016020013","type":"折扣券","typeValue":"最高9折优惠","condition":"立减","conditionValue":"2%优惠+8%免税","startTime":"2016-02-16 14:55:15","endTime":"2016-11-30 23:55:24","trialObject":"全场通用","trialObjectValue":"本馆1-7层，マロニエ通馆1-3层，别馆（一小部分商品除外）","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FtmJ7GkwTpurV8ODA4S5dXDbE6zG","webLink":"","useScene":"本馆1-7层，マロニエ通馆1-3层，别馆（一小部分商品除外）\r\n特价商品以及LV,卡地亚，劳力士，三宅一生等数家品牌除外。\r\n","useWay":"购物前，请持本优惠券到本馆地下一层免税柜台办理手续。","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FnZXv8IBrXdCGtllzm_MaXaANh7z","advertisementOrder":2,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":null,"thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052e894f90152e8e3fa6b167f"},{"countryId":"Japan","countryName":"日本","mallName":"AAS免税店","couponCode":"JPN2016020002","type":"折扣券","typeValue":"7% OFF","condition":"立减","conditionValue":"93折优惠","startTime":"2016-02-01 18:35:02","endTime":"2017-06-30 18:35:12","trialObject":"全场通用","trialObjectValue":"全场通用","usageMode":"仅线下","status":1,"couponPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/Fp2RpQKXTeMx4bpjd6G4Vq42GiRW","webLink":"","useScene":"部分商品除外","useWay":"结账时请出示优惠券","isAdvertisement":"1","advertisementPicUrl":"http://7xnfai.com1.z0.glb.clouddn.com/FhBhf3_Kscy3xbU8lOhnUk1cufto","advertisementOrder":6,"haveReceived":false,"receiveCodeList":[],"couponSource":0,"couponName":null,"isPrivate":0,"couponNamePic":"","thirdCouponCode":null,"thirdCouponCodeList":[],"isGroup":0,"remark":null,"couponId":"8aae246052a14a860152a1932921015d"}]
     * pageNo : 1
     * dateObj : null
     * hasNext : true
     */

    private ObjBean obj;
    private boolean script;

    protected CouponBean(Parcel in) {
        success = in.readByte() != 0;
        script = in.readByte() != 0;
    }

    public static final Creator<CouponBean> CREATOR = new Creator<CouponBean>() {
        @Override
        public CouponBean createFromParcel(Parcel in) {
            return new CouponBean(in);
        }

        @Override
        public CouponBean[] newArray(int size) {
            return new CouponBean[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (success ? 1 : 0));
        dest.writeByte((byte) (script ? 1 : 0));
    }

    public static class ObjBean {
        private int pageNo;
        private Object dateObj;
        private boolean hasNext;
        /**
         * countryId : Japan
         * countryName : 日本
         * mallName : 东急百货
         * couponCode : JPN2016090145
         * type : 折扣券
         * typeValue : 最高87折优惠
         * condition : 立减
         * conditionValue : 5%优惠+8%免税
         * startTime : 2016-09-12 09:45:12
         * endTime : 2017-03-31 09:45:13
         * trialObject : 全场通用
         * trialObjectValue : 全场通用
         * usageMode : 仅线下
         * status : 1
         * couponPicUrl : http://7xnfai.com1.z0.glb.clouddn.com/Fvhfoigjt_yU_TH6sP5ZGdo5Xsxn
         * webLink :
         * useScene : 适用于以下店铺：
         1、东京银座地铁站东急广场银座3-5F
         2、涩谷·本店
         3、涩谷 Hikarie ShinQs 店
         4、札幌店
         5、新千岁机场店
         6、吉祥寺店
         7、涩谷站·东横店
         * useWay : 1、消费满3240日元（含税）以上可享用
         2、不可和其他优惠同时使用
         3、部分品牌不参与活动
         4、仅限外国客人使用
         * isAdvertisement : 1
         * advertisementPicUrl : http://7xnfai.com1.z0.glb.clouddn.com/Fs6d9PpR31ItinO__IQNa9tUhsqk
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
         * couponId : ff80808156bb1a3e01571c174cba17bd
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

        public static class DataBean implements Parcelable {
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

            protected DataBean(Parcel in) {
                countryId = in.readString();
                countryName = in.readString();
                mallName = in.readString();
                couponCode = in.readString();
                type = in.readString();
                typeValue = in.readString();
                condition = in.readString();
                conditionValue = in.readString();
                startTime = in.readString();
                endTime = in.readString();
                trialObject = in.readString();
                trialObjectValue = in.readString();
                usageMode = in.readString();
                status = in.readInt();
                couponPicUrl = in.readString();
                webLink = in.readString();
                useScene = in.readString();
                useWay = in.readString();
                isAdvertisement = in.readString();
                advertisementPicUrl = in.readString();
                advertisementOrder = in.readInt();
                haveReceived = in.readByte() != 0;
                couponSource = in.readInt();
                isPrivate = in.readInt();
                couponNamePic = in.readString();
                isGroup = in.readInt();
                couponId = in.readString();
            }

            public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
                @Override
                public DataBean createFromParcel(Parcel in) {
                    return new DataBean(in);
                }

                @Override
                public DataBean[] newArray(int size) {
                    return new DataBean[size];
                }
            };

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(countryId);
                dest.writeString(countryName);
                dest.writeString(mallName);
                dest.writeString(couponCode);
                dest.writeString(type);
                dest.writeString(typeValue);
                dest.writeString(condition);
                dest.writeString(conditionValue);
                dest.writeString(startTime);
                dest.writeString(endTime);
                dest.writeString(trialObject);
                dest.writeString(trialObjectValue);
                dest.writeString(usageMode);
                dest.writeInt(status);
                dest.writeString(couponPicUrl);
                dest.writeString(webLink);
                dest.writeString(useScene);
                dest.writeString(useWay);
                dest.writeString(isAdvertisement);
                dest.writeString(advertisementPicUrl);
                dest.writeInt(advertisementOrder);
                dest.writeByte((byte) (haveReceived ? 1 : 0));
                dest.writeInt(couponSource);
                dest.writeInt(isPrivate);
                dest.writeString(couponNamePic);
                dest.writeInt(isGroup);
                dest.writeString(couponId);
            }
        }
    }
}
