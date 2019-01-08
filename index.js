var cheerio = require('cheerio');
var request = require('request');

var url = 'http://www.melon.com/chart/';
 
request(url, function(error, response, html){
    // console.log(html);
    var $ = cheerio.load(html);
})