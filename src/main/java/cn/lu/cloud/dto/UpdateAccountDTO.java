package cn.lu.cloud.dto;

import java.math.BigDecimal;

/**
 * Created by lutiehua on 2017/10/25.
 */
public class UpdateAccountDTO {

    private String accountUuid;

    private BigDecimal balanceChanged;

    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }

    public BigDecimal getBalanceChanged() {
        return balanceChanged;
    }

    public void setBalanceChanged(BigDecimal balanceChanged) {
        this.balanceChanged = balanceChanged;
    }
}
