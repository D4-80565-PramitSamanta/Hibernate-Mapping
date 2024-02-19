package com.app.entities;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Person extends BaseEntity {
	String name;
	String address;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aadhar_card_id", referencedColumnName = "id")
	AadharCard card;
}
