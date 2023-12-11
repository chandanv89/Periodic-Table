package com.github.chandanv89.api.periodictable.model;

import com.github.chandanv89.api.periodictable.util.Utils;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Fundamental properties of the element")
public class Element {
  @Id
  @Schema(description = "Atomic number of the element", example = "1")
  private Integer atomicNumber;


  @Column(name = "table_group")
  @Schema(description = "Group of the element", example = "1")
  private Integer group;

  @Schema(description = "Period of the element", example = "1")
  private Integer period;

  @Schema(description = "Atomic mass of the element", example = "1.008")
  private String atomicMass;

  @Schema(description = "Atomic radius of the element", example = "53")
  private String atomicRadius;

  @Schema(description = "Boiling point of the element", example = "s")
  private String block;

  @Schema(description = "Boiling point of the element", example = "20")
  private String boilingPoint;

  @Schema(description = "Bonding type of the element", example = "diatomic")
  private String bondingType;

  @Schema(description = "CPK hex color of the element", example = "FFFFFF")
  private String cpkHexColor;

  @Schema(description = "Density of the element", example = "0.0000899")
  private String density;

  @Schema(description = "Electron affinity of the element", example = "72.769")
  private String electronAffinity;

  @Schema(description = "Electronegativity of the element", example = "2.2")
  private String electronegativity;

  @Schema(description = "Electronic configuration of the element", example = "1s1")
  private String electronicConfiguration;

  @Schema(description = "Group block of the element", example = "nonmetal")
  private String groupBlock;

  @Schema(description = "Ion radius of the element", example = "167 (-1)")
  private String ionRadius;

  @Schema(description = "Ionization energy of the element", example = "1312")
  private String ionizationEnergy;

  @Schema(description = "Melting point of the element", example = "14")
  private String meltingPoint;

  @Schema(description = "Name of the element", example = "Hydrogen")
  private String name;

  @Schema(description = "Oxidation states of the element", example = "-1, 1")
  private String oxidationStates;

  @Schema(description = "Standard state of the element", example = "gas")
  private String standardState;

  @Schema(description = "Symbol of the element", example = "H")
  private String symbol;

  @Schema(description = "Van der Waals radius of the element", example = "120")
  private String vanDerWaalsRadius;

  @Schema(description = "Year discovered of the element", example = "1766")
  private String yearDiscovered;

  @Override
  public String toString() {
    return Utils.toJson(this);
  }
}
