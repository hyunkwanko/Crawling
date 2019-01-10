// 모듈 코드
var client = require('cheerio-httpcli');
var urlType = require('url');

// URL과 파라미터
var url = "http://jpub.tistory.com";
var param = {};

// 다운로드
client.fetch(url, param, function(err, $, res){
    // 에러 체크
    if (err) { console.log("Error: ", err); return; }

    // 링크를 추출하여 표시
    // idx -> object들을 순차적으로 가져온다.
    $("a").each(function(idx){
        var text = $(this).text();
        var href = $(this).attr('href');
        if (!href) return;
        // 상대 경로를 절대 경로로 변환
        var href2 = urlType.resolve(url, href);
        // 결과를 표시
        console.log(text + ":" + href);
        console.log(" => " + href2 + "\n");
    });
});