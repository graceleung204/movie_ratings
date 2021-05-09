# movie_ratings

## connection:
mongodb+srv://dbUser:dbUserPassword@cluster0.zsakm.mongodb.net/movie_ratings?retryWrites=true&w=majority

## Import imdb data
### To sharded server:
```
mongoimport --uri "mongodb+srv://dbUser:dbUserPassword@cluster0.zsakm.mongodb.net/movie_ratings?retryWrites=true&w=majority" -c ratings --type tsv --file title.ratings.t
sv --headerline
```
...

### Local test instance
```
mongoimport --authenticationDatabase admin --username admin --password cmpe172 -d movie -c title --type tsv --file title.tsv --headerline
mongoimport --authenticationDatabase admin --username admin --password cmpe172 -d movie -c ratings --type tsv --file title.ratings.tsv --headerline
mongoimport --authenticationDatabase admin --username admin --password cmpe172 -d movie -c principals --type tsv --file principals.tsv --headerline
mongoimport --authenticationDatabase admin --username admin --password cmpe172 -d movie -c crew --type tsv --file crew.tsv --headerline
```

