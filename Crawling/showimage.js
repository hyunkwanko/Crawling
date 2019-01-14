// 모듈 코드
var client = require('cheerio-httpcli');
var urlType = require('url');

// URL과 파라미터
var url = "https://ko.wikipedia.org/wiki/" + encodeURIComponent("강아지");
var param = {};

// 다운로드
client.fetch(url, param, function(err, $, res){
    // 에러 체크
    if (err) { console.log("Error: ", err); return; }

    // 링크를 추출하여 표시
    // idx -> object들을 순차적으로 가져온다.
    $("img").each(function(idx){
        var src = $(this).attr('src');
        src = urlType.resolve(url, src);
        // 결과를 표시
        console.log(src);
    });
});