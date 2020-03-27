

# API – client facing   
1)	getAppConfig
2)	login 
3)	renewToken
4)	getPrimeContent
5)	getHotTopicStatatics
6)	getStockNews
7)	getTechnologyNews
8)	getHealthContent

# API – admin  - This can be developed later
1)	updateConf
2)	getConf
3)	Clear cache
4)	Update content feed [promo/custom content]

# Technology stack
1)	Spring boot
2)	Cassandra
3)	Android /Iphon app – Reactive native/Flutter

# Deployment
1)	Google /AWS /Azur /? – hosting solution
2)	Doker – Containerization 
3)	Jenkins – build & deploy
4)	Edge Cache [Akamai ?]  - cache solution ttl can be 30 mnts, this way our application server will only get 1 call/30 mnts.

# DB design [Cassandra/mysql]

TABLE 0 [app_conf] – This will be populated based on third party login like FB, google and twitter
1)	Id
2)	Promo_enabled
3)	App_menu_list
4)	Auth_required

TABLE 1 [user_profile] – This will be populated based on third party login like FB, google and twitter
1)	Id
2)	Email_id
3)	Name
4)	Dob

TABLE 2 [location_keyword_mapping] – Need to consider this before hitting news API. E.g if you have 2 keyword for a location, we need to fire news api 2 times and combine the result.
1)	Id
2)	Location
3)	keyword
4)	Status[enable/disabled]

TABLE 3 [source_filter] – News Api response will be parsed based on the enabled source
1)	Id
3)	Source_name
2)      Source_logo
4)	Status[enabled/disabled]

TABLE 4 [content_feed] – The main table which contain all different types on news
1)	Id
2)	Content_type [NEWS/TECH/STOCK/PROMO/BLOG]
3)	Keyword
4)	Source_name
5)	Source_logo_url
6)	Link_to_source
7)	Title
8)	Content
9)	Content_image_url
10)	Content_video_link
11)	Published_time

# API Design

1) getAppConfig
    
    response : {
	    "authRequired": "true",
	    "menuList": ["News", "Corona", "Stock", "Technology"]
    }
2) login  - Ganesh todo
3) renewToken - Ganesh todo
4) getPrimeContent 
     
     resonse : {
	"content": [{
		"sequenceNo": "sorting number",
		"sourceName": "source name",
		"sourceLogo": "image path",
		"sourceLink": "link to the actual source",
		"content": "The content",
		"contentType": " content type e.g news/promo/blog etc",
		"contentImage": "content image if any",
		"contentVideo": " content video if any",
		"publishedTime": " published date and time"
	}]
     }

# Wireframes

![Home](/Home.png)
![Corona](/Corona.png)
![My Account](/Account.png)

# API details/ functionality

![appConfig Response](/appConfigAPI.png)
![primeCOntent Response](/primeContentAPI.png)

 When user install the app and open the app first thing is we need to capture the location ie city, state & country. 
 Then make call to “getAppConfig” which will return a menu list. We need to include this client id in further Api request

getAppConfig?city=’plano’&state=’texas’&country=’US’ – this has to be called every time when they open/refresh the app.


{
   "menuList":[
      {
         "displayName":"Home",
         "keyword":""
      
},
      {
         "displayName":"Health",
         "keyword":"health"
      
},
      {
         "displayName":"Stock",
         "keyword":"stock"
      
},
      {
         "displayName":"Me",
         "keyword":""
      
}
   
],
   "subMenu":{
      "home":[
         {
            "displayName":"Local",
            "keyword":"plano"
         
},
         {
            "displayName":"US",
            "keyword":"US"
         
},
         {
            "displayName":"World",
            "keyword":"world"
         
},
         {
            "displayName":"corona",
            "keyword":"corona",
            "webUrl":"http://mediaurl/corona"
         
}
      
]
   
}
}

Note : If a category has a web url then that url content should load in the page instead of hitting “getPrimeContent” Api.
Below api call should trigger as soon as user land on home screen/or when they click on appropriate category who do not have a weburl.


getPrimeContent?keyword=’plano’ – as soon as user land on home page
getPrimeContent?keyword=’us’ – when user click on ‘us’ link 
getPrimeContent?keyword=’world’ – when user click on ‘world’ link
getPrimeContent?keyword=’coronoa’ – when user click on ‘corona’ link
getPrimeContent?keyword=’technology’ – when user click on ’technology’ link
getPrimeContent?keyword=’stock’ – when user click on ‘stock’ link
getPrimeContent?keyword=’health’ – when user click on ‘health’ link

Please find the response below
{
	"content": [{
		"sequenceNo": "sorting number",
		"sourceName": "source name",
		"sourceLogo": "image path",
		"sourceLink": "link to the actual source",
		"content": "The content",
		"contentType": " content type e.g news/promo/blog etc",
		"contentImage": "content image if any",
		"contentVideo": " content video if any",
		"publishedTime": " published date and time",
	    	"sharableLink" : "content sharing link via mail, message etc"
	}]
}

Note: Each content should be able to share true watzap/message/mail if there is a sharable link attached in the content response
Me : As of now, in this page show the location that we captured through the location service, in case If they wanted to edit , they should be able to do it on this screen.
