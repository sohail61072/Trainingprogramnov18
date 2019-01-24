import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ParticipantComponent } from './participant/participant.component';
import { TrainingComponent } from './training/training.component';

const routes: Routes = [
  {path:'',component:TrainingComponent},
  {path:'participants', component:ParticipantComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
