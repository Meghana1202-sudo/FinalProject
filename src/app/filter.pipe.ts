import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(Loans,search:string): any {
    
      if (!Loans) {
        return null;
      }
      if (!search) {
        return Loans;
      }
      return Loans.filter(function(item) {
        return JSON.stringify(item).toLowerCase().includes(search.toLowerCase());
      });
    }


}
