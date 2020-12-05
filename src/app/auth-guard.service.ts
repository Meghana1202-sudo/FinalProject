import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthGuardService {

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const expectedRoleArray = route.data.roles;
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    let expectedRole: string;
    for (const index in expectedRoleArray) {
        if (userDetails && userDetails.role === expectedRoleArray[index]) {
            expectedRole = expectedRoleArray[index];
        }
    }
    if (userDetails && expectedRole === userDetails.role) {
        console.log('user authenticated');
        return true;
    } else {
        console.log('not authenticated');
        return false;
    }
}

}
