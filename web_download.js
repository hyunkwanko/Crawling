// // url에 있는 파일을 savepath에 다운로드한다

// // 다운로드할 URL을 지정
// var url = "http://jpub.tistory.com/";
// // 저장할 위치를 지정
// var savepath = "test.html";

// // 사용 모듈 정의
// var http = require('http');     // HTTP 모듈
// var fs = require('fs');         // 파일 처리 관련 모듈

// // 출력 지정
// var outfile = fs.createWriteStream(savepath);

// // 비동기로 URL의 파일 다운로드
// http.get(url, function(res){
//     res.pipe(outfile);
//     res.on('end', function(){
//         outfile.close();
//         console.log("ok");
//     });
// });

download(
    "http://jpub.tistory.com/539",
    "spring.html",
    function(){
        console.log("ok, spring.");
    }
);

download(
    "http://jpub.tistory.com/537",
    "angular.html",
    function(){
        console.log("ok, angular.");
    }
);

// url의 파일을 savepath에 다운로드하는 함수

function download(url, savepath, callback){
    var http = require('http');
    var fs = require('fs');
    var outfile = fs.createWriteStream(savepath);

    var req = http.get(url, function(res){
        res.pipe(outfile);
        res.on('end', function(){
            outfile.close();
            callback();
        });
    });
}
