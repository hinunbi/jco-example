# 100줄로 완성하는 웹 서비스 플랫폼
14회 JCO 발료에 사용된 프로그램 소스입니다.


## 프로젝트 다운로드

    git clone https://github.com/hinunbi/jco-example.git

## 프로젝트 빌드

    mvn compile

## 프로젝트 실행

    mvn camel:run
    
## 프로젝트 테스트
본 프로젝트는 테스트를 위해 별도의 클라이언트 프로그램을 개발하지 않고 웹 서비스 테스트 개발자 도구인 FireFox [Poster](https://addons.mozilla.org/ko/firefox/addon/poster/) 확장을 이용합니다. 


### 1. HelloService 테스트
HelloService는 서비스가 정상적으로 동작되는지를 확인하는 기본 웹 서비스입니다.

1) Firefox에서 Poster 팝업창을 실행한 후, 입력 필드에 다음과 같은 정보를 입력하고 POST 버튼을 누릅니다.
```
	URL : http://localhost:8080/HelloService  
	Content Type : application/json
	Content : {name : "홍길동"}
```    
2) Poster 응답이 다음과 같으면 웹 서비스가 정상적으로 동작한 것입니다.
```
    {"status":"ServiceOk","reply":"Hello, 홍길동"}
```    

### 2. TwitterService 테스트
TwitterService는 트윗을 전송하는 웹 서비스입니다.

1) TwitterService를 테스트 하기 위해서는 반드시 다음 준비 작업이 테스트 전에 필요합니다. 

   * 트위터 웹 서비스에서 트윗에 사용할 트위터 애플리케이션을 [트위터 개발자 사이트](https://apps.twitter.com/app/new)에 등록해야 합니다. 
   * 트위터 개발자 사이트에서 발급받은 애플리케이션 정보로 [camel-context.xml](src/main/resources/META-INF/spring/camel-context.xml)의 twitter 빈의 속성 값들을 수정해야 합니다. 
   * 다음 부분이 camel-context.xml에서 수정해야 할 트위터 애플리케이션의 정보입니다.

```xml
...
<bean id="twitter" class="org.apache.camel.component.twitter.TwitterComponent">
	<property name="consumerKey" value="rsv2EAY6Zqq5ikm2tUmHg" />
	<property name="consumerSecret" value="l2h8YOB1uEK7LJ8lIypPOJTMAjWfuAiO1k601hgKaTs" />
	<property name="accessToken" value="548573273-yp6busuob3qVrd3nKSZi5XjEQa0pbLULoXNxguVd" />
	<property name="accessTokenSecret" value="SpOEXlFIcZseVBeqitKsLjoCwArOYCZ65hhdi4G4x0" />
</bean>
...
```

주의) *위 속성 값들로는 트윗 테스트가 되지 않습니다. 반드시 발급받은 정보로 대체해야 합니다.*

2) Poster 입력 필드에 다음 정보를 입력하고 POST 버튼을 누릅니다.

```
    URL : http://localhost:8080/TwitterService
    Content Type : application/json
    Content : {tweet : "트윗 테스트입이다."} 
```

3) Poster 응답이 다음과 같으면 트위터 서비스가 정상적으로 동작한 것입니다. 
    
```
    {"status":"ServiceOk","reply":"Sent the tweet, [트윗 테스트입이다. at Thu Feb 20 11:28:05 KST 2014]"}
```

4) 트위터 앱이나 웹에서 트윗을 확인합니다.

## 참고

* 기술 문의 : [바른모](mailto:info@barunmo.com) 
