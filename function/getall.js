// 링크를 분석해서 다운로드(Node.js)
// --- 모듈 로드 ---
var client = require('cheerio-httpcli');
var request = require('request');
var urlType = require('url');
var fs = require('fs');
var path = require('path');

// --- 공통 설정 ---
// 링크 탐색 단계 지정
var LINK_LEVEL = 3;
// 기준 URL 지정
var TARGET_URL = "https://nodejs.org/docs/latest-v0.10.x/api/";
var list = {};

// 메인 처리
downloadRec(TARGET_URL, 0);

// 지정 URL을 최대 level 단계가지 다운로드
function downloadRec(url, level){
    // 최대 level 확인
    if (level >= LINK_LEVEL)
        return;
    
    // 이미 다운받은 사이트는 무시
    if (list[url])
        return;
    list[url] = true;

    // 외부 페이지는 무시
    var us = TARGET_URL.split("/");     // '/'를 기준으로 split해서 배열로 저장
    // console.log(us);
    us.pop();                           // 배열의 제일 마지막 인덱스 제거
    var base = us.join("/");            // '/'를 기준으로 url 생성
    // console.log(base);
    // console.log(url.indexOf(base));     // url 안에 base 문자열이 포함되어 있는지 체크해서 0 또는 -1을 반환 -> 0 : true
    if (url.indexOf(base) < 0)
        return;

    // HTML을 취득
    client.fetch(url, {}, function(err, $, res){
        // 링크된 페이지를 취득
        $("a").each(function(idx){
            // <a> 태그의 링크를 획득
            var href = $(this).attr('href');
            if (!href)
                return;

            // 상대 경로를 절대 경로로 변환
            href = urlType.resolve(url, href);

            // '#' 이후를 무시(a.html#aa와 a.html#bb는 같다)
            href = href.replace(/\#.+$/, ""); // 말미의 #를 제거
            downloadRec(href, level + 1);
        });

        // 페이지 저장(파일명 지정)
        console.log(url.substr(url.length-1, 1));
        if (url.substr(url.length-1, 1) == '/') {               // 제일 마지막 문자 추출 -> substr(시작 위치, 추출 길이)
            url += "index.html"; // 인덱스 자동 추가
        }

        var savepath = url.split("/").slice(2).join("/");       // 배열에서 세 번째것부터 가져온다.
        checkSaveDir(savepath);
        // console.log(savepath);
        // fs.writeFileSync(savepath, $.html());
    });
}

// 저장할 디렉터리 존재 유무 확인
function checkSaveDir(fname) {
    // 디렉터리 부분만 검출
    var dir = path.dirname(fname);
    // console.log(dir);

    // 디렉터리를 재귀적으로 생성
    var dirlist = dir.split("/");
    var p = "";
    for (var i in dirlist) {
        p += dirlist[i] + "/";
        if (!fs.existsSync(p)) {
            fs.mkdirSync(p);
        }
    }
}