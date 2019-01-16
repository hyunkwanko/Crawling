# Crawling

Nodejs를 통한 Web Crawling

> sudo vim Shell.sh

~~~
    # !/bin/sh

    # PATH 설정
    PATH=/usr/local/bin:/usr/bin:/bin
    NODE_PATH=/path/node_modules

    # 현재 디렉토리를 스크립트의 경로로 변경
    cd `dirname $0`
    # node 프로그램 실행
    node Crawling/kawase-usd_krw.js
~~~

> sudo crontab -e

```

    * * * * * /path/Shell.sh
```