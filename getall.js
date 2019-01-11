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
    var us = TARGET_URL.split("/");
    us.pop();
    var base = us.join("/");
    if (url.indexOf(base) < 0)
        return;

    // HTML을 취득
}