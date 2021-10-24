# url-shortener-application


created a URL Shortner Application.

I have developer the below API.

/generate -- It will generate a short URL. /{shortLink} 
-- It will redirect to OriginalUrl /getAll 
-- It will fetch all existing urls present in H2 DB.

Note: I have used date time to get every time different short name and ensuring that there should not be a duplicate short name.

=================================================================

In the postman url add - http://localhost:8080/generate and select HTTP - POST and in body provide below request Body: { "url": "https://www.twitter.com/" } you will get shortner url name as below.

{ "originalUrl": "https://www.twitter.com/", "shortUrl": "4015b49f" }
if you pass short url in end point it will redirect to original url for example - http://localhost:8080/a048437f it will redirect to google.com as "originalUrl": "https://www.facebook.com/

=============================================================
if you call /getAll API

it wil give response as example below

[ { "originalUrl": "https://www.facebook.com/", "shortUrl": "3442c91c" }, { "originalUrl": "https://www.google.com/", "shortUrl": "a048437f" }, { "originalUrl": "https://www.google.com/", "shortUrl": "0ebcdfed" } ]

