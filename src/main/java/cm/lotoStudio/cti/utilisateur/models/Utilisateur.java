package cm.lotoStudio.cti.utilisateur.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Entity
@Table(name ="UTILISATEUR")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String login;
	
	@Column(nullable = false)
	private String password;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn ( name = "Personne")
	private Personne personne;
	
	@OneToMany(cascade = CascadeType.DETACH)
	@JoinTable(name ="FONCTION")
	private List<Fonction> fonction;
	

}
