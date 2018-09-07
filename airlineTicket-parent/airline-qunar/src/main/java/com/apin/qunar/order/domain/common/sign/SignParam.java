package com.apin.qunar.order.domain.common.sign;

public class SignParam {
    private String bankCode;
    private String signedAccount;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getSignedAccount() {
        return signedAccount;
    }

    public void setSignedAccount(String signedAccount) {
        this.signedAccount = signedAccount;
    }
}
