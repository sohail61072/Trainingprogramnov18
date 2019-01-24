import { Component, OnInit } from '@angular/core';
import { Participants } from '../participants';
import { ParticipantService } from '../participant.service';

@Component({
  selector: 'app-participant',
  templateUrl: './participant.component.html',
  styleUrls: ['./participant.component.css']
})
export class ParticipantComponent implements OnInit {
  participants:Participants[]

  constructor(private pService:ParticipantService) {
    this.participants=[]
   }

   addNewParticipant(newParticipant:Participants){
    this.pService.addNewParticipant(newParticipant).subscribe(
      res=>{
        this.pService.getParticipants().subscribe(
          res=>{ this.participants=res}
        )
      }
    )
  }
  deleteParticipant(index:number){
    this.pService.deleteParticipant(index).subscribe(
      res =>{ this.pService.getParticipants().subscribe(
       res=>{ this.participants=res}
    )
    }
    )
   }
  

  ngOnInit() {
    this.pService.getParticipants().subscribe(
      res => {this.participants=res}
    )
  }
}
