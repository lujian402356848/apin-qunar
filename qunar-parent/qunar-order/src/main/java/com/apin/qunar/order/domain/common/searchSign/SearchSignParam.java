package com.apin.qunar.order.domain.common.searchSign;

/**
 * @outhor lujian
 * @create 2018-06-25 7:14
 */
public class SearchSignParam {
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
