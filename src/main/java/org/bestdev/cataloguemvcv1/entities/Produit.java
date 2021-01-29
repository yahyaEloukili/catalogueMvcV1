package org.bestdev.cataloguemvcv1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 4,max = 15,message = "Name must be between 4 and 15")
    private String designation;
    @DecimalMin("100")
    private double price;
    private int quantite;


}
