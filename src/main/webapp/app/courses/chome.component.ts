import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
    selector: 'jhi-chome',
    templateUrl: 'chome.component.html',

})
export class ChomeComponent implements OnInit {

    constructor(
        private route: ActivatedRoute,
        private router: Router
    ) {

    }

    ngOnInit() {
        // this.route.paramMap
        //     .switchMap((params: ParamMap) =>
        //         this.employeeService.find(parseInt(params.get('id'))))
        //     .subscribe((employee: Employee) => this.employee = employee);

    }

    back(): void {
        // this.router.navigate(['/mvc/employeeList']);
    }

}
