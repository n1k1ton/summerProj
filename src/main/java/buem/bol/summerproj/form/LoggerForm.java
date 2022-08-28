package buem.bol.summerproj.form;

import buem.bol.summerproj.model.Agreement;

import java.time.LocalDateTime;

public class LoggerForm {
    private String id;
    private String name;
    private String agreement;

    private double sum;
    private double discount;
    private LocalDateTime transactionDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LoggerForm() {
    }

    public LoggerForm(String name, String agreement, LocalDateTime transactionDate) {
        this.name = name;
        this.agreement = agreement;
        this.transactionDate = transactionDate;
    }

    public LoggerForm(String name, String agreement, double sum, double discount, LocalDateTime transactionDate) {
        this.name = name;
        this.agreement = agreement;
        this.sum = sum;
        this.discount = discount;
        this.transactionDate = transactionDate;
    }

    public LoggerForm(String id, String name, String agreement, double sum, double discount, LocalDateTime transactionDate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.agreement = agreement;
        this.sum = sum;
        this.discount = discount;
        this.transactionDate = transactionDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "LoggerForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", agreement='" + agreement + '\'' +
                ", sum=" + sum +
                ", discount=" + discount +
                ", transactionDate=" + transactionDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
