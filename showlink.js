// 모듈 코드
var client = require('cheerio-httpcli');

// 다운로드
var url = "http://jpub.tistory.com";
var param = {};

client.fetch(url, param, function(err, $, res){
    // 에러 체크
    if (err) { console.log("Error: ", err); return; }

    // 링크를 추출하여 표시
    // idx -> object들을 순차적으로 가져온다.
    $("a").each(function(idx){
        var text = $(this).text();
        var href = $(this).attr('href');
        console.log(text + ":" + href);
    });
});