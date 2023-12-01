package com.github.chandanv89.api.periodictable.model;

import com.github.chandanv89.api.periodictable.util.Utils;
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
public class Element {
  @Id
  private Integer atomicNumber;
  @Column(name = "table_group")
  private Integer group;
  private Integer period;
  private String atomicMass;
  private String atomicRadius;
  private String block;
  private String boilingPoint;
  private String bondingType;
  private String cpkHexColor;
  private String density;
  private String electronAffinity;
  private String electronegativity;
  private String electronicConfiguration;
  private String groupBlock;
  private String ionRadius;
  private String ionizationEnergy;
  private String meltingPoint;
  private String name;
  private String oxidationStates;
  private String standardState;
  private String symbol;
  private String vanDerWaalsRadius;
  private String yearDiscovered;

  @Override
  public String toString() {
    return Utils.toJson(this);
  }
}
