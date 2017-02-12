# jShodan
[ ![Download](https://api.bintray.com/packages/fooock/maven/jShodan/images/download.svg) ](https://bintray.com/fooock/maven/jShodan/_latestVersion)
Powerfull Shodan client written using RxJava and Retrofit. You can integrate this client into existing apps or create new one. With this Shodan client you can:
* Search Shodan
* Exploit search
* Streaming API to consume Shodan data in real time (in development)

## Installation
If you use gradle sdd to your build.gradle
```
repositories {
    jcenter()
}
```
And in your dependencies block add this line
```
compile 'com.fooock:jshodan:0.4.3'
```
or if you are using maven add to you pom.xml
```
<dependency>
  <groupId>com.fooock</groupId>
  <artifactId>jshodan</artifactId>
  <version>0.4.3</version>
  <type>pom</type>
</dependency>
```
## Getting started
You need an API key to use this client. You can do this in [Shodan.io](http://shodan.io) 
* **Rest API**
```
ShodanRestApi api = new ShodanRestApi("your api key here");
```
A simple example of query Shodan with facet info. Note that executing this query consumes 1 query credit
```
api.hostSearch("port:8333", "bitcoin.ip:10,city:10")
    .subscribe(new Subscriber<HostReport>() {
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
```
int total = hostReport.getTotal();
List<Banner> banners = hostReport.getBanners();
FacetReport facet = hostReport.getFacet();
```
You can use other method calls from the rest API. See the [ApiService](https://github.com/fooock/jshodan/blob/master/src/main/java/com/fooock/shodan/ApiService.java) class for a complete list.

* **Exploit API**
Use this API to search for exploits from multiple data sources like Exploit DB, Metasploit and CVE. The use of this API is very simply and similar to the previous
```
ShodanExploitApi api = new ShodanExploitApi("your api key here");
```
A simple example
```
api.search("ssl", "type")
    .subscribe(new Subscriber<ExploitReport>() {
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
```
ShodanStreamingApi api = new ShodanStreamingApi("your api key here");
```
Example to get all data that Shodan collects
```
api.banners()
    .subscribe(new Subscriber<BannerReport>() {
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

## Android support
If your plan is to create a new Android app using this, you need to add this dependency
```
compile 'io.reactivex.rxjava2:rxandroid:x.y.z'
```

Enjoy it!
### Roadmap
1. Testing
2. Documentation
3. Better readme with more examples

### Links
* [Shodan.io](http://shodan.io)
* [API Documentation](https://developer.shodan.io/api)
