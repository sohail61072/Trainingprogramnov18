import { Component, OnInit } from '@angular/core';
import { TrainingService } from '../training.service';
import { Trainings } from '../trainings';
import { Participants } from '../participants';
import { ParticipantComponent } from '../participant/participant.component';

@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.css']
})
export class TrainingComponent implements OnInit {
  trainings:Trainings[]
  participants:Participants[]

  constructor(private tService:TrainingService) {
    this.trainings=[]
    this.participants=[]
   }

   addNewTraining(newTraining:Trainings){
    this.tService.addNewTraining(newTraining).subscribe(
      res=>{
        this.tService.getTrainings().subscribe(
          res=>{ this.trainings=res}
        )
      }
    )
  }
  deleteTraining(index:number){
    this.tService.deleteTraining(index).subscribe(
      res =>{ this.tService.getTrainings().subscribe(
       res=>{ this.trainings=res}
    )
    }
    )
   }
          addNewParticipantToTraining(newAssignment:Trainings){
     this.tService.addNewParticipantToTraining(newAssignment).subscribe(
       res=>{
         this.tService.getTrainings().subscribe(
           res=>{this.trainings=res}
         )
       }
     )
   }
  
   getTrainingParticipants(trainingId:number){
    this.tService.getTrainingParticipants(trainingId).subscribe(
      res=> {this.participants=res})
  }


  ngOnInit() {
    this.tService.getTrainings().subscribe(
      res => {this.trainings=res}
    )
  }

  
}

