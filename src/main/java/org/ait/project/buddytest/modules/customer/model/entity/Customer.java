package org.ait.project.buddytest.modules.customer.model.entity;

import lombok.*;
import org.ait.project.buddytest.shared.constant.entities.BaseEntity;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "address")
    private String address;

}