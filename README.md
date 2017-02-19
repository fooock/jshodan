# jShodan
[ ![Download](https://api.bintray.com/packages/fooock/maven/jShodan/images/download.svg) ](https://bintray.com/fooock/maven/jShodan/_latestVersion)

Powerful Shodan client written using RxJava and Retrofit. You can integrate this client into existing apps or create new one. With this Shodan client you can:
* Search Shodan
* Exploit search
* Streaming API to consume Shodan data in real time (in development)

## Installation
If you use gradle add to your build.gradle
```
repositories {
    jcenter()
}
```
Also you can use maven central
```
repositories {
    mavenCentral()
}
```
And in your dependencies block add this line
```
compile 'com.fooock:jshodan:0.4.5'
```
or if you are using maven add to you pom.xml
```
<dependency>
  <groupId>com.fooock</groupId>
  <artifactId>jshodan</artifactId>
  <version>0.4.5</version>
  <type>pom</type>
</dependency>
```
## Getting started
You need an API key to use this client. You can do this in [Shodan.io](http://shodan.io) 
* **Rest API**
```java
ShodanRestApi api = new ShodanRestApi("your api key here");
```
A simple example of query Shodan with facet info. Note that executing this query **consumes 1 query credit**
```java
api.hostSearch("port:8333", "bitcoin.ip:10,city:10")
    .subscribe(new DisposableObserver<HostReport>() {
        @Override
        public void onCompleted() {
            // called when the request is completed
        }

        @Override
        public void onError(Throwable e) {
            // called if an error occurs
        }

        @Override
        public void onNext(HostReport hostReport) {
            // result of the query
        }
});
```
The result of this, if success, is an object ```HostReport``` that contains all info.
```java
int total = hostReport.getTotal();
List<Banner> banners = hostReport.getBanners();
FacetReport facet = hostReport.getFacet();
```
You can use other method calls from the rest API. See the [ApiService](https://github.com/fooock/jshodan/blob/master/src/main/java/com/fooock/shodan/ApiService.java) class for a complete list.

* **Exploit API**
Use this API to search for exploits from multiple data sources like Exploit DB, Metasploit and CVE. The use of this API is very simply and similar to the previous
```java
ShodanExploitApi api = new ShodanExploitApi("your api key here");
```
A simple example
```java
api.search("ssl", "type")
    .subscribe(new DisposableObserver<ExploitReport>() {
        @Override
        public void onCompleted() {
            // called when the request is completed
        }

        @Override
        public void onError(Throwable e) {
            // called if an error occurs
        }

        @Override
        public void onNext(ExploitReport exploitReport) {
            // result of the query
        }
});
```
The result of this call, if success, is ```ExploitReport``` class that contains all info

* **Streaming API**
This API returns a real-time stream of data collected by Shodan. 
```java
ShodanStreamingApi api = new ShodanStreamingApi("your api key here");
```
Example to get all data that Shodan collects
```java
api.banners()
    .subscribe(new DisposableObserver<BannerReport>() {
        @Override
        public void onCompleted() {
            // called when the request is completed
        }

        @Override
        public void onError(Throwable e) {
            // called if an error occurs
        }

        @Override
        public void onNext(BannerReport bannerReport) {
            // result of the query
        }
});
```
**Note:** To use the streaming API you need a Shodan subscription-based API plan. You can obtain it in [Shodan pricing](https://developer.shodan.io/billing/signup)

## Android support
If your plan is to create a new Android app using this, you need to add this dependency
```
compile 'io.reactivex.rxjava2:rxandroid:x.y.z'
```

## Dependencies
* [RxJava2](https://github.com/ReactiveX/RxJava) for its reactive-functional API
* [Retrofit](https://github.com/square/retrofit) HTTP client for Android and Java
* [Gson Retrofit converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) A converter wich uses Gson for serialization to and from JSON
* [RxJava2 adapter for Retrofit](https://github.com/square/retrofit/tree/master/retrofit-adapters/rxjava2) An adapter for rxJava2 types

Enjoy it!
### Roadmap
1. Testing
2. Documentation
3. Better readme with more examples

### Links
* [Shodan.io](http://shodan.io)
* [API Documentation](https://developer.shodan.io/api)
