import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CITY_ENDPOINTS } from 'src/app/endpoints/cities.constant';
import { IResponse } from 'src/app/model/response';
import { ICity } from 'src/app/model/city';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CitiesService {
  private readonly ENDPOINT = CITY_ENDPOINTS;

  constructor(private http: HttpClient) {}

  /**
   * Method to obtain the information of the cities
   *
   * @author ingalexandrasarmiento
   * @returns Observable<IResponse<ICity[]>>
   */
   public getCities(): Observable<IResponse<ICity[]>> {
    return this.http.get<IResponse<ICity[]>>(this.ENDPOINT.listCities);
  }

}
