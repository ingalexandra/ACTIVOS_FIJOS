import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TYPE_ASSET_ENDPOINTS } from 'src/app/endpoints/typesFixedAssets.constant';
import { IResponse } from 'src/app/model/response';
import { Observable } from 'rxjs';
import { ITypeFixedAsset } from 'src/app/model/typeFixedAsset';

@Injectable({
  providedIn: 'root'
})
export class TypesFixedAssetsService {
  private readonly ENDPOINT = TYPE_ASSET_ENDPOINTS;

  constructor(private http: HttpClient) {}

  /**
   * Method to obtain the information of the types of fixed assets
   *
   * @author ingalexandrasarmiento
   * @returns Observable<IResponse<ITypeFixedAsset[]>>
   */
   public getTypesFixedAssets(): Observable<IResponse<ITypeFixedAsset[]>> {
    return this.http.get<IResponse<ITypeFixedAsset[]>>(this.ENDPOINT.listTypes);
  }
}
