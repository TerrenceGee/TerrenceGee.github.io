# JavaScript Promise

The Promise object represents the eventual completion (or failure) of an asynchronous operation and its resulting value.

## Using Promises

A Promise is an object representing the eventual completion or failure of an asynchronous operation.

### Consumption

```js
function successCallback(result) {
    console.log(`Audio file ready at URL: ${result}`);
}

function failureCallback(error) {
    console.error(`Error generating audio file: ${error}`);
}

createAudioFileAsync(audioSettings, successCallback, failureCallback);
```

use a promise instead

```js
createAudioFileAsync(audioSettings).then(successCallback, failureCallback);
```

**Convention**

- Chaining

old styles causes callback hell

```js
doSomething(function (result) {
    doSecondThing(result, function (secondResult) {
        doThirdThing(secondResult, function (thirdResult) {
            console.log(`Got the final result: ${thirdResult}`);
        }, failureCallback);
    }, failureCallback);
}, failureCallback);
```

attach callback to promise object instead of function

```js
const promise = doSomething();
const promise2 = promise.then(successCallback, failureCallback);
```

promise template

```js
function doSomething() {
    return new Promise((resolve) => {
        setTimeout(() => {
            console.log("Did something");
            resolve("https://example.com/");
        }, 200);
    });
}
```

```js
doSomething()
    .then(function (result) {
        return doSomethingElse(result);
    })
    .then(function (newResult) {
        return doThirdThing(newResult);
    })
    .then(function (finalResult) {
        console.log(`Got the final result: ${finalResult}`);
    })
    .catch(failureCallback);
// express this with arrow function instead
doSomething()
  .then((result) => doSomethingElse(result))
  .then((newResult) => doThirdThing(newResult))
  .then((finalResult) => {
    console.log(`Got the final result: ${finalResult}`);
  })
  .catch(failureCallback);
```

use async/await

```js
async function logIngredients() {
    const url = await doSomething();
    const res = await fetch(url);
    const data = await res.json();
    listOfIngredients.push(data);
    console.log(listOfIngredients);
}

### Creation
