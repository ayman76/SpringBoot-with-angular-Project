import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent {

  CustomerArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;
  
  name: string ="";
  address: string ="";
  mobile: string ="";
  customerID = "";

  
  constructor(private http: HttpClient)
  {
    this.getAllCustomer();
  }

  getAllCustomer(){
    this.http.get("http://localhost:8080/customer")
    .subscribe((resultData: any) => {
      this.isResultLoaded = true;
      console.log(resultData);
      this.CustomerArray = resultData;
    });
  }

  insert(){
    let bodyData = {
      "name": this.name,
      "address": this.address,
      "mobile": this.mobile
    };

    this.http.post("http://localhost:8080/customer", bodyData, {responseType: 'text'})
    .subscribe((resultData: any) => {
      console.log(resultData);
      alert("Customer Added Successfully");
      this.getAllCustomer();

      this.name = '';
      this.address = '';
      this.mobile = '';
    });
  }


  setUpdate(data: any){
    this.name = data.name;
    this.address = data.address;
    this.mobile = data.mobile;
    this.customerID = data.id;
  }

  updateRecords(){
    let bodyData = {
      "id": this.customerID,
      "name": this.name,
      "address": this.address,
      "mobile": this.mobile
    };

    this.http.put("http://localhost:8080/customer", bodyData, {responseType: "text"})
    .subscribe((resultData: any) => {
      
      console.log(resultData);
      alert("Customer Updated");
      this.getAllCustomer();
      this.name = '';
      this.address = '';
      this.mobile = ''
    });
  }

  save(){
    if(this.customerID == ''){
      this.insert();
    }
    else{
      this.updateRecords();
    }
  }

  setDelete(data : any){
    this.http.delete("http://localhost:8080/customer"+"/" + data.id, {responseType: "text"})
    .subscribe((resultData: any) => {
      console.log(resultData);
      alert("Customer Deleted");
      this.getAllCustomer();

      this.name = '';
      this.address = '';
      this.mobile = '';
    });
  }

}
