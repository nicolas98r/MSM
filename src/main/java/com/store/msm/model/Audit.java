package com.store.msm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "audit_log")
@Data
public class Audit {
    @Id
    @Column(name = "audit_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "datetime")
    private Date dateTime;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private AuditType auditType;
    private String description;

}
