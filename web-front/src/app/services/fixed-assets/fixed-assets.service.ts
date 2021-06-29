import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FIXED_ASSET_ENDPOINTS } from 'src/app/endpoints/fixedAsset.constant';
import { IFilter } from 'src/app/model/filter';
import { IFixedAsset } from 'src/app/model/fixedAsset';
import { IResponse } from 'src/app/model/response';

@Injectable({
  providedIn: 'root'
})
export class FixedAssetsService {
  private readonly ENDPOINT = FIXED_ASSET_ENDPOINTS;

  constructor(private http: HttpClient) {}

  /**
   * Method to obtain the information of the fixed asset by id
   *
   * @author ingalexandrasarmiento
   * @param id ID of fixed asset
   * @returns Observable<IResponse<IFixedAsset>>
   */
  public findById(id: string): Observable<IResponse<IFixedAsset>> {
    return this.http.get<IResponse<IFixedAsset>>(this.ENDPOINT.findById.concat(id));
  }

  /**
   * Method to filter the list of fixed assets
   *
   * @author ingalexandrasarmiento
   * @param filter Filter to list fixed assets
   * @returns Observable<IResponse<IFixedAsset[]>>
   */
  public searchByFilter(filter: IFilter): Observable<IResponse<IFixedAsset[]>> {
    return this.http.post<IResponse<IFixedAsset[]>>(this.ENDPOINT.searchByFilter, filter);
  }

  /**
   * Method to save or update a fixed asset
   *
   * @author ingalexandrasarmiento
   * @param fixedAsset Fixed asset to save or update
   * @returns Observable<IResponse<Boolean>>
   */
  public save(fixedAsset: IFixedAsset): Observable<IResponse<boolean>> {
    return this.http.post<IResponse<boolean>>(this.ENDPOINT.saveFixedAsset, fixedAsset);
  }

}
