package dev.vishwaraj.trucker_rest.entity;

import javax.persistence.Entity; 

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn; 
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Reading {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pg-uuid")
    @GenericGenerator(name = "pg-uuid", strategy = "uuid2")
    @Column(length = 50)
    private String rId;

    private String vin;

    private float latitude;

    private float longitute;

    private Timestamp timeStamp;

    private float fuelVolume;

    private int speed;

    private int engineHp;

    private boolean checkEngineLightOn;

    private boolean engineCoolantLow;

    private boolean cruiseControlOn;

    private int engineRpm;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tId", referencedColumnName = "tId")
   private Tires tires;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    @JoinColumn(foreignKey = @ForeignKey(name = "vin"), name = "vin")
//    private Vehicle vehicle;

} 
// - rId: UUID
// - vin: String
// - latitude: double
// - longitute: double
// - timeStamp: TimeStamp
// - fuelVolume: float
// - speed: int
// - engineHp: int
// - checkEngineLightOn: Boolean
// - engineCoolantLow: Boolean
// - cruiseControlOn: Boolean
// - engineRpm: int
// - tires: Tire
