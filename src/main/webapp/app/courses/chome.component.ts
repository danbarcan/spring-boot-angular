import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CoursesService} from './courses.service';

@Component({
    selector: 'jhi-chome',
    templateUrl: 'chome.component.html',

})
export class ChomeComponent implements OnInit {

    course: String;
    constructor(
        private route: ActivatedRoute,
        private courseService: CoursesService
    ) {

    }

    ngOnInit() {
        this.route.params.subscribe((params) => {
            this.courseService.find(params['cid']).subscribe((x) => this.course = x);
            this.courseService.getRAsis(params['cid']).subscribe((x) => console.log(x));
            this.courseService.getRProf(params['cid']).subscribe((x) => console.log(x)); });
        console.log(this.course);

    }

}
