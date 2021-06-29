export interface IFixedAsset {
    idFixedAsset: number;
    idType: number;
    idArea?: number;
    idPerson?: number;
    name: string;
    description: string;
    serialNumber: string;
    inventoryNumber: number;
    assetWeight: number;
    assetHeigh: number;
    assetWidth: number;
    assetLong: number;
    purchaseValue: number;
    purchaseDate: string;
}
