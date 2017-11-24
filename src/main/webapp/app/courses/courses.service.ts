import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class CoursesService {
    private resourceUrl = 'api/cursuri';

    constructor(private http: Http) {
    }

    find(courseId: number): Observable<String> {
        return this.http.get(this.resourceUrl + '/' + courseId ).map( (c) => c.json().name);
    }

    getRProf(courseId: number): Observable<any> {
        return this.http.get('api/ranking_prof/' + courseId ).map( (c) => c.json());
    }

    getRAsis(courseId: number): Observable<String> {
        return this.http.get('api/ranking_ast/' + courseId ).map( (c) => c.json());
    }

}
