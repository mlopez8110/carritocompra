import { Component, OnInit } from '@angular/core';
import { Venta } from '../venta';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';

@Component({
  selector: 'app-lista-venta',
  templateUrl: './lista-venta.component.html',
  styleUrls: ['./lista-venta.component.css']
})
export class ListaVentaComponent implements OnInit{

  VentatArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;
  cliente: string ="";
  fecha: string ="";
  total: string ="";

  constructor(private http: HttpClient, private router:Router ) 
  {
    this.getAllStudent();
  }

  ngOnInit(): void {

  }



  public getAllStudent()
  { 
    this.http.get("http://localhost:8085/api/v1/ventas")
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        //console.log(resultData.data);
        this.VentatArray = resultData.data;
    });
  }

}
