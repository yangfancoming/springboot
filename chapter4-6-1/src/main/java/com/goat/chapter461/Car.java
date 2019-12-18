package com.goat.chapter461;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "CAR")
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final Logger logger = LoggerFactory.getLogger(Car.class);

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "DEFAULT_SEQ")
    @SequenceGenerator(name = "DEFAULT_SEQ", sequenceName = "DEFAULT_SEQ")
    @Column(name = "INOUT_STORAGE_ID")
	private Integer carId;


	@Column(name="CAR_BRAND", nullable = true, length = 50)
	private String carBrand;
	
	@Column(name="CAR_MODEL", nullable = true, length = 50)
    private String carModel;
	
	@Column(name="HORSEPOWER", nullable = true, length = 6)
    private String horsepower;
	
	@Column(name="CAR_ENGINE", nullable = true, length = 6)
    private String carEngine;
	
	public Car(){}  
	
    public Car(String carBrand, String carModel, String horsepower, String carEngine) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.horsepower = horsepower;
        this.carEngine = carEngine;
    }
}
