# Primality Test

This service determines whether a number is prime or not. The input to the service is a number in the URL parameter "number", and the output is a JSON blob with the result, as well as any error messages.

## Setup

This project is a GAE project, developed using Intellij IDE. If you are interested in contributing code, please follow the guides at https://cloud.google.com/appengine/docs/standard/java/download. Of course, please request deployment permissions :)

## API

This service takes a `GET` request to `https://helloprime-207201.appspot.com/is_prime` with a parameter of `number`, which is expected to be an integer.

```
curl https://helloprime-207201.appspot.com/is_prime?number=7
```

The response is a JSON object like

```
{"result":true}
```

Note: you can also use your browser directly for the request.

