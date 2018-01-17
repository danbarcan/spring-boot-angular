import {Component} from "@angular/core";
import {CoursesService} from "../courses.service";
import {ActivatedRoute} from "@angular/router";
import {Principal} from "../../shared/auth/principal.service";

@Component({
    selector: 'jhi-matcursuri',
    templateUrl: 'courses.component.html',

})
export class CoursesComponent {

    public cid: string;
    public course: String;
    public filen : any;
    public files: any[];
    public years: any[];

    constructor( private courseService: CoursesService,
                 private route: ActivatedRoute){
        this.years = [{year: '2015'},{year: '2016'},{year: '2017'},{year: '2018'}];
        this.route.params.subscribe((params) => {
            this.cid = params['cid'];
            this.courseService.find(this.cid).subscribe((x) => this.course = x);
            this.courseService.getMCourses(this.cid).subscribe((x) => this.files = x);
        });
    }

    public changeFile(evt: any): void{
        this.filen = evt.target.files[0];
    }

    public getFileName(file): string{
        let name = file.path.split('/');
        return name[name.length-1];
    }

    public uploadFile(year): void {
        this.courseService.makeFileRequest('/api/upload/curs/'+this.cid +'/'+year, this.filen).subscribe();
        this.filen = null;
    }

    public show(year): void{
        year.show = year.show?false:true;
    }

}
