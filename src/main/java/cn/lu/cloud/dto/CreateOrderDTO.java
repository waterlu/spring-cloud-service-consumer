package cn.lu.cloud.dto;

import java.math.BigDecimal;

/**
 * Created by lutiehua on 2017/10/10.
 */
public class CreateOrderDTO {

    private String userUuid;

    private String accountUuid;

    private String productUuid;

    private BigDecimal amount;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
