package buem.bol.summerproj.form;

import buem.bol.summerproj.model.Client;
import buem.bol.summerproj.model.Favor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AgreementForm {
    private String id;
    private String name;
    private String client;
    private String favor;
    private String description;

    public AgreementForm() {
    }

    public AgreementForm(String name, String client, String favor, String description) {
        this.name = name;
        this.client = client;
        this.favor = favor;
        this.description = description;
    }

    public AgreementForm(String id, String name, String client, String favor, String description) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.favor = favor;
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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getFavor() {
        return favor;
    }

    public void setFavor(String favor) {
        this.favor = favor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AgreementForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", client='" + client + '\'' +
                ", favor='" + favor + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
