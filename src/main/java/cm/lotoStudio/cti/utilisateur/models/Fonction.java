package cm.lotoStudio.cti.utilisateur.models;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="FONCTION")

public class Fonction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false )
	private String name;

	@Column(nullable = false )
	private String fonction;
	private String description;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinTable(name ="ROLE")
	private List<Role> role;
	
}
