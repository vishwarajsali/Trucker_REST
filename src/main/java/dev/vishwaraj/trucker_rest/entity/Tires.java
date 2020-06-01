package dev.vishwaraj.trucker_rest.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Tires {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pg-uuid")
    @GenericGenerator(name = "pg-uuid", strategy = "uuid2")
    @Column(length = 50)
    @JsonIgnore
    private String tId;


    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;


    // @OneToOne(mappedBy = "tires")
    // @JsonIgnore
    // private Reading reading;

}