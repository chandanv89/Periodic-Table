package com.github.chandanv89.api.periodictable.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Element {
  @Id
  private Integer atomicNumber;
  private String symbol;
  private String name;
  private String atomicMass;
  private String electronicConfiguration;
  private String electronegativity;
  private String atomicRadius;
  private String ionRadius;
  private String vanDerWaalsRadius;
  private String ionizationEnergy;
  private String electronAffinity;
  private String oxidationStates;
  private String standardState;
  private String bondingType;
  private String meltingPoint;
  private String boilingPoint;
  private String density;
  private String groupBlock;
  private String yearDiscovered;
  private String block;
  private String cpkHexColor;
  private Integer period;
  @Column(name = "table_group")
  private Integer group;
}
