// 웹사이트의 타이틀을 표시하는 프로그램
var phantom = require('phantomjs');
phantom.casperPath = '/usr/local/lib/node_modules/casperjs';
phantom.injectJs(phantom.casperPath + "/bin/bootstrap.js");

var TARGET_URL = "http://jpub.tistory.com";

// CasperJS 객체 생성
var casper = require('casperjs').create();

// 웹사이트 열기
casper.start(TARGET_URL, function() {
    // 타이틀 출력
    this.echo(casper.getTitle());
});

// 처리 수행
casper.run();