import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { ServiceComponent } from './service/service.component';
import { HomeComponent } from './home/home.component';
import { FilterPipe } from './filter.pipe';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Route, RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AddLoanTypeComponent } from './add-loan-type/add-loan-type.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { FormstatusComponent } from './formstatus/formstatus.component';
import { LogoutComponent } from './logout/logout.component';
import { MakeloanComponent } from './makeloan/makeloan.component';
import { ViewListLoanComponent } from './view-list-loan/view-list-loan.component';
import { ViewloansComponent } from './viewloans/viewloans.component';
import { ViewstatusComponent } from './viewstatus/viewstatus.component';
import { NewsComponent } from './news/news.component';

const routes:Route[]=[
  {path:'home',component:HomeComponent},
  {path: 'aboutus', component: AboutusComponent},
  {path: 'contactus', component: ContactusComponent},
  {path: 'home', component : HomeComponent},
  {path: 'service', component: ServiceComponent},
  {path :'register', component: RegisterComponent} ,
  {path : 'login', component : LoginComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'addloantype', component: AddLoanTypeComponent},
  {path: 'changepassword', component: ChangepasswordComponent},
  {path: 'formstatus', component: FormstatusComponent},
  {path: 'makeloan', component : MakeloanComponent},
  {path: 'viewlistloan', component : ViewListLoanComponent},
  {path: 'viewloans', component : ViewloansComponent},
  {path: 'viewstatus', component : ViewstatusComponent},
  {path : 'news', component: NewsComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AboutusComponent,
    ContactusComponent,
    ServiceComponent,
    HomeComponent,
    FilterPipe,
    RegisterComponent,
    LoginComponent,
    AdminComponent,
    AddLoanTypeComponent,
    ChangepasswordComponent,
    FormstatusComponent,
    LogoutComponent,
    MakeloanComponent,
    ViewListLoanComponent,
    ViewloansComponent,
    ViewstatusComponent,
    NewsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
