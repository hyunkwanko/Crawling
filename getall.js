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