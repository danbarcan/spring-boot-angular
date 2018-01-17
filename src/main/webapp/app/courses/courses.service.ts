import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Observable, Observer} from 'rxjs/Rx';
import {Principal} from "../shared/auth/principal.service";

@Injectable()
export class CoursesService {
    private resourceUrl = 'api/cursuri';

    constructor(private http: Http, private principal: Principal) {
    }

    find(courseId: string): Observable<String> {
        return this.http.get(this.resourceUrl + '/' + courseId ).map( (c) => c.json().name);
    }

    getRProfURL(courseId: string): string {
        return 'api/ranking_prof/' + courseId;
    }

    getRAsisURL(courseId: string): string {
        return 'api/ranking_ast/' + courseId ;
    }

    getVoteAURL(courseId: string): string{
        return 'api/voteA/' + courseId;
    }
    getVotePURL(courseId: string): string{
        return 'api/voteP/' + courseId;
    }

    getProf(courseId: string): Observable<any> {
        return this.http.get('api/cprof/' + courseId ).map( (c) => c.json());
    }

    getAsis(courseId: string): Observable<any> {
        return this.http.get('api/casis/' + courseId ).map( (c) => c.json());
    }

    getFromURL(url: string): Observable<any> {
        return this.http.get(url).map( (c) => c.json());
    }

    hasVotedP(courseId: number, profId: number ): Observable<boolean> {
        return this.http.get('api/hasVotedP/' + courseId + '/' + profId ).map( (c) => c.json());
    }
    hasVotedA(courseId: number, profId: number ): Observable<boolean> {
        return this.http.get('api/hasVotedA/' + profId + '/' + courseId ).map( (c) => c.json());
    }

    vote(url: string){
        console.log("bla");
        this.principal.identity().then( (x) => {

            this.http.get(url + "/" + x.id).subscribe();
            console.log(url);
        });
    }

    getMCourses(courseId: string): Observable<any> {
        return this.http.get('api/mat_courses/' + courseId ).map( (c) => c.json());
    }

    getMLabs(courseId: string): Observable<any> {
        return this.http.get('api/m_labs/' + courseId ).map( (c) => c.json());
    }

    getMExams(courseId: string): Observable<any> {
        return this.http.get('api/m_exams/' + courseId ).map( (c) => c.json());
    }

    public makeFileRequest(url: string, file: File): Observable<string> {
        return Observable.create(
            (observer: Observer<string>) => {
                let formData: FormData = new FormData();

                formData.append('file', file, file.name);

                this.http.post(url, formData).subscribe();
            });
    }

    public delP(p: any){
        this.http.delete("api/delete/" + p.id).subscribe();
    }

    public saveParere(p: any){

        this.http.post("api/savePareri", p).subscribe();
    }

    public saveProblema(p :any){
        this.http.post("api/saveProblema", p).subscribe();
    }

}
