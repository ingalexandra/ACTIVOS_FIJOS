import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IResponse } from 'src/app/model/response';
import { IArea } from 'src/app/model/area';
import { AREA_ENDPOINTS } from 'src/app/endpoints/area.constant';

@Injectable({
  providedIn: 'root'
})
export class AreasService {
  private readonly ENDPOINT = AREA_ENDPOINTS;

  constructor(private http: HttpClient) {}

  /**
   * Method to obtain the information of the areas
   *
   * @author ingalexandrasarmiento
   * @returns Observable<IResponse<IArea[]>>
   */
   public getAreas(): Observable<IResponse<IArea[]>> {
    return this.http.get<IResponse<IArea[]>>(this.ENDPOINT.listAreas);
  }

}
