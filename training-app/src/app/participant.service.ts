import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Participants } from './Participants';

@Injectable({
  providedIn: 'root'
})
export class ParticipantService {
  rootURL:String

  constructor(private httpsvc:HttpClient) {
    this.rootURL="http://localhost:9901/participant"
   }
   getParticipants():Observable<Participants[]>{
    return this.httpsvc.get<Participants[]>(this.rootURL+"/list")

  }

  addNewParticipant(newParticipant:Participants):Observable<Participants>{
    const http0pts ={
      headers: new HttpHeaders(
        {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'})
      }
      var reqBody="name="+newParticipant.name
      
      return this.httpsvc.post<Participants>(
        this.rootURL+"/add",reqBody,http0pts)
      }

      deleteParticipant(ParticipantId:number):Observable<Participants>{
        return this.httpsvc.request<Participants>('DELETE', this.rootURL+"/delete",
        {
          headers: new HttpHeaders({'Content-Type' : 'text/plain'}), 
        body: ParticipantId
       })
      }
     }
 