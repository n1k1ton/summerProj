package buem.bol.summerproj.form;

import buem.bol.summerproj.model.FavorName;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class FavorForm {
    private String id;
    private FavorName favorName;
    private String description;

    private double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public FavorForm(String id, FavorName favorName, String description, double price, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.favorName = favorName;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public FavorForm() {
    }

    public FavorForm(FavorName favorName, String description, double price) {
        this.favorName = favorName;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FavorName getFavorName() {
        return favorName;
    }

    public void setFavorName(FavorName favorName) {
        this.favorName = favorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        return "FavorForm{" +
                "id='" + id + '\'' +
                ", favorName=" + favorName +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
