import {Component} from "@angular/core";
import {CoursesService} from "../courses.service";

@Component({
    selector: 'jhi-matlaboratoare',
    templateUrl: 'labs.component.html',

})
export class LabsComponent {

    constructor(private courseService: CoursesService) {
    }

    public uploadFile(evt: any): void {
        let file = evt.target.files[0];
        this.courseService.makeFileRequest('/api/upload/curs/a1s1pc', file).subscribe();
    }

}
