package buem.bol.summerproj.model;

import java.time.LocalDateTime;

public class Agreements {
    private String id;
    private String name;
    private Clients client;
    private Favors favor;
    private int sum;
    private int commission;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
