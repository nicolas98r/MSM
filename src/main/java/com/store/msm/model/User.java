package com.store.msm.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "client")
@Data
public class User {
    @Id
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private UserType userType;


}
