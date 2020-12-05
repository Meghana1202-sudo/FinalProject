import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


const headeroption = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  selectedLoans(selectedLoans: any) {
    throw new Error('Method not implemented.');
  }
  deleteLoans(id: any) {
  }
  constructor(private http: HttpClient) { }

  registerUser(user): Observable<any> {
    return this.http.post('http://localhost:8080/register', user);
  }
 
  loginUser(user): Observable<any> {
    console.log(user)
    return this.http.post('http://localhost:8080/login',user);
  }

  AddCust(customer): Observable<any> {
    console.log(customer)
    return this.http.post('http://localhost:8080/add-customer',customer);
  }

  AddCustReq(applicationId): Observable<any> {
    return this.http.put<any>(`http://localhost:8080/add-req/${applicationId}`,null)
  }
  AddCustDecl(applicationId): Observable<any> {
    return this.http.put(`http://localhost:8080/del-req/${applicationId}`,null);
  }
  getAllcust() {

    return this.http.get<any>('http://localhost:8080/getallcustomer');
  }
  deletecust(applicationId) {
    return this.http.delete<any>(`http://localhost:8080/delete-customer?applicationId=${applicationId}`);
 
  }
  
  addLoanType(type) {
    return this.http.post<any>('http://localhost:8080/add-loan', type);

  }
  addForm(details){
    return this.http.post<any>('http://localhost:8080/add-formstatus', details);
    
  }
  DeleteReq(data):Observable<any>{
    return this.http.post(`http://localhost:8080/declinereq`,data,headeroption);

  }

  setdate(data):Observable<any>{
    return this.http.post(`http://localhost:8080/setdate`,data ,headeroption);

  }
  requestcust(applicationId,data):Observable<any> {
    return this.http.post(`http://localhost:8080/allocated/${applicationId}`,data,headeroption);

  }

  acceptReq(data):Observable<any>{
    return this.http.post(`http://localhost:8080/acceptreq`,data,headeroption);

  }
  declineReq(applicationId,data):Observable<any> {
    return this.http.post(`http://localhost:8080/loanaction/${applicationId}`,data,headeroption);

  }
  custRequests():Observable<any> {
    return this.http.get(`http://localhost:8080/viewreqs`,headeroption);

  }
  
  getAllFormStatus() {
    return this.http.get<any>('http://localhost:8080/get-allformstatus');
  }
  getAllType() {
    return this.http.get<any>('http://localhost:8080/get-alltype');
  }
  deleteLoansType(id){
    return this.http.delete<any>(`http://localhost:8080/delete-loanType?id=${id}`);
  }
  updateLoanType(type) {
    return this.http.put<any>('http://localhost:8080/update-type',type);
  }

  changePassword(user): Observable<any> {
    return this.http.post<any>('http://localhost:8080/changepass', user);
  }
  inbox(): Observable<any> {
    const user = JSON.parse(localStorage.getItem('user'));
    console.log(user[0].id);
    return this.http.get<any>(`http://localhost:8081/inbox?to_id=${user[0].id}`);
  }

}
