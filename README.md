
Everflow-News Service
=============================

``` Java

Following things are implemented: 	
    a. Connect to an API to retrieve a news list
    b. Manage the news in a database
    c. Publish the solution in a Github repo
    d. (Optional) Use Redis to introduce a caching layer

Note: Redis caching layer is implemented for expose endpoint for /v1/everflow/news and /v1/everflow/news/{id}
      Redis will keep data in Caching for 5 minutes after that it will make query to again database and put it in cache

      To update Redis Cache time , you can update in application.yml file with ;time-to-live: 20000' field.



Run project:

1. If you have not installed a mysql and redis on your machine, you can use docker-compose.yml file to start mysql and redis on docker engine
    
	docker-compose up -d

2. Start application using maven command

   mvn spring-boot:run
   
   It will start server by default on 8080 port and if you want to test the exposed endpoint you can use swagger page to hit the endpoint
   
   You can access swagger page on http://localhost:8080/swagger-ui.html
   
3. To make docker image use below command (Docker is required to installed your machine)
 
   mvn clean package docker:build
    



	
Mysql database schema:

  mysql> describe news;
+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| news_id      | int(11)      | NO   | PRI | NULL    | auto_increment |
| description  | text         | YES  |     | NULL    |                |
| published_at | bigint(20)   | NO   |     | NULL    |                |
| title        | varchar(200) | YES  |     | NULL    |                |
| url          | varchar(255) | YES  |     | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+
5 rows in set (0.01 sec)





Request URL: GET /v1/everflow/news/{id}

{
  "title": "Martin Shkreli's company lawyer sentenced to 18 months for aiding fraud",
  "description": "Martin Shkreli’s cohort in crime may be an Eagle Scout who has devoted his life to serving others, but that didn’t save Evan Greebel from a prison sentence for aiding the \"Pharma Bro\" in an $11-million fraud. Greebel was ordered Friday to serve 18 months behi…",
  "url": "http://www.latimes.com/business/la-fi-evan-greebel-sentence-20180817-story.html",
  "publishedAt": 1534543868000,
  "news_id": 4
}

Request URL: GET /v1/everflow/news

Response For :

[
  {
    "title": "'Little Red' 1967 Ford Mustang Shelby GT500 found after 50 years, could be worth millions",
    "description": "Seek and ye shall find.",
    "url": "http://www.foxnews.com/auto/2018/08/17/little-red-1967-ford-mustang-shelby-gt500-found-after-50-years-could-be-worth-millions.html",
    "publishedAt": 1534554353000,
    "news_id": 1
  },
  {
    "title": "Google's Brin Cops to Plan to Reclaim Lost Decade in China",
    "description": null,
    "url": "https://www.bloomberg.com/news/articles/2018-08-18/google-s-brin-cops-to-plan-to-reclaim-lost-decade-in-china",
    "publishedAt": 1534552656000,
    "news_id": 2
  },
  {
    "title": "Turkey Promise, China Trade Talk Fail to Dispel Gloom: EM Review",
    "description": null,
    "url": "https://www.bloomberg.com/news/articles/2018-08-17/turkey-promise-china-trade-talk-fail-to-dispel-gloom-em-review",
    "publishedAt": 1534548713000,
    "news_id": 3
  },
  {
    "title": "Ex-lawyer of pharma executive Shkreli gets 18 months prison for fraud scheme",
    "description": "A New York lawyer was sentenced to 18 months prison on Friday for helping Martin Shkreli, currently serving a seven year prison sentence after being convicted of related charges, defraud a drug company that Shkreli had founded.",
    "url": "https://uk.reuters.com/article/uk-usa-crime-shkreli-greebel/ex-lawyer-of-pharma-executive-shkreli-gets-18-months-prison-for-fraud-scheme-idUKKBN1L22CZ",
    "publishedAt": 1534546200000,
    "news_id": 4
  },
  {
    "title": "Amazon May Challenge TiVo with DVR That Works with Fire, Streams to Smartphones",
    "description": "",
    "url": "http://fortune.com/2018/08/17/amazon-challenge-tivo-dvr-fire-streams-to-smartphones/",
    "publishedAt": 1534546098000,
    "news_id": 5
  },
  {
    "title": "Tesla Board Torn Between Service to Shareholders and CEO",
    "description": null,
    "url": "https://www.bloomberg.com/news/articles/2018-08-17/tesla-board-torn-between-service-to-shareholders-and-iconic-ceo",
    "publishedAt": 1534545190000,
    "news_id": 6
  },
  {
    "title": "Wall Street Rises on Upbeat Trade News",
    "description": "U.S. stocks closed higher on Friday, with the S&P 500 and the Dow Jones Industrial Average extending gains and the Nasdaq turning positive on reports of progress in tariff disputes between the United States and its trading partners China and Mexico.",
    "url": "https://www.nytimes.com/reuters/2018/08/17/business/17reuters-usa-stocks.html",
    "publishedAt": 1534539705000,
    "news_id": 7
  },
  {
    "title": "Turkey Cut Deeper Into Junk as S&P Sees Recession Next Year",
    "description": null,
    "url": "https://www.bloomberg.com/news/articles/2018-08-17/turkey-cut-deeper-into-junk-by-s-p-on-risk-of-lira-volatility",
    "publishedAt": 1534539429000,
    "news_id": 8
  },
  {
    "title": "Here's why you need to pay attention to Cava's acquisition of Zoes Kitchen",
    "description": "Panera Bread founder Ron Shaich heads up Act III Holdings, the investment fund that offered to help finance Cava's acquisition of Zoes. Should the deal go through, he will become chairman of the private company.",
    "url": "https://www.cnbc.com/2018/08/17/pay-attention-to-cavas-proposed-acquisition-of-zoes-kitchen.html",
    "publishedAt": 1534537842000,
    "news_id": 9
  },
  {
    "title": "Murphy urges Lincoln Tunnel commuters to pursue other options",
    "description": "Gov. Phil Murphy made a last-minute pitch to commuters about not driving on Route 495 as two lanes on a bridge close down tonight for two years plus years of construction.",
    "url": "https://www.nj.com/traffic/index.ssf/2018/08/traffic_snarling_route_495_construction_is_here_mu.html",
    "publishedAt": 1534537261000,
    "news_id": 10
  },
  {
    "title": "The Best Of Times? Micron And The Industry State Their Case At The Flash Memory Summit",
    "description": "The semiconductor memory and storage industry is maturing. Godot and everybody else are waiting for Optane DIMMS to appear. New memory?  What new memory?",
    "url": "https://seekingalpha.com/article/4200207-best-times-micron-industry-state-case-flash-memory-summit",
    "publishedAt": 1534536085000,
    "news_id": 11
  },
  {
    "title": "EpiPen shortage raises alarm for parents as kids head back to school",
    "description": "A widespread shortage of the life-saving allergy medication just as parents are trying to restock for school and home.",
    "url": "https://www.washingtonpost.com/business/2018/08/16/epipen-shortage-raises-alarm-parents-kids-head-back-school/",
    "publishedAt": 1534535476000,
    "news_id": 12
  },
  {
    "title": "Trump calls on regulators to consider changing how often companies must report earnings",
    "description": "This could be a major shift for corporate America.",
    "url": "https://www.washingtonpost.com/business/2018/08/17/trump-calls-regulators-consider-changing-how-often-companies-report-earnings/",
    "publishedAt": 1534530610000,
    "news_id": 13
  },
  {
    "title": "Hold the Bubbly, Mr. President: Youth Jobs Are Far From Record",
    "description": null,
    "url": "https://www.bloomberg.com/news/articles/2018-08-17/hold-the-bubbly-mr-president-youth-jobs-are-far-from-record",
    "publishedAt": 1534529377000,
    "news_id": 14
  },
  {
    "title": "Harley-Davidson: Don't Hop On This Bike Just Yet",
    "description": "Unexpected growth coming from our overseas neighbours. Product development may be the key to outstanding performance. New politics could lead to disastrous resu",
    "url": "https://seekingalpha.com/article/4200112-harley-davidson-hop-bike-just-yet",
    "publishedAt": 1534528980000,
    "news_id": 15
  },
  {
    "title": "476 sick in parasite outbreak linked to McDonald's salads",
    "description": "The number of people infected with a parasite linked to McDonald's salads has grown to 476, the U.S. Food and Drug Administration said Thursday.",
    "url": "https://www.nbcnews.com/health/health-news/476-sick-parasite-outbreak-linked-mcdonald-s-salads-n901641",
    "publishedAt": 1534523280000,
    "news_id": 16
  },
  {
    "title": "US Consumer Sentiment Soured in August",
    "description": "U.S. consumer sentiment slid in August to its lowest level in nearly a year, as consumers registered concern about rising prices.",
    "url": "https://www.wsj.com/articles/u-s-consumer-sentiment-soured-in-august-1534519043",
    "publishedAt": 1534519111000,
    "news_id": 17
  },
  {
    "title": "CEOs were paid 312 times more than the average employee last year",
    "description": "The income gap keeps growing. Chief executives at 350 of the largest companies in the U.S. now make 312 times more than their average employee, research from the Economic Policy Institute found.\nCompensation for CEOs keeps growing, The Hill reported Friday, w…",
    "url": "http://theweek.com/speedreads/790910/ceos-paid-312-times-more-than-average-employee-last-year",
    "publishedAt": 1534517520000,
    "news_id": 18
  },
  {
    "title": "Louisiana Bans Bank of America, Citi from Bond Sale Over Gun Policies",
    "description": null,
    "url": "https://www.bloomberg.com/news/articles/2018-08-17/bofa-citi-banned-from-louisiana-bond-sale-due-to-gun-policies",
    "publishedAt": 1534516752000,
    "news_id": 19
  },
  {
    "title": "Panasonic Will Survive Its Tesla Codependency",
    "description": null,
    "url": "https://www.bloomberg.com/view/articles/2018-08-17/panasonic-will-survive-its-tesla-codependency",
    "publishedAt": 1534487720000,
    "news_id": 20
  }
]


```