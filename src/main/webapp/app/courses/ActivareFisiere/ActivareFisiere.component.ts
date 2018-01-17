import {Component} from "@angular/core";
import {CoursesService} from "../courses.service";
import {Principal} from "../../shared/auth/principal.service";

@Component({
    selector: 'jhi-activareF',
    templateUrl: 'ActivareFisiere.component.html',

})
export class ActivareFisiereComponent{

    public fisiereC: any[];
    public fisiereL: any[];
    public fisiereE: any[];
    public fisiereP: any[];

    constructor( private courseService: CoursesService,
                 private principal: Principal){

        this.courseService.getFromURL('api/curs/getfilesNA').subscribe((x) =>{
            this.fisiereC = x;
        });
        this.courseService.getFromURL('api/labs/getfilesNA').subscribe((y) =>{
            this.fisiereL = y;
        });
        this.courseService.getFromURL('api/exams/getfilesNA').subscribe((z) =>{
            this.fisiereE = z;
        });
        this.courseService.getFromURL('api/p/getfilesNA').subscribe((x) =>{
            this.fisiereP = x;
        });
    }

    public getFileName(file): string{
        let name = file.path.split('/');
        return name[name.length-1];
    }

    public activateMC(file){
        this.courseService.save('api/activate/matCursuri',file);
        this.fisiereC.splice(this.fisiereC.findIndex(file),1);
    }

    public activateML(file){
        this.courseService.save('api/activate/matLab',file);
        this.fisiereL.splice(this.fisiereL.findIndex(file),1);
    }

    public activateME(file){
        this.courseService.save('api/activate/matExam',file);
        this.fisiereE.splice(this.fisiereE.findIndex(file),1);

    }
    public activateP(file){
        this.courseService.save('api//activate/probFile',file);
        this.fisiereP.splice(this.fisiereP.findIndex(file),1);
    }

    trackByFn(index, item) {
        return index;
    }


}
