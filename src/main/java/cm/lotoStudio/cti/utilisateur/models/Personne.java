package cm.lotoStudio.cti.utilisateur.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="PERSONNE")
public class Personne {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY )
   	 private Long id;
 	 private String name;
 	 private String surname;
 	 private Date birthDate;
 	 private String sexe;
 	 
 	 @OneToOne(cascade = CascadeType.ALL)
 	 @JoinColumn(name= "Address")
 	 private Address address;
 	 
 	 
 
}
