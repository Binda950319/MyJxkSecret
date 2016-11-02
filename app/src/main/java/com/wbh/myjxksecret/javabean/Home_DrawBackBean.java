package com.wbh.myjxksecret.javabean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
public class Home_DrawBackBean {

    /**
     * id : null
     * success : true
     * reCode : null
     * message : null
     * obj : {"bankAccountCnt":0,"taxRefundPhone":"4006-121-088","taxRefundInstitutionList":[{"institutionName":"Premier*Tax Free","institutionLogo":"http://7xsy3q.com2.z0.glb.qiniucdn.com/PremierTax%20Free.png"},{"institutionName":"Tax Free*Worldwide","institutionLogo":"http://7xsy3q.com2.z0.glb.qiniucdn.com/TaxFree%20Worldwide.png"},{"institutionName":"Innova Tax*Free Group","institutionLogo":"http://7xsy3q.com2.z0.glb.qiniucdn.com/InnovaTaxFree%20Group.png"},{"institutionName":"Tax Refund*Service Srl","institutionLogo":"http://7xsy3q.com2.z0.glb.qiniucdn.com/TaxRefund%20ServiceSrl.png"}],"thirdInterfaceStatus":"1"}
     * script : false
     */

    private Object id;
    private boolean success;
    private Object reCode;
    private Object message;
    /**
     * bankAccountCnt : 0
     * taxRefundPhone : 4006-121-088
     * taxRefundInstitutionList : [{"institutionName":"Premier*Tax Free","institutionLogo":"http://7xsy3q.com2.z0.glb.qiniucdn.com/PremierTax%20Free.png"},{"institutionName":"Tax Free*Worldwide","institutionLogo":"http://7xsy3q.com2.z0.glb.qiniucdn.com/TaxFree%20Worldwide.png"},{"institutionName":"Innova Tax*Free Group","institutionLogo":"http://7xsy3q.com2.z0.glb.qiniucdn.com/InnovaTaxFree%20Group.png"},{"institutionName":"Tax Refund*Service Srl","institutionLogo":"http://7xsy3q.com2.z0.glb.qiniucdn.com/TaxRefund%20ServiceSrl.png"}]
     * thirdInterfaceStatus : 1
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
        private int bankAccountCnt;
        private String taxRefundPhone;
        private String thirdInterfaceStatus;
        /**
         * institutionName : Premier*Tax Free
         * institutionLogo : http://7xsy3q.com2.z0.glb.qiniucdn.com/PremierTax%20Free.png
         */

        private List<TaxRefundInstitutionListBean> taxRefundInstitutionList;

        public int getBankAccountCnt() {
            return bankAccountCnt;
        }

        public void setBankAccountCnt(int bankAccountCnt) {
            this.bankAccountCnt = bankAccountCnt;
        }

        public String getTaxRefundPhone() {
            return taxRefundPhone;
        }

        public void setTaxRefundPhone(String taxRefundPhone) {
            this.taxRefundPhone = taxRefundPhone;
        }

        public String getThirdInterfaceStatus() {
            return thirdInterfaceStatus;
        }

        public void setThirdInterfaceStatus(String thirdInterfaceStatus) {
            this.thirdInterfaceStatus = thirdInterfaceStatus;
        }

        public List<TaxRefundInstitutionListBean> getTaxRefundInstitutionList() {
            return taxRefundInstitutionList;
        }

        public void setTaxRefundInstitutionList(List<TaxRefundInstitutionListBean> taxRefundInstitutionList) {
            this.taxRefundInstitutionList = taxRefundInstitutionList;
        }

        public static class TaxRefundInstitutionListBean {
            private String institutionName;
            private String institutionLogo;

            public String getInstitutionName() {
                return institutionName;
            }

            public void setInstitutionName(String institutionName) {
                this.institutionName = institutionName;
            }

            public String getInstitutionLogo() {
                return institutionLogo;
            }

            public void setInstitutionLogo(String institutionLogo) {
                this.institutionLogo = institutionLogo;
            }
        }
    }
}
