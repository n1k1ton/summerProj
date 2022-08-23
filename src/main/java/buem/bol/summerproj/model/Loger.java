package buem.bol.summerproj.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;

public class Loger {
    @Id
    private String id;
    private String name;
    private Agreement agreement;
    private double discount;
    private LocalDateTime transactionDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Loger(String id, String name, Agreement agreement, double discount, LocalDateTime transactionDate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.agreement = agreement;
        this.discount = discount;
        this.transactionDate = transactionDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Loger(String name, Agreement agreement, double discount, LocalDateTime transactionDate) {
        this.name = name;
        this.agreement = agreement;
        this.discount = discount;
        this.transactionDate = transactionDate;
    }

    public Loger() {
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

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loger loger = (Loger) o;
        return getId().equals(loger.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Loger{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", agreement=" + agreement +
                ", discount=" + discount +
                ", transactionDate=" + transactionDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
