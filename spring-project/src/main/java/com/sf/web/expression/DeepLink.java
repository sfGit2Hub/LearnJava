package com.sf.web.expression;

public class DeepLink {
    private String accountCode;
    private String channelCode;
    private String device;
    private String hotelPassport;
    private String hotelCtyhocn;
    private String linkcurlProd;
    private String linkcurlTest;
    private String hotelDeeplinkProd;
    private String hotelDeeplinkTest;
    private String compareResult;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getHotelPassport() {
        return hotelPassport;
    }

    public void setHotelPassport(String hotelPassport) {
        this.hotelPassport = hotelPassport;
    }

    public String getHotelCtyhocn() {
        return hotelCtyhocn;
    }

    public void setHotelCtyhocn(String hotelCtyhocn) {
        this.hotelCtyhocn = hotelCtyhocn;
    }

    public String getLinkcurlProd() {
        return linkcurlProd;
    }

    public void setLinkcurlProd(String linkcurlProd) {
        this.linkcurlProd = linkcurlProd;
    }

    public String getLinkcurlTest() {
        return linkcurlTest;
    }

    public void setLinkcurlTest(String linkcurlTest) {
        this.linkcurlTest = linkcurlTest;
    }

    public String getHotelDeeplinkProd() {
        return hotelDeeplinkProd;
    }

    public void setHotelDeeplinkProd(String hotelDeeplinkProd) {
        this.hotelDeeplinkProd = hotelDeeplinkProd;
    }

    public String getHotelDeeplinkTest() {
        return hotelDeeplinkTest;
    }

    public void setHotelDeeplinkTest(String hotelDeeplinkTest) {
        this.hotelDeeplinkTest = hotelDeeplinkTest;
    }

    public String getCompareResult() {
        return compareResult;
    }

    public DeepLink setCompareResult() {
        if (this.hotelDeeplinkProd.equals(this.hotelDeeplinkTest)) {
            if (this.hotelDeeplinkProd.equals("exception")) {
                this.compareResult = "different";
            } else {
                this.compareResult = "same";
            }
        } else {
            this.compareResult = "different";
        }
        return this;
    }

    public boolean channelEquals(String code) {
        return this.channelCode.equals(code);
    }

    public boolean channelContains(String code) {
        return this.channelCode.contains(code);
    }

    public boolean passportContains(String passport) {
        return this.hotelPassport.contains(passport);
    }

    @Override
    public String toString() {
        return "DeepLinkDto{"
                + "accountCode='" + accountCode + '\''
                + ", channelCode='" + channelCode + '\''
                + ", device='" + device + '\''
                + ", hotelPassport='" + hotelPassport + '\''
                + ", hotelCtyhocn='" + hotelCtyhocn + '\''
                + ", linkcurlProd='" + linkcurlProd + '\''
                + ", linkcurlTest='" + linkcurlTest + '\''
                + ", hotelDeeplinkProd='" + hotelDeeplinkProd + '\''
                + ", hotelDeeplinkTest='" + hotelDeeplinkTest + '\''
                + ", compareResult='" + compareResult + '\''
                + '}';
    }
}
