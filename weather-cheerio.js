// 기상 RSS

var RSS = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2629053000";

// 모듈 로드
var client = require('cheerio-httpcli');

// RSS 다운로드
client.fetch(RSS, {}, function(err, $, res){
    if (err) { console.log("error"); return; }
    // 필요한 항목을 추출해서 표시
    var data = $("pubDate").text();
    var legion = $("category").text();
    console.log(data);
    $("data").each(function(){
        var hour = $(this).find('hour').text();
        var temp = $(this).find('temp').text();
        var wfKor = $(this).find('wfKor').text();
        
        console.log( legion + " " + hour + "시 " + temp + "도 " + wfKor );
    });
});