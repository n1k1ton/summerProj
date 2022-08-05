package buem.bol.summerproj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
@Document
public class Favors {
    @Id
    private String id;
    private FavorName favorName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public FavorName getFavorName() {
        return favorName;
    }

    public void setFavorName(FavorName favorName) {
        this.favorName = favorName;
    }

    public Favors(FavorName favorName, String description) {
        this.favorName = favorName;
        this.description = description;
    }

    public Favors(String id, FavorName favorName, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.favorName = favorName;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Favors() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Favors favors = (Favors) o;
        return getId().equals(favors.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
    @Override
    public String toString() {
        return "Favors{" +
                "id='" + id + '\'' +
                ", favorName=" + favorName +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
