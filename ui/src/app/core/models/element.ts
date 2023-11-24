/**
 * Interface for the element object
 */
export interface Element {
    atomicNumber: number;
    symbol: string;
    name: string;
    atomicMass: number;
    cpkHexColor?: string;
    electronicConfiguration?: string;
    electronegativity?: number;
    atomicRadius?: number;
    ionRadius?: string;
    vanDerWaalsRadius?: number;
    ionizationEnergy?: number;
    electronAffinity?: number;
    oxidationStates?: string;
    standardState?: string;
    bondingType?: string;
    meltingPoint?: number;
    boilingPoint?: number;
    density?: number;
    groupBlock?: string;
    block?: string;
    period?: number;
    group?: number;
    yearDiscovered?: number;


//   "atomicNumber": 1,
//   "symbol": "H",
//   "name": "Hydrogen",
//   "atomicMass": "1.00794",
//   "electronicConfiguration": "1s1",
//   "electronegativity": "2.2",
//   "atomicRadius": "37",
//   "ionRadius": "unknown",
//   "vanDerWaalsRadius": "120",
//   "ionizationEnergy": "1312",
//   "electronAffinity": "-73",
//   "oxidationStates": "-1, 1",
//   "standardState": "gas",
//   "bondingType": "diatomic",
//   "meltingPoint": "14",
//   "boilingPoint": "20",
//   "density": "0.0000899",
//   "groupBlock": "nonmetal",
//   "yearDiscovered": "1766",
//   "block": "s",
//   "cpkHexColor": "FFFFFF",
//   "period": 1,
//   "group": 1
}