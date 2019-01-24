import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Trainings } from './trainings';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Participants } from './participants';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {
  rootURL:String

  constructor(private httpsvc:HttpClient) {
    this.rootURL="http://localhost:9901/training"
   }
   getTrainings():Observable<Trainings[]>{
    return this.httpsvc.get<Trainings[]>(this.rootURL+"/list")

  }

  addNewTraining(newTraining:Trainings):Observable<Trainings>{
    const http0pts ={
      headers: new HttpHeaders(
        {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'})
      }
      var reqBody="coursename="+newTraining.coursename+"&date="+newTraining.date+"&location="+newTraining.location

      return this.httpsvc.post<Trainings>(
        this.rootURL+"/add",reqBody,http0pts)
      }

      deleteTraining(trainingId:number):Observable<Trainings>{
        return this.httpsvc.request<Trainings>('DELETE', this.rootURL+"/delete",
        {
          headers: new HttpHeaders({'Content-Type' : 'text/plain'}), 
        body: trainingId
       })
      }
     
     
         addNewParticipantToTraining(newAssignment:Trainings):Observable<Trainings>{
      const http0pts ={
        headers: new HttpHeaders(
          {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'})
        }
        var reqBody="trainingId="+newAssignment.trainingId+"&participantId="+newAssignment.participantId
  
        return this.httpsvc.post<Trainings>(
          this.rootURL+"/assign",reqBody,http0pts)
        }

        getTrainingParticipants(trainingId:number):Observable<Participants[]>{
          return this.httpsvc.get<Participants[]>(this.rootURL+"/assigned?trainingId="+trainingId)
        }
      

      }

 