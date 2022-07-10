package com.emit.engineapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "vehicles")
public class Vehicle implements ModelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehicles")
	private Long idVehicle;
	
	@NotNull(message= "The field manufacturer must to be specified")
	@JoinColumn(name = "id_manufacturer", foreignKey = @ForeignKey(name = "fk_vehicle_manufacturer"))
	@OneToOne
	private Manufacturer manufacturer; 
	
	@NotNull(message = "The field category must to be specified")
	@JoinColumn(name = "id_category", foreignKey = @ForeignKey(name = "fk_vehicle_category"))
	@OneToOne
	private Category category; 
	
	@Min(value = 1, message = "The field horsepower must be higher than 0")
	@Column(name = "horsepower") 
	private Long horsepower; 
	
	@Min(value = 1, message = "The field top_speed must be higher than 0")
	@Column(name = "top_speed") 
	private Long top_speed; 
	
	@Column(name = "img")
	private String img;
	
	@NotNull(message = "The field model must to be specfied")
	@Column(name = "model")
	private String model; 
}
