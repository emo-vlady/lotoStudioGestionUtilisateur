package cm.lotoStudio.cti.utilisateur.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADRESS")
public class Address {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	private String city;
	private String country;
	private String zipCode;
	private String phone;
	private String email;
	
}
