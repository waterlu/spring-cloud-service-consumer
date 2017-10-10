package cn.lu.cloud.entity;

import java.math.BigDecimal;

/**
 * Created by lutiehua on 2017/10/10.
 */
public class Product {

    private Long productId;

    private String productUuid;

    private String productCode;

    private String productType;

    private String productName;

    private Integer productStatus;

    private Integer productOnStatus;

    private Integer productPeriod;

    private String productPeriodType;

    private BigDecimal productAnnualInterestRate;

    private BigDecimal productScale;

    private BigDecimal productAccumulation;

    private BigDecimal productMinInvestment;

    private BigDecimal productMaxInvestment;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getProductOnStatus() {
        return productOnStatus;
    }

    public void setProductOnStatus(Integer productOnStatus) {
        this.productOnStatus = productOnStatus;
    }

    public Integer getProductPeriod() {
        return productPeriod;
    }

    public void setProductPeriod(Integer productPeriod) {
        this.productPeriod = productPeriod;
    }

    public String getProductPeriodType() {
        return productPeriodType;
    }

    public void setProductPeriodType(String productPeriodType) {
        this.productPeriodType = productPeriodType;
    }

    public BigDecimal getProductAnnualInterestRate() {
        return productAnnualInterestRate;
    }

    public void setProductAnnualInterestRate(BigDecimal productAnnualInterestRate) {
        this.productAnnualInterestRate = productAnnualInterestRate;
    }

    public BigDecimal getProductScale() {
        return productScale;
    }

    public void setProductScale(BigDecimal productScale) {
        this.productScale = productScale;
    }

    public BigDecimal getProductAccumulation() {
        return productAccumulation;
    }

    public void setProductAccumulation(BigDecimal productAccumulation) {
        this.productAccumulation = productAccumulation;
    }

    public BigDecimal getProductMinInvestment() {
        return productMinInvestment;
    }

    public void setProductMinInvestment(BigDecimal productMinInvestment) {
        this.productMinInvestment = productMinInvestment;
    }

    public BigDecimal getProductMaxInvestment() {
        return productMaxInvestment;
    }

    public void setProductMaxInvestment(BigDecimal productMaxInvestment) {
        this.productMaxInvestment = productMaxInvestment;
    }
}
