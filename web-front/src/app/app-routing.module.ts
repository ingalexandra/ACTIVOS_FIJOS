import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FixedAssetListComponent } from './components/fixed-asset-list/fixed-asset-list.component';

const routes: Routes = [
  { path: '', component: FixedAssetListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
