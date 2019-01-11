// 모듈 로드
var client = require('cheerio-httpcli');
var request = require('request');
var fs = require('fs');
var urlType = require('url');

// console.log(__dirname); // 현재 디렉토리 경로
// console.log(__filename); // 현재 파일까지의 경로


// 저장할 디렉터리가 없으면 생성
var savedir = __dirname + "/img";

// // URL 지정
// var url = "http://jpub.tistory.com/";
// var savepath = "test.html";

// // 다운로드
// request(url).pipe(fs.createWriteStream(savepath));
