package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voyageur implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoyageur;
	
	String nomVoyageur;

	
	public List<Voyage> getMesvoyages() {
		return mesvoyages;
	}

	public void setMesvoyages(List<Voyage> mesvoyages) {
		this.mesvoyages = mesvoyages;
	}

	@ManyToMany(mappedBy = "mesVoyageurs")
    public List<Voyage> mesvoyages;


	public Voyageur(String nomVoyageur, List<Voyage> mesvoyages) {
		super();
		this.nomVoyageur = nomVoyageur;
		this.mesvoyages = mesvoyages;
	}
	
	
	
}
