import {Component} from "@angular/core";
import {Http, RequestOptions, Headers, URLSearchParams} from "@angular/http";
@Component({
    selector: 'jhi-materiale',
    templateUrl: 'Materiale.component.html',

})
export class MaterialeComponent{

    constructor(private http: Http){
        console.log("bla");
    }

    fileChange(event): void {
        let fileList: FileList = event.target.files;
        if(fileList.length > 0) {
            let file: File = fileList[0];
            let formData: FormData = new FormData();
            formData.append('uploadFile', file, file.name);
            let headers = new Headers();
            headers.append('Accept', 'application/json');
            let options = new RequestOptions({headers: headers});
            let params = new URLSearchParams();
            options.params = params;
            options.headers = headers;
            let obj = {
                'id': null,
                'name': file.name,
                'idCurs': 'a2s2cn1',
                'idUser': 4,
                'activated': false,
                'type': 'cursuri',
                'file': formData
            };
            this.http.post('/api/materiale/upload', formData).subscribe();
        }
    }

}
