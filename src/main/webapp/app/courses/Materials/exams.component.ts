import {Component} from "@angular/core";
import {CoursesService} from "../courses.service";

@Component({
    selector: 'jhi-matexamene',
    templateUrl: 'exams.component.html',

})
export class ExamsComponent {

    constructor(private courseService: CoursesService) {
    }

    public uploadFile(evt: any): void {
        let file = evt.target.files[0];
        this.courseService.makeFileRequest('/api/upload/exam/a1s1pc', file).subscribe();
    }

}
