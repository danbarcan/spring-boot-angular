import {Component} from "@angular/core";
import {CoursesService} from "../courses.service";

@Component({
    selector: 'jhi-matcursuri',
    templateUrl: 'courses.component.html',

})
export class CoursesComponent {

    constructor(private courseService: CoursesService) {
    }

    public uploadFile(evt: any): void {
        let file = evt.target.files[0];
        this.courseService.makeFileRequest('/api/upload/curs/a1s1pc', file).subscribe();
    }

}
