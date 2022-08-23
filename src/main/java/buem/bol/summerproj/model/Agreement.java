package buem.bol.summerproj.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Agreement {
    private String id;
    private String name;
    private Client client;
    private List<Favor> favors = new ArrayList<Favor>();
    private int sum;
    private int commission;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Agreement() {
    }

    public Agreement(String id, String name, Client client, List<Favor> favors, int sum, int commission, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.favors = favors;
        this.sum = sum;
        this.commission = commission;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Agreement(String name, Client client, List<Favor> favors, int sum, int commission, String description) {
        this.name = name;
        this.client = client;
        this.favors = favors;
        this.sum = sum;
        this.commission = commission;
        this.description = description;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Favor> getFavors() {
        return favors;
    }

    public void setFavors(List<Favor> favors) {
        this.favors = favors;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
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
        Agreement agreement = (Agreement) o;
        return getId().equals(agreement.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", client=" + client +
                ", favors=" + favors +
                ", sum=" + sum +
                ", commission=" + commission +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}


