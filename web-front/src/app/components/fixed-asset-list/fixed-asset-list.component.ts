import { Component, OnInit } from '@angular/core';
import { DatePipe } from "@angular/common";
import { forkJoin } from 'rxjs';
import { AbstractControl, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { IArea } from 'src/app/model/area';
import { ICity } from 'src/app/model/city';
import { IFilter } from 'src/app/model/filter';
import { IFixedAsset } from 'src/app/model/fixedAsset';
import { IPerson } from 'src/app/model/person';
import { ITypeFixedAsset } from 'src/app/model/typeFixedAsset';
import { AreasService } from 'src/app/services/areas/areas.service';
import { CitiesService } from 'src/app/services/cities/cities.service';
import { FixedAssetsService } from 'src/app/services/fixed-assets/fixed-assets.service';
import { PeopleService } from 'src/app/services/people/people.service';
import { TypesFixedAssetsService } from 'src/app/services/types-fixed-assets/types-fixed-assets.service';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-fixed-asset-list',
  templateUrl: './fixed-asset-list.component.html',
  styleUrls: ['./fixed-asset-list.component.css']
})
export class FixedAssetListComponent implements OnInit {
  public formFilterData: FormGroup;
  public filter: IFilter;
  public types: ITypeFixedAsset[] = [];
  public areas: IArea[] = [];
  public cities: ICity[] = [];
  public people: IPerson[] = [];
  public fixedAssets: IFixedAsset[] = [];
  public showApplyFilterButton: boolean;
  public showCleanFilterButton: boolean;
  public arrHeaders: string[] = [
    'Nombre', 'Tipo', 'Descripción', 'Serial', 'Inventario', 'Peso (kg)', 'Alto (cm)',
    'Ancho (cm)', 'Largo (cm)', 'Valor de compra', 'Fecha de compra', 'Area', 'Persona'
  ];

  constructor(
    private formBuilder: FormBuilder,
    private typesService: TypesFixedAssetsService,
    private areasService: AreasService,
    private citiesService: CitiesService,
    private peopleService: PeopleService,
    private fixedAssetsService: FixedAssetsService,
    private spinner: NgxSpinnerService,
    private datePipe: DatePipe
  ) { }

  ngOnInit() {
    this.spinner.show();
    this.initValues();
    this.initForm();
    this.getParameters();
    this.onChangesForm();
  }

  /**
   * Method to initialize values
   *
   * @author ingalexandrasarmiento
   */
  public initValues(): void {
    this.filter = {
      type: null,
      purchaseDate: null,
      serialNumber: null
    };
    this.showApplyFilterButton = false;
    this.showCleanFilterButton = false;
  }

  /**
   * Method to initialize the form
   *
   * @author ingalexandrasarmiento
   */
  public initForm(): void {
    this.formFilterData = this.formBuilder.group({
      type: new FormControl(0),
      serial: new FormControl(''),
      purchaseDate: new FormControl('')
    });
  }

  /**
   * Method to obtain the application parameters
   *
   * @author ingalexandrasarmiento
   */
  public getParameters(): void {
    this.getFixedAssetsList(this.filter);
    forkJoin([
      this.typesService.getTypesFixedAssets(),
      this.areasService.getAreas(),
      this.citiesService.getCities(),
      this.peopleService.getPeople()
    ]).subscribe((response) => {
      if (Array.isArray(response[0].data) && response[0].data.length > 0) {
        this.types = response[0].data;
      }
      if (Array.isArray(response[1].data) && response[0].data.length > 0) {
        this.areas = response[1].data;
      }
      if (Array.isArray(response[2].data) && response[0].data.length > 0) {
        this.cities = response[2].data;
      }
      if (Array.isArray(response[3].data) && response[0].data.length > 0) {
        this.people = response[3].data;
      }
    });
    this.spinner.hide();
  }

  /**
   * Method for validate changes in form
   * 
   * @author ingalexandrasarmiento
   */
  public onChangesForm(): void {
    this.formFilterData.valueChanges.subscribe((form) => {
      if (form.type > 0 || form.serial !== '' || form.purchaseDate !== '') {
        this.showApplyFilterButton = true;
      } else {
        this.showApplyFilterButton = false;
      }
    });
  }

  /**
   * Method to get the value of the type field of the form
   *
   * @author ingalexandrasarmiento
   * @returns AbstractControl
   */
  public get type(): AbstractControl {
    return this.formFilterData.get('type');
  }

  /**
   * Method to get the value of the serial field of the form
   *
   * @author ingalexandrasarmiento
   * @returns AbstractControl
   */
  public get serial(): AbstractControl {
    return this.formFilterData.get('serial');
  }

  /**
   * Method to get the value of the purchase date field of the form
   *
   * @author ingalexandrasarmiento
   * @returns AbstractControl
   */
  public get purchaseDate(): AbstractControl {
    return this.formFilterData.get('purchaseDate');
  }

  /**
   * Method to filter the list of fixed assets
   *
   * @author ingalexandrasarmiento
   */
  public applyFilter(): void {
    this.spinner.show();
    this.showCleanFilterButton = true;
    this.filter = {
      type: this.type.value > 0 ? this.type.value : null,
      serialNumber: this.serial.value !== '' ? this.serial.value : null,
      purchaseDate: this.purchaseDate.value !== '' ? this.datePipe.transform(this.purchaseDate.value, 'yyyy-MM-dd') : null
    };
    this.getFixedAssetsList(this.filter);
  }

  /**
   * Method to clean the applied filter
   *
   * @author ingalexandrasarmiento
   */
  public cleanFilter(): void {
    this.initValues();
    this.getFixedAssetsList(this.filter);
    // Clean the form fields
    this.type.setValue(0);
    this.serial.setValue('');
    this.purchaseDate.setValue('');
  }

  /**
   * Method to obtain fixed assets based on the filter
   *
   * @author ingalexandrasarmiento
   * @param filter
   */
  public getFixedAssetsList(filter: IFilter): void {
    this.fixedAssetsService.searchByFilter(this.filter).subscribe(
      (response) => {
        if (Array.isArray(response.data) && response.data.length > 0) {
          this.fixedAssets = response.data;
        }
        this.spinner.hide();
      },
      (error) => {
        this.fixedAssets = [];
        this.spinner.hide();
        console.error(error);
      }
    );
  }

  /**
   * Method to return the type of asset
   *
   * @author ingalexandrasarmiento
   * @param idType
   * @returns string
   */
  public getType(idType: number): string {
    const value: ITypeFixedAsset = this.types.find(t => t.idTypeAsset === idType);
    return value ? value.name : '-';
  }

  /**
   * Method to return the name of the area
   *
   * @author ingalexandrasarmiento
   * @param idArea
   * @returns string
   */
  public getArea(idArea: number): string {
    const area: IArea = this.areas.find(a => a.idArea === idArea);
    if (area) {
      const city: ICity = this.cities.find(c => c.idCity === area.idCity);
      return city ? area.name.concat(' (').concat(city.name).concat(')') : '-';
    }

    return '-';
  }

  /**
   * Method to return the name of the person
   *
   * @author ingalexandrasarmiento
   * @param idPerson ID of the people
   * @returns string
   */
  public getPerson(idPerson: number): string {
    const value: IPerson = this.people.find(p => p.idPerson === idPerson);
    return value ? value.name : '-';
  }

  /**
   * Validate if the list of fixed assets has data
   *
   * @author ingalexandrasarmiento
   * @returns boolean
   */
  public isFixedAssetsListEmpty(): boolean {
    return this.fixedAssets.length > 0;
  }

}
